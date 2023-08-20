package com.example.ex11.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.ex11.dto.DeptDTO;

@Repository
@Mapper // 이 인터페이스를 매핑시켜줘
public interface Dao {
	public List<DeptDTO> getAll();
	// com.example.ex11.dao.Dao.getAll; <== mapper 에 이 이름으로 찾기
	public DeptDTO getOne(int no);
}
