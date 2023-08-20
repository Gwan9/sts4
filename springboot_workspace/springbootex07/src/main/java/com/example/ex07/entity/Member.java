package com.example.ex07.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity // entity : db테이블 설계단계
@Table(name="member")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// 각 데이터베이스에 따라 기본키를 자동으로 설정
	private Long no;
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String motive;
	private String email;
	private String enabled;
}
