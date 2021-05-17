package com.study.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class SpringBootStudyApplication {

	@RequestMapping("/")
	String index() {
		return "hello spring boot project!";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudyApplication.class, args);
	}
	

}
