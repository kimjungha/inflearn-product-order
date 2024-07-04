package com.example.inflearnproductorderservice.product;


import com.example.inflearnproductorderservice.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
class ProductServiceTest extends ApiTest {

    @Test
    void 상품등록() {
        final AddProductRequest request = 상품등록요청_생성();

        //Api 요청
        final var response = 상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private ExtractableResponse<Response> 상품등록요청(AddProductRequest request) {
        ExtractableResponse<Response> response = RestAssured.given()
            .log()
            .all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .when()
            .post("/products")
            .then()
            .log()
            .all()
            .extract();
        return response;
    }

    private AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 10000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;

        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        return request;
    }


}
