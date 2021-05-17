package com.study.spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/")
	public String root() {
		return "Spring Boot Test";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
