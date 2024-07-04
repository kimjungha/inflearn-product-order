package com.example.inflearnproductorderservice.product;

import org.springframework.data.jpa.repository.JpaRepository;


/**
 * 3. 메모리에 저장하기 위한 레파지토리
 */
interface ProductRepository extends JpaRepository<Product,Long> {

}
