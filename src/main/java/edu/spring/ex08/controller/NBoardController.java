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

import edu.spring.ex08.domain.NBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;
import edu.spring.ex08.pageutil.PageMaker;
import edu.spring.ex08.service.NBoardService;
// 다시 한번 읽어보는 컨트롤러 사용법. 11-27
//사용자가 요청을하면 @controller로 진입
//
//요청에대한 작업 수행하고 view 즉 jsp로 데이터 전달.
//컨트롤러를 이용해 클래스 생성 
//requestmapping를 이용해 view의 요청 경로를 지정
//요청 처리를 위한 메소드 즉 로직을 구현 
//
//뷰 이름 리턴.
//midel 객체를 파라미터로 받는다.
//
//model.addattribute를 이용하여 넘길 데이터의 이름과 값 넣기.
//그러면 똑똑한 스프링은 그 값을 jsp view쪽으로 넘겨준다.
//
//jsp에선 ${}를 이용해서 값을 가져온다.
//
//modelandview 사용 시
//
//modelandview 객체를 선언 및 생성.
//view 이름은 setViewName 라는 메소드 친구를 이용한다.
//addObject 메소드 친구를 이용하여 데이터를 보낸다.
//return을 통해서 mav 객체를 반환한다.
//jsp도 $ 즉 모델과 같이 이용하여 값을 가져온다.
//https://hongku.tistory.com/116 (글 개 좋다. 기본중의 기본.)11-26
// 모델과 모델뷰에 관한 글이니 1일 1독하며 반복



@Controller // 컨트롤러라는 걸 알려주는 어노테이션 애가 컨트롤러야 ㅇㅇ 11.12
@RequestMapping(value = "/nboard")
public class NBoardController {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(NBoardController.class);

	@Autowired // 공지사항게시판 서비스 호출하기
	private NBoardService nboardService;

	@GetMapping("/nlist") // 공지사항 리스트 화면을 가기 위한 주소
	public void nlist(Model model, Integer page, Integer numsPerPage) {
		LOGGER.info("nlist() 호출");

		LOGGER.info("page =" + page + ", numsPerPage=" + numsPerPage);

		// Paging 처리
		PageCriteria criteria = new PageCriteria();

		if (page != null) {
			criteria.setPage(page);
		}

		if (numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}

		// 리턴 타입이 string가 아닌 void면 jsp를 스프링이 자동으로 경로 찾아서 화면 리턴
		// string로 하면 nlist라고 리턴하면 /nboard/nlist라는 jsp 리턴한다는 의미. 11.12

		List<NBoardVO> list = nboardService.read(criteria);
		// 리스트 만들었으니 보내야한다.

		LOGGER.info("리스트 뜨는지 확인 --------------" + list.toString());

		model.addAttribute("nlist", list);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(nboardService.getTotalNumsOfRecords());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
		// 알트 쉬프트 알 전체 바꾸기

	} // end list

	@GetMapping("/nregister")
	public void nregisterGET() {
		// 글 등록하기 위해 화면으로 가는 url
		LOGGER.info("nregisterGET() 호출");

		// public string nregisterGET() {
		// return "nboard/nregister"; 호출경로. 11.12
		// 호출하는 url과 jsp 이름이 다른 경우에 void 쓰면 안댐 스프링이 못 찾음 11.12

	}// end nregister()

	@PostMapping("/nregister")
	public String nregisterPOST(NBoardVO vo, RedirectAttributes reAttr) {
		// 11.12 RedirectAttributes
		// 재경로 위치에 속성값(Attributes) 전송하는 객체
		// sendredirect get 방식
		LOGGER.info("nregisterPOST() 호출");
		LOGGER.info(vo.toString());
		int result = nboardService.create(vo);
		LOGGER.info(result + "행 삽입");
		// 실제 글을 등록해주는 url

		// 등록 성공.
		if (result == 1) {
			// "insert_result", 의 키이름 가진 데이터 전송
			// 리다이렉트(redirect)는
			// 사용자가 어떤 URL로 웹 서버를 요청했을때 다른 URL로 넘겨주는 것을 말합니다.
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/nboard/nlist"; // url 성공시 nboard/nlist로 이동.
		} else {
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/nboard/nregister"; // 실패시 nboard/nregister로 이동.

		}

	}// end nregister 11.12

	@GetMapping("/ndetail")
	public void detail(Model model, Integer bno, Integer page) {
		LOGGER.info("ndetail() 호출 : bno = " + bno);
		// jsp를 불러오고 그 게시물의 정보를 불러옴 11.12

		NBoardVO vo = nboardService.read(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);

	}// 11.12

	@GetMapping("/nupdate")
	public void updateGET(Model model, Integer bno, Integer page) {
		LOGGER.info("nupdateGET() 호출 : bno = " + bno);
		NBoardVO vo = nboardService.read(bno);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	}

	@PostMapping("/nupdate")
	public String updatePUT(NBoardVO vo, Integer page) {
		LOGGER.info("updatePUT() 호출 : bno =" + vo.getBno());
		int result = nboardService.update(vo);
		if (result == 1) {
			return "redirect:/nboard/nlist?page=" + page; // 경로 11.12
		} else {
			return "redirect:/nboard/nupdate?bno=" + vo.getBno();
			// 업데이트는 기존에 원래 있는 것을 계속 바꿔야 하기에.
		}
	}

	@GetMapping("/ndelete")
	public String delete(Integer bno) {
		LOGGER.info("ndelete() 호출 : bno = " + bno);
		int result = nboardService.delete(bno);
		if (result == 1) {
			return "redirect:/nboard/nlist";
		} else {
			return "redirect:/nboard/nlist";

		}
	}

	@GetMapping("/searchNList") // 11-27 기존 nlist로 위에 목록 불러오는 nlust와 중복. 그래서 searchNList로 변경.
	@ResponseBody // @ResponseBody 가 붙은 파라미터에는 HTTP 요청의 분문 body 부분이 그대로 전달된다
	// 출처: https://cheershennah.tistory.com/179 [Today I Learned. @cheers_hena
	// 치얼스헤나]

	public ModelAndView nslist(@RequestParam(defaultValue = "ntitle") String searchOption,
			@RequestParam(defaultValue = "") String keyword) throws Exception {
		// @RequestParam(가져올 테이터의 이름) [데이터 타입] [가져온 데이터를 담을 변수]
		// https://hongku.tistory.com/119
		/*
		 * int page, Integer numsPerPage
		 */
		// 레코드의 갯수 11-26 @RequestPara(defaultValue="") Object count 지움

		// 게시판 게시된 총 글 조회 (count)
		int count = nboardService.getTotalNumsOfRecords();
		List<NBoardVO> list = nboardService.listAll(searchOption, keyword);
		

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

		mav.addObject("nlist", list); // 데이터를 보낼때는 addObject 메소드를 활용하기에.
		// 왜? 안됬냐면 여기 부분에 데이터를 보내주는데에 map을 보낸다고 입력했기에 jsp에는 nlist를 받아야하는데 map을 보낸다고 했으니 안됨
		// addObject의 의미를 몰라서 문제가 생겼다.
		//11-26
		
		mav.setViewName("nboard/nlist");// view의 경로. 
		
		return mav; // mav modelandview 반환 
	}// end

	// get 방식인데 post 방식으로 보낸다.

	/*
	 * https://angelplayer.tistory.com/182 전송 방식은 GET, POST 등이 있으며 이때 게시판 검색, 정렬 기능은
	 * GET을 사용한다.
	 * 
	 * POST 방식은 동일한 POST 요청이 들어오면 중복을 방지하기 위해서 오류를 발생시키는데, 웹 페이지는 새로고침이나 뒤로가기 등을 하기
	 * 때문에 해당 오류가 발생할 수 있다.
	 * 
	 * (종종 페이지들이 새로고침 또는 뒤로가기 했을 때 만료된 페이지가 뜨는 이유)
	 * 
	 * 따라서 게시판을 조회하는 기능은 GET 방식을 이용하는 것을 권장한다.
	 */

	// @RequestParam은 HTTP 요청 파라미터를 컨트롤러 메소드의 파라미터로 전달받을 때 사용.
	// JSP에서 request.getParameter();와 유사한 형태.

	// @RequestBody은 vo객체를 JSON으로 바꾼 후 HTTP body에 담는 역할.

	// @RequestBody NBoardVO vo
	
	
	
	
	
	
	
	

}// end
