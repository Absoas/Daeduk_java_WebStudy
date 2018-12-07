package kr.or.ddit.board.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;

import kr.or.ddit.CommonException;
import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.dao.IPdsDAO;
import kr.or.ddit.board.dao.PdsDAOImpl;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.filter.wrapper.FileUploadRequestWrapper;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ICommandHandler;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.validator.GeneralValidator;
import kr.or.ddit.validator.InsertGroup;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PdsVO;

public class BoardInsertController implements ICommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String method = req.getMethod();
		String view = null;
		if("get".equalsIgnoreCase(method)) {
			view = doGet(req, resp);
		}else if("post".equalsIgnoreCase(method)) {
			view = doPost(req, resp);
		}else {
			resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		}
		return view;
		
		// 1. V.L : board/boardForm
		// 2. 게시글에 첨부파일이 최대 3건 (partname=bo_file)
		// 3. 첨부파일 저장 위치 : d:/boardFiles
		
	}

	private String doPost(HttpServletRequest req, HttpServletResponse resp) throws FileNotFoundException, IOException {
		
		BoardVO board = new BoardVO();
		req.setAttribute("board", board);
		
		
		try {
			BeanUtils.populate(board, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		
		GeneralValidator validator = new GeneralValidator();
		Map<String, List<CharSequence>> errors = new LinkedHashMap<>();
		boolean valid = validator.validate(board, errors, InsertGroup.class);
		
		String view = null;
	
		if(valid) {
			if (req instanceof FileUploadRequestWrapper) {
				List<FileItem> fileItems = ((FileUploadRequestWrapper) req).getFileItems("bo_file");
				board.setItemList(fileItems);
			}
			
			
			IBoardService service = new BoardServiceImpl();
			ServiceResult result = service.createBoard(board);
			switch (result) {
			case OK:
				view = "redirect:/board/boardList.do";
				break;
				
			case FAILED:
				req.setAttribute("message","서버 오류");
				view = "board/boardForm";
				break;
			}
		}else {
			view = "board/boardForm";
		}
		
		return view;
	}

	private String doGet(HttpServletRequest req, HttpServletResponse resp) {
		return "board/boardForm";
	}
}
