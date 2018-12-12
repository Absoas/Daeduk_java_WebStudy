package kr.or.ddit.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.vo.PdsVO;

@CommandHandler
public class DownloadController{
	IBoardService service = new BoardServiceImpl();

	@URIMapping("/board/download.do")
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String rep_no = req.getParameter("what");
		
		if(!StringUtils.isNumeric(rep_no)) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		
		
		PdsVO pds = null;
		pds = service.downloadPds(Long.parseLong(rep_no));
		
		String fileName = pds.getPds_filename();
//		fileName = URLEncoder.encode(fileName, "UTF-8"); // IE
		resp.setContentType("application/octet-stream");
		String agent = req.getHeader("User-Agent");
		if(StringUtils.containsIgnoreCase(agent, "msie") || 
				StringUtils.containsIgnoreCase(agent, "trident")) {
			fileName = URLEncoder.encode(fileName, "UTF-8");
		}else {
			fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		
		resp.setHeader("Content-Disposition","attachment;filename=\""+fileName+"\"");
		resp.setHeader("Content-Length", pds.getPds_size()+"");
		File saveFolder = new File("d:/boardFiles");
		File downloadFile = new File(saveFolder, pds.getPds_savename());
		
		try(
			OutputStream out = resp.getOutputStream();
		){
			FileUtils.copyFile(downloadFile, out);
		}
		
		return null;
	}

}










