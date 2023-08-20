package com.example.ex09.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex09.dto.DeptDTO;


public interface Dao extends JpaRepository<DeptDTO, Integer>{
}
