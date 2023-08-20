package kr.co.jhta.springboot12.control;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test() throws Exception {
	
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andDo(print()) // 실행하고 출력
				.andExpect(model().attributeExists("list")) // 전달 속성에 list가 존재 ?
				.andExpect(model().attributeExists("map")) // 전달속성에 map이 존재?
				.andExpect(status().isOk()); // 정상페이지 ?
	}
	
}
