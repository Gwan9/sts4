package com.example.ex07;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ex07.entity.Member;

import jakarta.transaction.Transactional;

@SpringBootTest
class MemberRepositoryTest {
	
	@Autowired
	NewMemberRepository nmRepository;
	
	@Test
	void testClass() {
		System.out.println(">>>>>>>>>>>>>>>>>> " + nmRepository.getClass().getName());
		
		
	}
	
	@Test
	public void testinsert() {
		Member m1 = new Member();
		m1.setName("홍길동");
		m1.setGender("남");
		m1.setEmail("hong@gmail.com");
		m1.setId("aaa");
		m1.setPw("bbb");
		m1.setMotive("친구추천");
		
		// m2 빌더를 사용해서
		Member m2 = Member.builder().name("신사임당")
											.gender("여")
											.email("shin@gmail.com")
											.id("ccc")
											.pw("ddd")
											.motive("친구추천").build();
		
		// builder
		
		// m2. builder를 이용
		
		nmRepository.save(m2);
	}
	
	@Test
	public void testSelect() {
		// 심사임당의 이메일을 네이버메일로 변경
		Long no = 1L;
		Optional<Member> result = nmRepository.findById(no);
		System.out.println("------------------------");
		if(result.isPresent()) {
			Member m3 = result.get();
			System.out.println(">>>>>>>>>>>>>>>>>>>>>> " + m3);
		}
		
	}
	@Transactional
	@Test
	public void testSelect2() {
		Long no = 1L;
		Member m2 = nmRepository.getOne(no);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> " + m2.getName());
		assertEquals("둘리", m2.getName());
	}
	
	@Transactional
	@Test
	public void testUpdate() {
		//Member m4 = Member.builder().no(1L).email("shin@naver.com").build();
		Member m4 = nmRepository.getOne(1L);
		m4.setEmail("shin@naver.com");
		nmRepository.save(m4);
	}
	
	@Test
	public void TestDelete() {
		Long no = 1L;
		nmRepository.deleteById(no);
	}
	
	

}
