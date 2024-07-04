package com.example.inflearnproductorderservice.product;

import org.springframework.util.Assert;

record GetProductResponse(
    long id,
    String name,
    int price,
    DiscountPolicy discountPolicy
) {
    GetProductResponse {
        Assert.notNull(id, "id need");
        Assert.hasText(name, "name need");
        Assert.isTrue(price > 0, "price need");
        Assert.notNull(discountPolicy, "discountPolicy need");
    }
}
