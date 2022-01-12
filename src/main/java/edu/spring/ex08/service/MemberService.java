package edu.spring.ex08.service;

import edu.spring.ex08.domain.MemberVO;

public interface MemberService {

	// 등록.
	public abstract int create (MemberVO vo);

	public abstract boolean login(MemberVO vo);
	
//	// 회원 부분 검색
//	public abstract List<MemberVO>read(String userid);
//	
//	// 회원 정보 수정 
//	public abstract int update(String index,MemberVO vo);
//	
//	// 회원 정보 삭제 
//	public abstract int delect(String userid);
	
}// end 
