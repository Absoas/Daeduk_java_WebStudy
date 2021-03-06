package kr.or.ddit.board.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilterWrapper;

import kr.or.ddit.filter.wrapper.FileUploadRequestWrapper;
import kr.or.ddit.mvc.annotation.CommandHandler;
import kr.or.ddit.mvc.annotation.URIMapping;
import kr.or.ddit.mvc.annotation.URIMapping.HttpMethod;
import kr.or.ddit.vo.UploadImageVO;
import kr.or.ddit.web.calculate.Mime;

@CommandHandler
public class UploadImageController{

	@URIMapping(value="/board/uploadImage.do", method=HttpMethod.POST)
	public String process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String saveFolderUrl = "/boardImages";
		File folder = new File(
				req.getServletContext().getRealPath(saveFolderUrl));
		
		if(!folder.exists()) folder.mkdirs();
		
		HttpServletRequest request = req;
		if(req instanceof XssEscapeServletFilterWrapper) {
			request = (HttpServletRequest) ((XssEscapeServletFilterWrapper) req).getRequest();
		}
		
		if (request instanceof FileUploadRequestWrapper) {
			FileItem fileItem = 
					((FileUploadRequestWrapper) request).getFileItem("upload");
			
			resp.setContentType(Mime.JSON.getContentType());
			UploadImageVO vo = new UploadImageVO();
			if (fileItem != null) {
				String savename = UUID.randomUUID().toString();
				File savefile = new File(folder, savename);
				vo.setFileName(fileItem.getName());
				vo.setUploaded(1);
				vo.setUrl(req.getContextPath() + saveFolderUrl + "/"+savename);
				try (InputStream in = fileItem.getInputStream();) {

					FileUtils.copyInputStreamToFile(in, savefile);
				}

			}else {
				// 이미지 업로드 안된 경우.
				Map<String, Object> error = new HashMap<>();
				error.put("number", 400);
				error.put("message", "업로드된 이미지가 없음.");
				vo.setError(error);
			}
			
			try(
				PrintWriter out = resp.getWriter();	
			){
				ObjectMapper mapper=new ObjectMapper();
				mapper.writeValue(out, vo);				
			}
		}
		return null;
	}

}










