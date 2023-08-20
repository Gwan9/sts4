package com.example.ex08.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lombok.Builder;

class UserTest {

	@Test
	void test() {
		
		User user1 = new User();
		user1.setEmail("hong@gmail.com");
		user1.setName("길동");
		
		System.out.println(user1);
		System.out.println(">>>>>>>>>>>>>>>");
		
		User user2 = User.builder().name("이순신").email("Lee@gmail.com").build();
		System.out.println(user2);
		System.out.println(">>>>>>>>>>>>>>>");
		
		// user 객체 생성
		// console 에 출력
	}

}
