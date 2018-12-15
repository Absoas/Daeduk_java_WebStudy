package kr.or.ddit.board.dao;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PagingInfoVO;

public class BoardDAOImplTest {

	static Logger logger = LoggerFactory.getLogger(BoardDAOImpl.class);
	PagingInfoVO<BoardVO> pagingVO;
	BoardVO board;
	SqlSession session;
	
	IBoardDAO boardDAO = new BoardDAOImpl(); 
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
//		logger.debug("{} 테스트 클래스 로딩" , BoardDAOImplTest.class.getSimpleName());
		System.out.printf("%s 테스트 클래스 로딩 \n" , BoardDAOImplTest.class.getSimpleName());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
//		logger.debug("{} 테스트 클래스 unloading" , BoardDAOImplTest.class.getSimpleName());
		System.out.printf("%s 테스트 클래스 unloading \n" , BoardDAOImplTest.class.getSimpleName());
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("단위 테스트 모듈 수행 전!!");
		pagingVO = new PagingInfoVO<>();
		pagingVO.setSearchType("content");
		pagingVO.setSearchWord("은대");
	
		board = new BoardVO();
		board.setBo_no(new Long(125));
		board.setBo_title("수정 제목");
		board.setBo_content("수정 내용");
		session = CustomSqlSessionFactoryBuilder.getSqlSessionFactory().openSession(false);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("단위 테스트 모듈 수행 후!!");
		session.close();
	}

	@Test
	public void testInsertBoard() {
		BoardVO insertBoard = new BoardVO();
//		
		fail("Not yet implemented");
	}

	@Test
	public void testSelectTotalRecord() {
		long totalRecord = boardDAO.selectTotalRecord(pagingVO);
		assertNotSame(0, totalRecord);
	}

	@Test
	public void testSelectBoardList() {
		pagingVO.setCurrentPage(1);
		List<BoardVO> boardList = boardDAO.selectBoardList(pagingVO);
		assertNotNull(boardList);
		assertNotSame(0, boardList.size());
		assertThat(boardList.size() , greaterThan(0));
		BoardVO test = new BoardVO();
		test.setBo_no((long)125);
		test.setBo_writer("ads");
		assertThat(boardList, hasItem(test));
	}

	@Test
	public void testSelectBoard() {
		BoardVO board = boardDAO.selectBoard(125);
		assertNotNull(board);
//		assertNull("조회된 글은 null 이 아닌것 같음", board);
		assertThat(board, instanceOf(BoardVO.class));
	}

//	@Test(timeout=1000 , expected=SQLException.class)
	@Test(timeout=1000)
	public void testIncrementHit() {
		boardDAO.incrementHit(125);
	}

	@Test
	public void testUpdateBoard() {
		int rowCnt = boardDAO.updateBoard(board, session);
		assertEquals(1, rowCnt);
	}

	@Test
	public void testDeleteBoard() {
		int rowCnt = boardDAO.deleteBoard(125, session);
		assertEquals(1, rowCnt);
	}

}
