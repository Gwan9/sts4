package com.example.ex05.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	
	
	@GetMapping("/home")
	public void home(Model model) {
		model.addAttribute("msg", "안녕하세영");
	}
}
