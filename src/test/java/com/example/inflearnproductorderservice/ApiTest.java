package com.example.inflearnproductorderservice;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiTest {
    @Autowired
    private DatabaseCleanup databaseCleanup;

    @BeforeEach
    void setUp() {
        if(RestAssured.port ==RestAssured.UNDEFINED_PORT){
            RestAssured.port = 8080;
            databaseCleanup.afterPropertiesSet();  //지워야하는 테이블 명 setting
        }

        databaseCleanup.execute(); //테이블 내 데이터 지우기 -> 테스트끼리 연관 없기 위해서
        // seq 도 1로 하기에 나중에 테스트 깨질일이 없다.

    }
}
