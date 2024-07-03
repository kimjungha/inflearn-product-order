package com.example.inflearnproductorderservice.product;

import org.springframework.util.Assert;

/**
 * 1. request 값을 가질 dto 역할을 하는 record 생성
 */
record AddProductRequest(String name, int price
    , DiscountPolicy discountPolicy
) {
    //request 값 validation
    AddProductRequest {
        Assert.hasText(name, "need");
        Assert.isTrue(price > 0, "need");
        Assert.notNull(discountPolicy, "need");
    }

}
