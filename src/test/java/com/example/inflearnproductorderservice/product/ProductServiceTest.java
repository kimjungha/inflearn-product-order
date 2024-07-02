package com.example.inflearnproductorderservice.product;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

class ProductServiceTest {
    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
     void setUp() {
        productRepository = new ProductRepository();
        productPort = new ProductPortAdapter(productRepository);
        productService = new ProductService(productPort);

    }

    @Test
    void 상품등록() {
        final String name = "상품명";
        final int price = 10000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;

        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        productService.addProduct(request);

    }

    /**
     * 3. 메모리에 저장하기 위한 레파지토리
     */
    private class ProductRepository {
        private Map<Long, Product> persistence = new HashMap<>();
        private Long seq = 0L;

        public void save(Product product) {
            product.assignId(++seq);
            persistence.put(product.getId(),product);
        }
    }
    

    /**
     * 2-3. ProductPort 구현체
     */
    public class ProductPortAdapter implements ProductPort {

        // 생성자로 주입
        private final ProductRepository productRepository;

        public ProductPortAdapter(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public void save(final Product product) {
            productRepository.save(product);

        }
    }

    /**
     * 2-2. 서비스 단에서 save 메서드 부르기 위한 인터페이스
     */
    private interface ProductPort {

        void save(Product product) ;

    }

    /**
     * 2-1. 저장 되는 클래스
     */
    private class Product {

        private Long id;
        private final String name;
        private final int price;
        private final DiscountPolicy discountPolicy;

        public Product(final String name, final int price, final DiscountPolicy discountPolicy) {
            // 저장 되는 클래스에서 한번 더 validation
            Assert.hasText(name, "need");
            Assert.isTrue(price > 0, "need");
            Assert.notNull(discountPolicy, "need");
            this.name = name;
            this.price = price;
            this.discountPolicy = discountPolicy;
        }

        public void assignId(final Long id) {
            this.id = id;
        }

        //@Getter 애노테이션을 사용하면 테스트가 실패함 -> 런타임 안해서 getter 를 못 가져오는 거 같음
        public Long getId() {
            return id;
        }
    }

    /**
     * 2. 서비스 class 생성
     */
    private class ProductService {
        private final ProductPort productPort;

        private ProductService(ProductPort productPort) {
            this.productPort = productPort;
        }

        public void addProduct(AddProductRequest request) {
           final Product product =  new Product(request.name(),request.price(),request.discountPolicy());
            productPort.save(product);
        }
    }

    /**
     * 1. request 값을 가질 dto 역할을 하는 record 생성
     */
    private record AddProductRequest(String name, int price
        ,DiscountPolicy discountPolicy
    ) {
        //request 값 validation
        private AddProductRequest {
            Assert.hasText(name, "need");
            Assert.isTrue(price > 0, "need");
            Assert.notNull(discountPolicy, "need");
        }

    }

    /**
     * 1-1. Request 에서 사용하는 enum
     */
    public enum DiscountPolicy {
        NONE
    }



}
