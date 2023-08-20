package com.example.ex09.dto;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity // entity : db테이블 설계단계
@Table(name="dept1")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeptDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int deptno;
	String dname;
	String loc;
}
