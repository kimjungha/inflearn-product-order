package com.example.inflearnproductorderservice.product;

import org.springframework.stereotype.Component;

@Component
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
