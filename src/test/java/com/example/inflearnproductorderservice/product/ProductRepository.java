package com.example.inflearnproductorderservice.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository

/**
 * 3. 메모리에 저장하기 위한 레파지토리
 */
class ProductRepository {
    private Map<Long, Product> persistence = new HashMap<>();
    private Long seq = 0L;

    public void save(Product product) {
        product.assignId(++seq);
        persistence.put(product.getId(), product);
    }
}
