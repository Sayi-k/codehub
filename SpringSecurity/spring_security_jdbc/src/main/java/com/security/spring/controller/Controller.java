package com.security.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping("/")
	public String all() {
		return "<h2>Welcome All</h2>";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h2>Welcome User</h2>";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h2>Welcome Admin</h2>";
	}
}
