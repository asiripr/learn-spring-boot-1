package com.example.Test02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@GetMapping("/hi")
	public String name() {
		return "Asiri";
	}
	@GetMapping("/car")
	public String beep() {
		return "Toyota";
	}
}
