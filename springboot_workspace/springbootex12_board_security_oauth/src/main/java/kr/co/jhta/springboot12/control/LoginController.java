package kr.co.jhta.springboot12.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/clogin")
	public String login() {
		return "login";
	}
	
	@GetMapping("/clogout")
	public String logout() {
		return "logout";
	}
}
