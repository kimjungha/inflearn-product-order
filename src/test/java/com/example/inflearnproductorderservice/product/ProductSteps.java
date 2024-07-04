package com.example.inflearnproductorderservice.product;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

//control + t  = extract delegates 기능 통해 한번에 클래스 추출
public class ProductSteps {
    public static ExtractableResponse<Response> 상품등록요청(AddProductRequest request) {
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

    public static AddProductRequest 상품등록요청_생성() {
        final String name = "상품명";
        final int price = 10000;
        final DiscountPolicy discountPolicy = DiscountPolicy.NONE;

        final AddProductRequest request = new AddProductRequest(name, price, discountPolicy);
        return request;
    }
}