package edu.spring.ex08.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex08.domain.FReplyVO;


@Repository
public class FReplyDAOImple implements FReplyDAO {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(FReplyDAOImple.class);
	
	private static final String NAMESPACE = 
			"edu.spring.ex08.ReplyMapper";  // reply-mapper의 namespace 부분 :D
	
	// 11-16 연결성 반복 타이핑 
	// . 부분  mapper의 id와 맞춰야한다. 인식 못 함. :D
	// 초기설정 vo mybatis나 mapper dao와 daoimle 연결성 
	// - > service serviceimple 연결성 -> controller - > jsp 연결성 흐름대로 잘 파악하기. 
	// jsp - > controller - > service -> vo dao -> DB 등등  
	
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// . 값은 맵퍼에 id 부분 
	
	@Override
	public int insert(FReplyVO vo) {
		LOGGER.info("frinsert() 호출");
		return sqlSession.insert(NAMESPACE + ".frinsert", vo);
	}

	@Override
	public List<FReplyVO> select(int freplybno) {
		LOGGER.info("fselect() 호출 : freplybno = " + freplybno);
		return sqlSession.selectList(NAMESPACE + ".fselect_all_by_reply_bno", freplybno);
	}
	// 여기까진 로그 찍힌다. 윗 select 부분.
	
	
	
	
	@Override
	public int update(FReplyVO vo) {
		LOGGER.info("frupdate() 호출");
		return sqlSession.update(NAMESPACE + ".frupdate", vo);
	}
	

	@Override
	public int delete(int freplyno) {
		LOGGER.info("frdelete() 호출 : freplyno = " + freplyno);
		return sqlSession.delete(NAMESPACE + ".frdelete", freplyno);
	}

	
	
}// end freply
