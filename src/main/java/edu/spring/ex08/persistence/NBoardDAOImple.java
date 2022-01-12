package edu.spring.ex08.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex08.domain.NBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;

@Repository
public class NBoardDAOImple implements NBoardDAO {

	private static final Logger LOGGER = 
			LoggerFactory.getLogger(NBoardDAOImple.class);
	
	private static final String NAMESPACE = 
			"edu.spring.ex08.BoardMapper"; // MAPPER의 namespace :D
	
	
// . 부분  mapper의 id와 맞춰야한다. 인식 못 함. :D
// 초기설정 vo mybatis나 mapper dao와 daoimle 연결성 
// - > service serviceimple 연결성 -> controller - > jsp 연결성 흐름대로 잘 파악하기. 
// jsp - > controller - > service -> vo dao -> DB 등등  

	
	@Autowired
	private SqlSession sqlSession;
	// mybaties를 이용 dao 구현에 sqlsession 객체 필요.


	@Override
	public int insert(NBoardVO vo) {
		LOGGER.info("ninsert() 호출");
		return sqlSession.insert(NAMESPACE + ".ninsert", vo);
	} //. mapper id 확인 1



	@Override
	public List<NBoardVO> select() {
		LOGGER.info("nselect() 호출");
		return sqlSession.selectList(NAMESPACE + ".nselect_all");
	}//. mapper id 확인 2


	
	@Override
	public NBoardVO select(int bno) {
		LOGGER.info("nselect()호출 : bno = " + bno);
		return sqlSession.selectOne(NAMESPACE + ".nselect_by_bno", bno);
	}//. mapper id 확인 ㅇㅇ 3



	@Override
	public int update(NBoardVO vo) {
		LOGGER.info("nupdate()호출 + vo =" + vo.toString());
		return sqlSession.update(NAMESPACE + ".nupdate", vo);
		
	}//. mapper id 확인 4



	@Override
	public int delete(int bno) {
		LOGGER.info("ndelete()호출 + bno=" + bno);
		return sqlSession.delete(NAMESPACE + ".ndelete", bno);
	}//. mapper id 확인 5



	@Override
	public List<NBoardVO>select(PageCriteria c) {
		LOGGER.info("nselect()호출 + PageCriteria = " + c);
		return sqlSession.selectList(NAMESPACE + ".npaging", c);
	}//. mapper id 확인 6



	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("ngetTotalNumsOfRecords()호출");
		return sqlSession.selectOne(NAMESPACE + ".ntotal_count");
	}//. mapper id 확인 7



	@Override
	public List<NBoardVO> select(String userid) {
		LOGGER.info("nselect()호출 + userid = " + userid);
		userid = "%" + userid + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_nuserid", userid);
	}//. mapper id 확인 8

	
	@Override
	public List<NBoardVO> selectByTitleOrContent(String keyword) {
		LOGGER.info("notice_select()호출 + keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_title_ncontent", keyword);
	}//. mapper id 확인 9

//////////////////////////////////////////////////////////////////////////////

	@Override
	public NBoardVO selectBno(String bno) {
		LOGGER.info("nselect()호출 : bno = " + bno);
		return sqlSession.selectOne(NAMESPACE + ".nselect_by_bno", bno);
	}


//11-26일 게시글 전체 목록.
	@Override
	public List<NBoardVO> listAll(String searchOption, String keyword) throws Exception {
	// 검색옵션, 키워드 맵에 저장 
	Map<String, String> map = new HashMap<String, String>();
	map.put("searchOption", searchOption);
	map.put("keyword", keyword);	
	return sqlSession.selectList(NAMESPACE + ".listAll" , map);
}
	
	// 11-25 List selectList(query_id) id에 대한 select 문을 실행한 후 여러 레코드를 List로 반환.
	// List selectList(queey_id, 조건) id에 대한 select문을 실행하면서 사용되는 조건도 전달.
	
	

// ("nboard.listAll" , map)

//// 게시판 검색기능 추가 11-25	
//	@Override
//	public List<NBoardVO> getSearchList(NBoardVO vo) {
//		LOGGER.info("getSearchList() 호출");
//		return sqlSession.selectList(NAMESPACE + ".selectSearchList", vo);
//	}											
//	
} // end NBoardDAOImple 
