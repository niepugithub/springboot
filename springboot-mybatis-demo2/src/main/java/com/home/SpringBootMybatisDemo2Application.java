package com.home;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.home.dao"})
public class SpringBootMybatisDemo2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisDemo2Application.class, args);
	}
}
