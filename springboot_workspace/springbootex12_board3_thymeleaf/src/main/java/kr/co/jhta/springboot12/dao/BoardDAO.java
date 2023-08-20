package kr.co.jhta.springboot12.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import kr.co.jhta.springboot12.dto.BoardDTO;
import kr.co.jhta.springboot12.dto.StartEnd;

@Repository
@Mapper
public interface BoardDAO {
	List<BoardDTO> getAll(StartEnd se);
	BoardDTO selectOne(int bno);
	void modifyOne(BoardDTO dto);
	void addOne(BoardDTO dto);
	void removeOne(int bno);
	int getTotal();
}
