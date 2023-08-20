package com.example.ex11.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ex11.dao.Dao;
import com.example.ex11.dto.DeptDTO;
import com.example.ex11.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DbController {
	
	@Autowired
	DeptService service;
	
	@GetMapping("/home")
	public String home(Model model, DeptDTO dto) {
		model.addAttribute("msg", "안녕하세요");
		model.addAttribute("list", service.getAll());
		model.addAttribute("dto", dto);
		log.info(">>>>>>>>>> /home");
		return "home";
		
	}
	@GetMapping("/getDept")
	public String dept(
			@RequestParam("deptno")int no,
			Model model
			) {
		
		model.addAttribute("dto", service.getOne(no));
		return "dept";
	}
}
