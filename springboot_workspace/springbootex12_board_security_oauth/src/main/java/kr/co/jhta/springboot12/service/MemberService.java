package kr.co.jhta.springboot12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.springboot12.dao.MemberDAO;
import kr.co.jhta.springboot12.dto.MemberDTO;

@Service
public class MemberService  {
	@Autowired
	MemberDAO dao;
	
	
	public MemberDTO getMemberByEmail(String email) {
		return dao.getMemberByEmail(email);
	}


	public void addUser(MemberDTO dto) {
		dao.insertOne(dto);
	}


	public void addRole(String email) {
		dao.addRole(email);
		
	}
	
	
}
