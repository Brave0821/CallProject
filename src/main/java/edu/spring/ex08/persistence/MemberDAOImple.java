package edu.spring.ex08.persistence;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex08.domain.MemberVO;

@Repository  // : 저장소이며 데이터 저장 계층에서 dao라는 것을 알리기 위해  
public class MemberDAOImple implements MemberDAO{

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(MemberDAOImple.class);
	
	private static final String NAMESPACE =
			"edu.spring.ex08.BoardMapper"; // Mapper의 namespace 부분.
	
	@Autowired // 이 어노테이션은 상황의 타입에 맞게 ioc 컨테이너(객체의 생성 책임 의존성 관리) 안에 bean을 자동으로 주입
	private SqlSession sqlSession;
	// mybaties를 이용 dao 구현에 SqlSession 객체가 필요하다.

	
	
	@Override
	public int insert(MemberVO vo) {
		LOGGER.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insertMember", vo);
	}



	@Override
	public String login(MemberVO vo) {
		return sqlSession.selectOne(NAMESPACE + ".loginMember", vo);
	}

	
//	@Override
//	public List<MemberVO> select(String userid) {
//		LOGGER.info("select()호출 + userid =" + userid);
//		userid = "%" + userid + "%";
//		return sqlSession.selectList(NAMESPACE + ".select_by_userid", userid);
//	}
//	
//
//	@Override
//	public int update(String index, MemberVO vo) {
//		LOGGER.info("update() 호출 + vo =" + vo.toString());
//		return sqlSession.update(NAMESPACE + ".update", vo);
//	}
//
//	@Override
//	public int delete(String userid) {
//		LOGGER.info("delete() 호출");
//		return sqlSession.delete(NAMESPACE + ".delete", userid);
//	}


//	@Override
//	public boolean checkPw(String userid, String password) {
//		boolean result = false;
//		Map<String, String> map = new HashMap<String, String>();
//		map.put(userid, userid);
//		map.put(password, password);
//		int count = SqlSession.selectOne(NAMESPACE + ".checkPw", map);
//	}
//		
//		
//		
//		
//		return false;
//	}

	/*
	 * @Override public String login(String userid, String password) {
	 * LOGGER.info("login() 호출"); return sqlSession.; }
	 */



}// end
