package kr.co.jhta.springboot12.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	
	@RequestMapping("/home")
	public String hello() {
		log.info(">>>>>>>>>>>>>>>>>>> /home");
		return "home";
	}
}
