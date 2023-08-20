package kr.co.jhta.springboot12.service;

import java.util.List;

import kr.co.jhta.springboot12.dto.BoardDTO;

public interface BoardService {
	public List<BoardDTO> selectAll(int startNo, int endNo);
	
	public BoardDTO selectOne(int bno);
	public void modifyOne(BoardDTO dto);
	public void addOne(BoardDTO dto);
	public void removeOne(int bno);
	public int getTotal();
}