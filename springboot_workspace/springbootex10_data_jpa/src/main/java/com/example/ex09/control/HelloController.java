package com.example.ex09.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
	
	
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("msg", "안녕하세요");
		return "hello.html";
	}
	@GetMapping("/hello2")
	public String hello2() {
			
		return "redirect:/deptjson";
	}
}
