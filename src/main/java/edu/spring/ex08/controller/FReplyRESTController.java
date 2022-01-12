package edu.spring.ex08.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.ex08.domain.FReplyVO;
import edu.spring.ex08.service.FReplyService;
//11.17
// rest 컨트롤러에선 JSP 불러오는거 안씀. 데이터만 불러오는 것.
// JSP는 일반 컨트롤러로 불러온다.

///replies (POST) : 댓글 추가 (insert)
@RestController
@RequestMapping(value = "/freplies")
public class FReplyRESTController {
	
	
	public static final Logger LOGGER =
			LoggerFactory.getLogger(FReplyRESTController.class);
	
	@Autowired
	private FReplyService freplyService;
	

	@PostMapping(value ="/freplies")//  post : 댓글 입력 
	public ResponseEntity<Integer> createReply(@RequestBody FReplyVO vo) {
	
	LOGGER.info(vo.toString());
	int result = 0;
	
	try {
		result = freplyService.create(vo); // 잘 수행되면 이거 1 // 여기 
	} catch (Exception e) {
		e.printStackTrace();
	}
	return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/all/{freplybno}") //url 
	public ResponseEntity<List<FReplyVO>> readReplies(
		
		@PathVariable("freplybno") int freplybno) {
		List<FReplyVO> list = freplyService.read(freplybno);
		return new ResponseEntity<List<FReplyVO>>(list, HttpStatus.OK);
		
	}
	

	
	@PutMapping("{freplyno}") // PUT : 댓글 수정 
	public ResponseEntity<String> updateReply(	
			
	@PathVariable("freplyno") int freplyno,
	@RequestBody FReplyVO vo) {
		
	vo.setFreplyno(freplyno);
	int result = freplyService.update(vo);
	if(result == 1) {
		
	return new ResponseEntity<String>("success", HttpStatus.OK);
} else {
	return new ResponseEntity<String>("fail", HttpStatus.OK);
}
}// end 11-18

	

	@DeleteMapping("{freplyno}")
	public ResponseEntity<String> deleteReply(
			
	@PathVariable("freplyno") int freplyno,
	@RequestBody FReplyVO vo) {

		// 11-18 int result 관련 삭제 	
		
	try {
		freplyService.delete(freplyno, vo.getFreplybno());
		return new ResponseEntity<String>("success", HttpStatus.OK);
	} catch (Exception e) {
		return new ResponseEntity<String>("fail", HttpStatus.OK);
	}
	}
	
	// <rest controller> 필기정리 11-17 
	// bno -> get -> rest controller로 
	// url 매칭 ajax 
	
	// /replies (POST) : 댓글 추가 (insert)
	// /replies/all/숫자 (GET) : 해당 글번호 (replyBno)의 모든 댓글 검색(select)
	// /replies/숫자 (PUT) : 해당 댓글 번호(replyNo)의 내용을 수정 (update)
	// /replies/숫자 (DELETE) : 해당 댓글 번호 (replyNo)의 댓글을 삭제(delete)
	
	// ex08) frelies? bno08 rest 방식은 파라미터 이름 자체를 안쓴다.
	
	
}// end 
