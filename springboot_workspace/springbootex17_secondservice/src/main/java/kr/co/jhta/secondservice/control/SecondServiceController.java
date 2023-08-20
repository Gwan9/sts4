package kr.co.jhta.secondservice.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/second-service")
public class SecondServiceController {
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome!!!! Second Service";
	}
	@GetMapping("/message")
	public String msg(@RequestHeader(value = "second-request", defaultValue = "NONE")String header) {
		
		log.info("apigateway에서 추가한 헤더 정보 " + header);
		return header;
	}
}
