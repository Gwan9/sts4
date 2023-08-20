package com.example.ex05.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import lombok.extern.slf4j.Slf4j;

@Controller
public class HomeController {
	
	
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("msg", "안녕하세요");
		return "home";
	}
}
