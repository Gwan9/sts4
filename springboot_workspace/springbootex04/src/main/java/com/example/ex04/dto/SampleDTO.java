package com.example.ex04.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class SampleDTO {
	public Long sno;
	public String first;
	public String last;
	public LocalDateTime regTime;
	
}
