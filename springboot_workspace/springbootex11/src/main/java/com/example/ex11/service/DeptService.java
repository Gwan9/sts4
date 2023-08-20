package com.example.ex11.service;

import java.util.List;

import com.example.ex11.dto.DeptDTO;

public interface DeptService {
	public List<DeptDTO> getAll();
	public DeptDTO getOne(int no);
}
