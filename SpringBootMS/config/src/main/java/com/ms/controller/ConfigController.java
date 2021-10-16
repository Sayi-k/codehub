package com.ms.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
	
	@Value("${main-message}")
	String message;
	
	@Value("${sub-message}")
	String subMessage;

	@GetMapping("/config")
	public String getMessage() {
		return message +" "+ subMessage;
	}
}
