package com.example.ex09.dao;

import java.util.List;


import com.example.ex09.dto.DeptDTO;


public interface Dao {
	public List<DeptDTO> getAll();
	public DeptDTO getOne(int no);
}
