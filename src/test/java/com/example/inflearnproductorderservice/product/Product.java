package com.example.inflearnproductorderservice.product;

import org.springframework.util.Assert;

/**
 * 2-1. 저장 되는 클래스
 */
class Product {

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
