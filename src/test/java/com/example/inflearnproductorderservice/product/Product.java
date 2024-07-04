package com.example.inflearnproductorderservice.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
@Entity
@Table(name ="products")
@Getter
@NoArgsConstructor(access =  AccessLevel.PROTECTED)

/**
 * 2-1. 저장 되는 클래스
 */
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private  int price;
    private  DiscountPolicy discountPolicy;

    public Product(final String name, final int price, final DiscountPolicy discountPolicy) {
        // 저장 되는 클래스에서 한번 더 validation
        Assert.hasText(name, "need");
        Assert.isTrue(price > 0, "need");
        Assert.notNull(discountPolicy, "need");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

}
