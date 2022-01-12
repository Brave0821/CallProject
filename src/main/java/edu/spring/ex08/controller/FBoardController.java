package edu.spring.ex08.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex08.domain.FBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;
import edu.spring.ex08.pageutil.PageMaker;
import edu.spring.ex08.service.FBoardService;

@Controller // 컨트롤러라는걸 알려주는 어노테이션.

@RequestMapping(value="/fboard")
public class FBoardController {
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(FBoardController.class);
	
	@Autowired // 자유게시판 서비스 호출하기.
	private FBoardService fboardservice;
	
	
	@GetMapping("/flist") // 자유게시판 리스트 화면을 가기 위한 주소
	public void nlist(Model model, Integer page, Integer numsPerPage) {
		LOGGER.info("flist() 호출");
	
		LOGGER.info("page =" + page + ", numsPerPage=" +numsPerPage);
		
		// Paging 처리 
		PageCriteria criteria = new PageCriteria();
		
		if(page != null) {
			criteria.setPage(page);
		}
	
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}

	
	List<FBoardVO> list = fboardservice.read(criteria);
	model.addAttribute("flist",list);
	
	PageMaker pageMaker = new PageMaker();
	pageMaker.setCriteria(criteria);
	pageMaker.setTotalCount(fboardservice.getTotalNumsOfRecords());
	pageMaker.setPageData();
	model.addAttribute("pageMaker",pageMaker);
	// 알트 쉬프트 알 전체 바꾸기 
	
} // end list
	
	
	@GetMapping("/fregister")
	public void fregisterGET() {
		// 글 등록하기 위해 화면으로 가는 url
		LOGGER.info("fregisterGET() 호출");
		
		// public string fregisterGET() {
		// return "fboard/fregister"; 호출경로. 11.12
		// 호출하는 url과 jsp 이름이 다른 경우에 void 쓰면 안댐 스프링이 못 찾음 11.12
		
	}// end fregister()
	
	
	
	@PostMapping("/fregister")
	public String fregisterPOST(FBoardVO vo, RedirectAttributes reAttr) {
		// 11.12 RedirectAttributes
		// 재경로 위치에 속성값(Attributes) 전송하는 객체 
		// sendredirect get 방식
		LOGGER.info("fregisterPOST() 호출");
		LOGGER.info(vo.toString());
		int result = fboardservice.create(vo);
		LOGGER.info(result + "행 삽입");
		// 실제 글을 등록해주는 url
		
		// 등록 성공.
		if(result == 1) {
			// "insert_result", 의 키이름 가진 데이터 전송 
			// 리다이렉트(redirect)는
			// 사용자가 어떤 URL로 웹 서버를 요청했을때 다른 URL로 넘겨주는 것을 말합니다. 
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/fboard/flist"; // url 성공시 nboard/nlist로 이동.
		} else {
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/fboard/fregister"; // 실패시 nboard/nregister로 이동.	
		}
		
	}//end nregister 11.12 
	
	
	@GetMapping("/fdetail")
	public void detail( Model model, Integer bno, Integer page) {
		LOGGER.info("fdetail() 호출 : bno = " + bno);
		// 11-18 JSP를 불러오고 그 게시물의 정보를 불러온다.
		FBoardVO vo = fboardservice.read(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		
	}//11/18
	
	
	
	
	@GetMapping("/fupdate")
	public void updateGET(Model model, Integer bno, Integer page) {
	LOGGER.info("fupdateGET() 호출 : bno = " + bno);
	FBoardVO vo = fboardservice.read(bno);
	model.addAttribute("vo", vo);
	model.addAttribute("page", page);
	}
	
	
	
	
	
	@PostMapping("/fupdate")
	public String updatePUT(FBoardVO vo, Integer page) {
	LOGGER.info("fupdatePUT() 호출 : bno =" + vo.getBno());	
	int result = fboardservice.update(vo);	
	
	if(result == 1) {
		return "redirect:/fboard/flist?page=" + page;
	} else {
		return "redirect:/fboard/fupdate?bno=" + vo.getBno();
		// 11-18 업데이트는 기존에 있는 걸 계속 바꾼는 것!
	}		
	}
	
	
	@GetMapping("/fdelete")
	public String delete(Integer bno) {
	LOGGER.info("fdelete() 호출 : bno = " + bno);
	int result = fboardservice.delete(bno);
	
	if(result == 1) {
		return "redirect:/fboard/flist";
	} else {
		return "redirect:/fboard/flist";	
	}	
	}

}// end FBoardController