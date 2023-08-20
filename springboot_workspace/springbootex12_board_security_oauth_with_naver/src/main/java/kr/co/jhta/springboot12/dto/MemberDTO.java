package kr.co.jhta.springboot12.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

		
	private int no;
	private String email;
	private String gender;
	private String id;
	private String motive;
	private String name;
	private String pw;
	private int enabled;
	
}
