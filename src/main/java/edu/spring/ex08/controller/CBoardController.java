package edu.spring.ex08.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex08.domain.CBoardVO;
import edu.spring.ex08.domain.NBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;
import edu.spring.ex08.pageutil.PageMaker;
import edu.spring.ex08.service.CBoardService;

@Controller// 컨트롤러라는 걸 알려주는 어노테이션 

@RequestMapping(value="/cboard")
public class CBoardController {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(CBoardController.class);
	
	@Autowired // 스팸번호 게시판 서비스 호출하기.
	private CBoardService cboardService;

	@GetMapping("/clist") // 스팸번호 게시판 리스트 화면으로 가기 위한 주소
	public void clist(Model model, Integer page, Integer numsPerPage) {
		LOGGER.info("clist() 호출");
		
		LOGGER.info("page =" + page + ", numsPerPage=" + numsPerPage);
		
		//< Paging 처리. 11-23 > 
		
		PageCriteria criteria = new PageCriteria();
		
		if(page != null) {
			criteria.setPage(page);
		}
		
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		
		List<CBoardVO> list = cboardService.read(criteria);
		// 리스트 만들었으니 보내야한다.
		// 미생성 오류 11.23
		
		// 리턴타입이 string가 아닌 void면 jsp를 스프링이 자동으로 경로 찾아서 화면 리턴 
		//string로 하면 clit라고 리턴하면 /cboard/clist라는 jsp 리턴한다는 의미. 11.23
	
		LOGGER.info("리스트 뜨는지 확인하는 로그.-=-=-=-=-=-=-=-=-= " + list.toString());
			
		model.addAttribute("clist", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(cboardService.getTotalNumsOfRecords());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
		
	}// end clist
	
	@GetMapping("/cregister")
	public void cregisterGET() {
	// 글 등록하기 위해서 화면으로 가는 URL
	LOGGER.info("cregisterGET() 호출");	
	// public string cregisterGET() {
	// return "cboard/cregister"; 11-23
	// 호출하는 url과 jsp 이름이 다른 경우에 void 쓰면 안된다. 스프링이 못 찾는다. 11-23 
	
	}// end cregister
	
	
	@PostMapping("/cregister")
	public String cregisterPOST(CBoardVO vo, RedirectAttributes reAttr) {
		LOGGER.info("cregisterPOST() 호출");
		LOGGER.info(toString());
		int result = cboardService.create(vo);
		LOGGER.info(result + " 행 삽입");
		
		
		
		// 등록성공 
		if(result == 1) {
			
		  reAttr.addFlashAttribute("insert_result", "success");
		  return "redirect:/cboard/clist";
	} else {
		  reAttr.addFlashAttribute("insert_result", "fail");
		  return "redirect:/cboard/cregister";
		
	}
	
	}// end cregister 11-24
	
	
	@GetMapping("/cdetail")
	public void detail ( Model model, Integer bno, Integer page) {
		LOGGER.info("cdetail() 호출 : bno = " + bno);
		
		CBoardVO vo = cboardService.read(bno); // read service에서 
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		
		
	} // end cdetail 11.24
	
	
	@GetMapping("/cupdate")
	public void updateGET(Model model, Integer bno, Integer page) {
		LOGGER.info("cupdateGET() 호출 : bno = " + bno);
		CBoardVO vo = cboardService.read(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		
		
		}// end cupdate 11.24
	
	
	@PostMapping("/cupdate") 
	public String updatePUT(CBoardVO vo, Integer page) {
		LOGGER.info("updatePUT() 호출 : bno= " + vo.getBno());
		
		int result = cboardService.update(vo);
		
		if(result == 1) {
			return "redirect:/cboard/clist?page=" + page;
		} else {
			return "redirect:/cboard/cupdate? bno=" + vo.getBno();
		}	
		}// end update 11-24
	
	
	
	@GetMapping("/cdelete")
	public String delete(Integer bno) {
		LOGGER.info("cdelete() 호출 : bno = " + bno);
		int result = cboardService.delete(bno);
		if(result == 1) {
			return "redirect:/cboard/clist";
		} else {
			return "redirect:/cboard/clist";
		}	
		}
	@GetMapping("/searchCList") // 11-27 기존 clist로 위에 목록 불러오는 clust와 중복. 그래서 searchNList로 변경.
	@ResponseBody // @ResponseBody 가 붙은 파라미터에는 HTTP 요청의 분문 body 부분이 그대로 전달된다
	// 출처: https://cheershennah.tistory.com/179 [Today I Learned. @cheers_hena
	// 치얼스헤나]

	public ModelAndView cslist(@RequestParam(defaultValue = "ctitle") String searchOption,
			@RequestParam(defaultValue = "") String keyword) throws Exception {
		// @RequestParam(가져올 테이터의 이름) [데이터 타입] [가져온 데이터를 담을 변수]
		// https://hongku.tistory.com/119
		/*
		 * int page, Integer numsPerPage
		 */
		// 레코드의 갯수 11-26 @RequestPara(defaultValue="") Object count 지움

		// 게시판 게시된 총 글 조회 (count)
		int count = cboardService.getTotalNumsOfRecords();
		List<NBoardVO> list = cboardService.listAll(searchOption, keyword);
		

		ModelAndView mav = new ModelAndView(); // mav 객체(소프트웨어 세상에서 구현할 대상)를 생성한다 나 사용할거야~ 
		LOGGER.info(searchOption + "여기 제목 타입 뜨는지");
		Map<String, Object> map = new HashMap<String, Object>();

//		Hash Map 11-27
//
//		말 그대로 Hashing 된 map이다. 
//
//		그럼 해싱의 의미는 뭐지? - > 분산기억법 즉  하나의 문자열을 
//		빠르게 찾을 수 있게 짧은 길이의 값이나 키로 변환하는 것.
//
//		해싱 맵.
//
//		문자열 -> 해시 키 계산 -> 키에 해당하는 장소에 문자열 저장 ex)나이(key) value(28) ->
//		해시키 계산으로 쉽게 찾을 수 있다.
//		해쉬맵은 키를 해싱 윗 하여 자료를 저장하고 꺼내오기에 속도가 빠르다.
//
//
//		단점으로 키와 값 등등 데이터를 흩어뜨려 놓기에 메모리를 많이 먹는다.
//
//
//		ex) Map<String,Integer> map=new HashMap(); 
//		map.put("A", 100);
//		System.out.println(map);
//				System.out.println(map.get("A"));
		// 결과 
//		{A=100,}
//		100
		
		/*
		 * map.put("nlist", list);
		 *  map.put("count", count);// 레코드의 갯수
		 * map.put("searchOption",searchOption); 
		 * // 검색옵션 .put("keyword", keyword); //
		 * 검색키워드
		 */
		// Paging 처리

		
		// 리턴 타입이 string가 아닌 void면 jsp를 스프링이 자동으로 경로 찾아서 화면 리턴
		// string로 하면 nlist라고 리턴하면 /nboard/nlist라는 jsp 리턴한다는 의미. 11.12
		// 리스트 만들었으니 보내야한다.

		mav.addObject("clist", list); // 데이터를 보낼때는 addObject 메소드를 활용하기에.
		// 왜? 안됬냐면 여기 부분에 데이터를 보내주는데에 map을 보낸다고 입력했기에 jsp에는 nlist를 받아야하는데 map을 보낸다고 했으니 안됨
		// addObject의 의미를 몰라서 문제가 생겼다.
		//11-26
		
		mav.setViewName("cboard/clist");// view의 경로. 
		
		return mav; // mav modelandview 반환 
	}
	
	
	
	
	
	
	
	
	
}// end 
