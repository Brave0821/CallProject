package edu.spring.ex08.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.ex08.domain.FBoardVO;
import edu.spring.ex08.pageutil.PageCriteria;

@Repository
public class FBoardDAOImple implements FBoardDAO {

	
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(FBoardDAOImple.class);
	
	
	private static final String NAMESPACE = 
			"edu.spring.ex08.BoardMapper"; // MPAPPER의 NAMESPACE 맞춰야한다.
	
	
	@Autowired
	public SqlSession sqlSession;
	
	
	// 그리고 밑에 부분도(NAMESPACE + ".//////" 이 부분도 mapper
	
	
	@Override
	public int insert(FBoardVO vo) {
		LOGGER.info("finsert() 호출");
		return sqlSession.insert(NAMESPACE + ".finsert", vo);
	}

	@Override
	public List<FBoardVO> select() {
		LOGGER.info("fselect() 호출");
		return sqlSession.selectList(NAMESPACE + ".fselect_all");
	}

	@Override
	public FBoardVO selectBno(String bno) {
		LOGGER.info("fselect()호출 : bno = " + bno);
		return sqlSession.selectOne(NAMESPACE + ".fselect_by_bno", bno);
	}
	
	@Override
	public FBoardVO select(int bno) {
		LOGGER.info("fselect()호출 : bno = " + bno);
		return sqlSession.selectOne(NAMESPACE + ".fselect_by_bno", bno);
	}

	@Override
	public int update(FBoardVO vo) {
		LOGGER.info("fupdate()호출 + vo =" + vo.toString());
		return sqlSession.update(NAMESPACE + ".fupdate", vo);
	}

	@Override
	public int delect(int bno) {
		LOGGER.info("fdelete()호출 + bno=" + bno);
		return sqlSession.delete(NAMESPACE + ".fdelete", bno);
	}

	@Override
	public List<FBoardVO> select(PageCriteria c) {
		LOGGER.info("fselect()호출 + PageCriteria = " + c);
		return sqlSession.selectList(NAMESPACE + ".fpaging", c);
	}

	@Override
	public int getTotalNumsOfRecords() {
		LOGGER.info("fgetTotalNumsOfRecords()호출");
		return sqlSession.selectOne(NAMESPACE + ".ftotal_count");
	}

	@Override
	public List<FBoardVO> select(String userid) {
		LOGGER.info("fselect()호출 + userid = " + userid);
		userid = "%" + userid + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_fuserid", userid);
	}

	@Override
	public List<FBoardVO> seleByTitleOrContent(String keyword) {
		LOGGER.info("free_select()호출 + keyword = " + keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_title_fcontent", keyword);
	}
	//11-24 notice_select에서 free로 변경.

	
	// 11.18일 추가. 밑 updateFReplyCount 여기에 추가함과 동시에 DAO와 mapper, mybatis 전부 추가해줌.
	// 추가해줄때 변수명 고려, 자유게시판의 댓글이기에 자유게시판 부분에 추가해줌.
	
	@Override
	public int updateFReplyCount(int amount, int bno) {
	Map<String, Integer> args = new HashMap<String, Integer>();	
		args.put("amount", amount);
		args.put("bno", bno);
		
		// 11.18 .부분 mapper의 id 부분과 맞출 것.
		// mapper id명과 일치하는거 확인 (11.19)
		
		return sqlSession.update(NAMESPACE + ".update_freply_count", args); // 여기 
	}
	
}// end FBoardDAOImple
