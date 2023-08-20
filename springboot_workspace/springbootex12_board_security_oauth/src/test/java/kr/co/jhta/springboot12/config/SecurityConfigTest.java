package kr.co.jhta.springboot12.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SecurityConfigTest {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void testPasswordEncoder() {

		//암호화가 잘 되는지 테스트
		String password = "aaa";
		String enPw = passwordEncoder.encode(password);
		
		System.out.println("암호화 비밀번호 : " + enPw);
		
		boolean matcherResult = passwordEncoder.matches(password, enPw);
		System.out.println("매칭결과 : " + matcherResult);
		
		assertTrue(matcherResult);
	}

}
