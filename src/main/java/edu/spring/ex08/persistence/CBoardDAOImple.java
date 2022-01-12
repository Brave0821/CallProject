package edu.spring.ex08.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex08.domain.CBoardVO;
import edu.spring.ex08.domain.NBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;

@Repository
public class CBoardDAOImple implements CBoardDAO {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(CBoardDAOImple.class);

	private static final String NAMESPACE = 
			"edu.spring.ex08.BoardMapper";
	// mapper의 namespace 맞춰야한다.
	
	
	@Autowired
	public SqlSession sqlSession;

	// 밑에 부분도 .////// mapper 
	
	
	@Override
	public int insert(CBoardVO vo) {
		LOGGER.info("cinsert() 호출");
		return sqlSession.insert(NAMESPACE + ".cinsert", vo);
	}// cinsert mapper id 확인 

	@Override
	public List<CBoardVO> select() {
		LOGGER.info("cselect() 호출");
		return sqlSession.selectList(NAMESPACE + ".cselect_all");
	}// // cselect_all mapper id 확인 

	@Override
	public CBoardVO select(int bno) {
		LOGGER.info("cselect() 호출 : bno = " + bno);
		return sqlSession.selectOne(NAMESPACE + ".cselect_by_bno", bno);
	} // cselect_by_bno mapper id 확인 

	@Override
	public int update(CBoardVO vo) {
		LOGGER.info("cupdate() 호출 + vo =" + vo.toString());
		return sqlSession.update(NAMESPACE + ".cupdate", vo);
	}// cupdate mapper id 확인

	@Override
	public int delete(int bno) {
		LOGGER.info("cdelete()호출 + bno " + bno);
		return sqlSession.delete(NAMESPACE + ".cdelete", bno);
	}// cdelete mapper id 확인

	@Override
	public List<CBoardVO>select(PageCriteria c) {
		LOGGER.info("cselect()호출 + PageCriteria =" + c);
		return sqlSession.selectList(NAMESPACE + ".cpaging", c);
	} // cpaging mapper id 확인

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("cgetTotalNumsOfRecords()호출");
		return sqlSession.selectOne(NAMESPACE + ".ctotal_count");
	}// ctotal_count mapper id 확인

	@Override
	public List<CBoardVO> select(String userid) {
		LOGGER.info("cselect() 호출 + userid = " + userid);
		userid = "%" + userid + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_cuserid", userid);
	}// select_by_cuserid mapper id 확인.

	@Override
	public List<CBoardVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("call_select()호출 + keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_title_ccontent", keyword);
	}// select_by_title_ccontent mapper id 확인.
	// 11-24 - notice_select에서 call_select로 변경.

	
	
	@Override
	public CBoardVO selectBno(String bno) {
		LOGGER.info("cselect()호출 : bno = " + bno);
		return sqlSession.selectOne(NAMESPACE + ".cselect_by_bno", bno);
	}

	
	@Override
	public List<NBoardVO> listAll(String searchOption, String keyword) throws Exception {
		// 검색옵션, 키워드 맵에 저장 
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);	
		return sqlSession.selectList(NAMESPACE + ".clistAll" , map);
	}
	

}// end
