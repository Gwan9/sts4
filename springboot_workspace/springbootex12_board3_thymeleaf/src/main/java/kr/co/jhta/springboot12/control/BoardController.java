package kr.co.jhta.springboot12.control;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.jhta.springboot12.dto.BoardDTO;
import kr.co.jhta.springboot12.service.BoardService;
import kr.co.jhta.springboot12.util.PageUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("/list")
	public String list(Model model, 
			@RequestParam(name="currentPage",defaultValue="1")int currentPage
			){
		// 총 게시물 수
		int totalNumber = service.getTotal();
		// 페이지당 게시물 수
		int recordPerPage = 10;
		log.info("총 게시물 수 >>>>> " + totalNumber);
		log.info("페이지당 게시물 수 >>>>> " + recordPerPage);
		log.info("현재 페이지 번호 >>>>> " + currentPage);
		
		// 총 페이지 수, 한 페이지당 수, 현재 페이지 번호
		Map<String,Object> map = PageUtil.getPageData(totalNumber, recordPerPage, currentPage);
		// map에서 꺼내옴
		int startNo = (int)map.get("startNo");
		int endNo = (int)map.get("endNo");
		model.addAttribute("list", service.selectAll(startNo, endNo));
		model.addAttribute("map", map);
		return "board/list";
	}
	
	@GetMapping("/detail")
	public String form(@RequestParam("bno")int bno, Model model) {
		model.addAttribute("dto", service.selectOne(bno));
		
		return "board/detail";
	}
	@GetMapping("/modify")
	public String modifyForm(@RequestParam("bno")int bno, Model model) {
		model.addAttribute("dto", service.selectOne(bno));
		
		return "board/modify";
	}
	@PostMapping("/modify")
	public String modifyForm(@ModelAttribute BoardDTO dto, Model model, HttpServletRequest req) {
		String ip = req.getRemoteAddr();
		dto.setIp(ip);
		service.modifyOne(dto);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/write")
	public String writeForm() {
		return "board/writeForm";
	}
	@PostMapping("/write")
	public String writeOk(@ModelAttribute BoardDTO dto, HttpServletRequest req) {
		String ip = req.getRemoteAddr();
		dto.setIp(ip);
		service.addOne(dto); // 서비스에 추가, 인터페이스에 추가, 구현 클래스에 코드 작성
		// mapper에 적당한 이름 추가
		return "redirect:/board/list";
	}
	@GetMapping("/delete")
	public String deleteOk(@RequestParam("bno")int bno) {
		service.removeOne(bno);
		return "redirect:/board/list";
	}
}
