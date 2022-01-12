package edu.spring.ex08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FReplyController {

	@GetMapping("/fdetail") // freply에서 변경
	public void fdetail() {
		
	}

// 여기는 jsp 부분만 받아오는 곳 
	// 데이터는 rest controller
	
} // end rest 컨트롤러에선 JSP 불러오는건 컨트롤러 안씀


