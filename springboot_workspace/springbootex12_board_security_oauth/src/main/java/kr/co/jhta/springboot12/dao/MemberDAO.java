package kr.co.jhta.springboot12.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.jhta.springboot12.dto.MemberDTO;

@Repository
@Mapper
public interface MemberDAO {
	
	
	MemberDTO getMemberByEmail(String email);
	
	void insertOne(MemberDTO dto);

	void addRole(String email);

}
