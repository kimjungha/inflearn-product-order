package com.example.inflearnproductorderservice.product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductServiceTest {

    private ProductService productService;

    /**
     * 검증을 먼저 생각하면 검증 기준 코드 작성이 된다.
     */
    @Test
    void 상품조회() {

        // 상품 등록
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final Long productId =1L;

        // 상품 조회
        final GetProductResponse response = productService.getProduct(productId);

        //상품 응답 검증
        assertThat(response).isNotNull();

    }

}
