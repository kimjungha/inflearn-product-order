package com.example.inflearnproductorderservice.product;


import com.example.inflearnproductorderservice.ApiTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;
class ProductApiTest extends ApiTest {

    @Test
    public void 상품등록() {
        final AddProductRequest request = ProductSteps.상품등록요청_생성();

        //Api 요청
        final var response = ProductSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }


}
