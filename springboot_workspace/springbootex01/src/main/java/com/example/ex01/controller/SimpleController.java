package com.example.ex01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
	@GetMapping(value = "/hello")
	public String[] hello() {
		return new String[] {"Hello", "world"};
	}

}
