package kr.co.jhta.springboot12.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	//로그인 없이도 접근할 수 있는 곳
	@GetMapping("/public")
	public String publicTest() {
		return "public";
	}
	//로그인 없이도 접근할 수 있는 곳
	@GetMapping("/member")
	public String memberTest() {
		return "member";
	}
	//로그인 없이도 접근할 수 있는 곳
	@GetMapping("/admin")
	public String adminTest() {
		return "admin";
	}
	
}
