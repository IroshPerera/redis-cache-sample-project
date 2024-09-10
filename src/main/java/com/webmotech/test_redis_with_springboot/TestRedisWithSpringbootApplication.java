package com.webmotech.test_redis_with_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestRedisWithSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestRedisWithSpringbootApplication.class, args);
	}

}
