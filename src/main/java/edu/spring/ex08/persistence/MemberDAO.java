package edu.spring.ex08.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import edu.spring.ex08.domain.MemberVO;

public interface MemberDAO {
	
	// 회원가입.
	public abstract int insert(MemberVO vo);
	// dao 하나 당 쿼리 하나.

	public abstract String login(MemberVO vo);
	
	// 회원 한명 정보 보기.
//	public abstract List<MemberVO> select(String userid);
//	
//	// 회원 정보 수정 
//	public abstract int update (String index, MemberVO vo);
//	
//	// 회원 탈퇴 
//	public abstract int delete(String userid);
	
	/*
	 * // 중복확인인가? public abstract String login(String userid, String password);
	 */
	// hashmap
	// 
//	ex)HashMap 예시 
//	Map<String,Integer> map=new HashMap(); 
//
//	map.put("A", 100);
//
//	System.out.println(map);
//			System.out.println(map.get("A"));
//
//	{A=100,}
//	100

	// 핵심 수정 및 삭제를 위한 비밀번호 체크. 원래 boolean을 통해서 
	
	
//	// 추가 회원 정보 수정 및 삭제를 위한 pw 체크 
//	public boolean checkPw(String userid, String password); 
//	
	
}// end 
