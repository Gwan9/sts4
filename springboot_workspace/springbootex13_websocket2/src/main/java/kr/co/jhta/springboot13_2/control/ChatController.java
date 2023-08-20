package kr.co.jhta.springboot13_2.control;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ChatController {

	@GetMapping("/chat")
	public String startChatting(HttpSession session) {
		session.setAttribute("user", "user" + new Random().nextInt(100000));
		log.info("랜덤하게 만든 사용자이름 {}", session.getAttribute("user".toString()));
		return "client";
	}
}
