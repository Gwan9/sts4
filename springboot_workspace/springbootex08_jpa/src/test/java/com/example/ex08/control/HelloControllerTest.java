package com.example.ex08.control;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest // MVC 관련 테스트
class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;
	// Mock : 엉터리, 짭 
	
	@Test
	void helloWorld() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/hello-world"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string("helloworld!"));
	}
}
