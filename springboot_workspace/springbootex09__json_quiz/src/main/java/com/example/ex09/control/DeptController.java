package com.example.ex09.control;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex09.dao.Dao;
import com.example.ex09.dto.DeptDTO;

@RestController
public class DeptController {
	
	@Autowired // Dao 인터페이스를 구현한 구현객체를 자동으로 넣어줘
	Dao dao;
	
	
	@GetMapping(value="/deptjson", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DeptDTO> getAll() {
		return dao.getAll();
	}
	
	@GetMapping("/getDname")
	public String getDname(@RequestParam("deptno")int no) {
		//dao.getOne(no).getDname();
		return dao.getOne(no).getDname()+" : "+no;
		
	}
}
