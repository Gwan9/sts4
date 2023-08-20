package kr.co.jhta.springboot12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.springboot12.dao.BoardDAO;
import kr.co.jhta.springboot12.dto.BoardDTO;
import kr.co.jhta.springboot12.dto.StartEnd;

@Service
public class BoardOracleService implements BoardService {

	@Autowired
	private BoardDAO dao;
	

	
	@Override
	public List<BoardDTO> selectAll(int startNo, int endNo) {
		StartEnd se = new StartEnd(startNo, endNo);
		return dao.getAll(se);
	}
	@Override
	public BoardDTO selectOne(int bno) {
		// TODO Auto-generated method stub
		return dao.selectOne(bno);
	}

	@Override
	public void modifyOne(BoardDTO dto) {
		dao.modifyOne(dto);
		
	}

	@Override
	public void addOne(BoardDTO dto) {
		dao.addOne(dto);
		
	}

	@Override
	public void removeOne(int bno) {
		dao.removeOne(bno);
		
	}

	@Override
	public int getTotal() {
		return dao.getTotal();
	}
	

}
