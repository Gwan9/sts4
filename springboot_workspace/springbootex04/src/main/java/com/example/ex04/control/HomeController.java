package com.example.ex04.control;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ex04.dto.SampleDTO;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/ex1")
	public void ex1() {
		System.out.println(" ex1 >>>>>>>>>>>>>>>>>>>>");
	}
	@GetMapping({"/ex2"})
	public void ex2(Model model) {
		List<SampleDTO> list = new ArrayList<SampleDTO>();
		for(Long i=1L;i<10L;i++) {
			SampleDTO dto = SampleDTO.builder()
										.sno(i)
										.first("scott"+i)
										.last("tiger"+i)
										.regTime(LocalDateTime.now())
										.build();
//			SampleDTO dto = new SampleDTO();
//			dto.setSno(i);
//			dto.setFirst("scott"+i);
//			dto.setLast("tiger"+i);
//			dto.setRegTime(LocalDateTime.now());
			list.add(dto);
		}
		model.addAttribute("list", list);
		System.out.println(" list :" + list);
	}
}
