package kr.or.ddit.board.service;

import static org.junit.Assert.*;import org.apache.taglibs.standard.lang.jstl.EqualityOperator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PagingInfoVO;

public class BoardServiceImplTest {

	PagingInfoVO<BoardVO> pagingVO;
	IBoardService service = new BoardServiceImpl();
	BoardVO board;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
	}

	@Before
	public void setUp() throws Exception {
		pagingVO = new PagingInfoVO<>();
		board = new BoardVO();
	}

	@After
	public void tearDown() throws Exception {
	
	}

	@Test
	public void testCreateBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetriveBoardCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetriveBoardList() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetriveBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyBoard() {
		ServiceResult result = service.modifyBoard(board);
	}

	@Test
	public void testRemoveBoard() {
		board.setBo_no((long)125);
		ServiceResult result = service.removeBoard(board);
		assertEquals(result, ServiceResult.INVALIDPASSWORD);
		board.setBo_pass("asdd");
		result = service.removeBoard(board);
		assertEquals(result , ServiceResult.OK);
	}

	@Test
	public void testDownloadPds() {
		fail("Not yet implemented");
	}

}
