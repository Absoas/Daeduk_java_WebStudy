package kr.or.ddit.board.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;

import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilterWrapper;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.filter.wrapper.FileUploadRequestWrapper;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.URIMapping.HttpMethod;
import kr.or.ddit.validator.GeneralValidator;
import kr.or.ddit.validator.InsertGroup;
import kr.or.ddit.vo.BoardVO;

@CommandHandler
public class BoardInsertController{
	IBoardService service = new BoardServiceImpl();

	@URIMapping(value="/board/boardInsert.do", method=HttpMethod.GET)
	public String getProcess(HttpServletRequest req, HttpServletResponse resp) {
		return "board/boardForm";
	}
	
	@URIMapping(value="/board/boardInsert.do", method=HttpMethod.POST)
	public String postProcess(HttpServletRequest req, HttpServletResponse resp) {
		BoardVO board = new BoardVO();
		req.setAttribute("board", board);
		
		try {
			BeanUtils.populate(board, req.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
		
		GeneralValidator validator = new GeneralValidator();
		Map<String, List<CharSequence>> errors = new LinkedHashMap<>();
		req.setAttribute("errors", errors);
		boolean valid = validator.validate(board, errors, InsertGroup.class);
		String view = null;
		if(valid) {
			
			HttpServletRequest request = req;
			if(req instanceof XssEscapeServletFilterWrapper) {
				request = (HttpServletRequest) ((XssEscapeServletFilterWrapper) request).getRequest();
			}
			
			if(request instanceof FileUploadRequestWrapper) {
				List<FileItem> fileItems = ((FileUploadRequestWrapper) request).getFileItems("bo_file");
				board.setItemList(fileItems);
			}
			
			ServiceResult result = service.createBoard(board);
			if(ServiceResult.OK.equals(result)) {
				view = "redirect:/board/boardList.do";
			}else {
				req.setAttribute("message", "서버 오류");
				view = "board/boardForm";
			}
		}else {
			view = "board/boardForm";
		}
		return view;
	}

}


















