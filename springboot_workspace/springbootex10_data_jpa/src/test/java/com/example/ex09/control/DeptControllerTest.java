package com.example.ex09.control;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
class DeptControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void testJson() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/deptjson"))
				// 실행하고 결과를 출력
				.andDo(print())
				// 페이지가 정상 요청 상태인지 검사
				.andExpect(status().isOk())
				// 컨텐츠의 종료가 JSON에 맞는지 검사
				.andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	@Test
	public void testGetDname() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getDname")
				.param("deptno", "10"))
				.andDo(print())
				.andExpect(content().string("ACCOUNTING : 10"));
	}
	@Test
	public void testNotFind() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/show"))
				.andDo(print())
				//.andExpect(status().isOk()); // 200http status
				//.andExpect(status().isNotFound());
				//.andExpect(status().is(200)); // 상태번호
				//.andExpect(status().isInternalServerError()); // 500번
				.andExpect(status().isMethodNotAllowed()); // 405번
	}
	
	
	
}
