package com.shivaji.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/welcome")
	public String getMsg() {
		return "You are Welcome !!!";
	}
	
	@GetMapping("/greet")
	public String greet() {
		return "Good Morning";
	}
	
	@GetMapping("/contact")
	public String getContact() {
		return "+91 9988776655";
	}
}
