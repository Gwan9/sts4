package kr.co.jhta.firstservice.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/first-service")
public class FirstServiceController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome !!!! first Service";
	}
	
	@GetMapping("/message")
	public String msg(@RequestHeader(value="first-request", defaultValue = "NONE")String header) {
		
		log.info("apigateway에서 추가한 헤더 정보 " + header);
		return header;
	}
	
	@GetMapping("/check")
	public String check(HttpServletRequest request) {
		log.info("check 호출됨");
		log.info("요청 포트 : {}" , request.getServerPort());
		return "/check : " + request.getServerPort();
	}

}
