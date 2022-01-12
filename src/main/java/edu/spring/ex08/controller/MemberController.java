package edu.spring.ex08.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.ex08.domain.MemberVO;
import edu.spring.ex08.service.MemberService;

@Controller // 애는 컨트롤러이다.
@RequestMapping(value = "/member") // view의 요청경로를 지정.
public class MemberController {

// 컨트롤러 진입 후 view로 jsp 전달.	
// RequestMapping를 통해서 view 요청 경로 지정.	

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

	@Autowired // 서비스 호출
	private MemberService memberService;
	
	@Autowired
	private HttpSession session;

//	@RequestMapping(value="/insert", method = RequestMethod.GET)
//	// insert 주소로 get, post 방식 입력 과 출력 둘 다 처리 가능. 11-30
//	// ex08/member/insert

//	public String insertGET() throws Exception{
//		LOGGER.info("회원가입 입력페이지 GET");
//		// 등록페이지로 이동하기.
//		return "/member/register"; 
//	}

	@GetMapping("/register") // jsp 등록화면으로 가는 url
	public void registerGET() {
		// void를 쓸 경우 url과 jsp 이름이 같아야한다.
		LOGGER.info("registerGET() 호출");

	}// end register
	

	@PostMapping("/register")
	public String registerPOST(MemberVO vo, RedirectAttributes reAttr) {
		 // public void registerPOST(MemberVO vo) {

		LOGGER.info("registerPOST() 호출");
		LOGGER.info(vo.toString());
		// int result = memberService.create(vo);
		int result = memberService.create(vo);
		LOGGER.info(result + "행 삽입");
		
		// 등록 성공!
		if (result == 1) {
		reAttr.addFlashAttribute("insert_result", "성공");
			return "redirect:/"; // url 성공 시 회원가입 member 페이지에서 login 로그인 페이지로 이동.
		} else {
			reAttr.addFlashAttribute("insert_result", "실패");
			return "redirect:/member";
		}
	
	
	}	
	

	@ResponseBody
	@PostMapping("/login")
		 public String login(@ModelAttribute MemberVO vo) {
		boolean result=memberService.login(vo);
		if(result) {
			LOGGER.info("로그인 성공");
			return "1";
		}
		else {
			LOGGER.info("로그인 실패");
			return "0";
		}
	}
		@GetMapping("/logout")
		public String logout() {
			LOGGER.info("로그아웃");
			session.invalidate();
			return "redirect:/";
		}
}
