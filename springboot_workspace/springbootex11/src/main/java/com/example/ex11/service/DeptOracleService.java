package com.example.ex11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex11.dao.Dao;
import com.example.ex11.dto.DeptDTO;

@Service
public class DeptOracleService implements DeptService{
	@Autowired
	Dao dao;
	
	@Override
	public List<DeptDTO> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public DeptDTO getOne(int no) {
		// TODO Auto-generated method stub
		return dao.getOne(no);
	}

}
