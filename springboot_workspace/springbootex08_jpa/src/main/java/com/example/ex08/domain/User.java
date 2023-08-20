package com.example.ex08.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RequiredArgsConstructor //NonNull 이 없으면 @NoArgsConstructor와 동일
public class User { 
	@NonNull // 이것은 필수
	private String name;
	@NonNull
	private String email;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
	
}
