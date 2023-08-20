package com.example.ex02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// =>@SpringBootConfiguration // 사용자가 추가적으로 빈, 설정 클래스들을 등록 가능하게 함
// =>@ComponentScan // 현 패키지 하위에서 자동으로 컴포넌트를 검색하도록 지정하는 역할
// =>@EnableAutoConfiguration // 자동 설정

public class Springbootex02Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootex02Application.class, args);
	}

}
