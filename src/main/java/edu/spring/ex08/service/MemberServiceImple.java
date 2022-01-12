package edu.spring.ex08.service;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.ex08.domain.MemberVO;
import edu.spring.ex08.persistence.MemberDAO;

@Service
public class MemberServiceImple implements MemberService{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(MemberDAO.class);
	
	
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private HttpSession session;
	// |create(insert), read(select) update, delete| 
	
	@Override 
	public int create(MemberVO vo) {
		LOGGER.info("create() 호출 : vo= " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public boolean login(MemberVO vo) {
		String id=dao.login(vo);
		if(id!=null) {
			session.setAttribute("userid", id);
			return true;
		}
		else {
			return false;
		}
	}

//	@Override
//	public List<MemberVO> read(String userid) {
//		LOGGER.info("read() 호출"); 
//		return dao.select(userid);
//	}
//
//	@Override
//	public int update(String index, MemberVO vo) {
//		LOGGER.info("update() 호출 ");
//		return dao.update(index, vo);
//	}
//
//	@Override
//	public int delect(String userid) {
//		LOGGER.info("delete() 호출");
//		return dao.delete(userid);
//	}
	
}// end 
