package com.example.ex07;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ex07.entity.Member;

public interface NewMemberRepository extends JpaRepository<Member, Long> {
	
	// insert : save(entity객체)
	// select : findById(keytype), getOne(keyType)
	// update : save(entity객체)
	// delete : deleteById(KeyType), delete(entity객체)
}
