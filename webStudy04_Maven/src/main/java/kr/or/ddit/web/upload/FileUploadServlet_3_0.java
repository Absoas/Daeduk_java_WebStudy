package kr.or.ddit.web.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.jsp.PageContext;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.vo.FileVO;

public class FileUploadServlet_3_0 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		File saveFolder = new File("D:\\saveFiles");
//		/saveFiles에 저장
		String saveUrl = "/saveFiles";
		String savePath = getServletContext().getRealPath(saveUrl);
		File saveFolder = new File(savePath);

		if(!saveFolder.exists()) {
			saveFolder.mkdirs();
		}
		
		String uploader = req.getParameter("uploader");
		Map<String, String[]> parameterMap = req.getParameterMap();
		System.out.println(uploader);
		System.out.println(parameterMap.size());
//		System.out.println(parameterMap.get("uploadFile"));
//		Part uploader = req.getPart("uploader");
		Part uploadFile = req.getPart("uploadFile");
		String filemime = uploadFile.getContentType();
		
		if(!StringUtils.startsWithIgnoreCase(filemime, "image/")) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
//		Content-Disposition: form-data; name="uploadFile"; filename="Chrysanthemum.jpg
		String header = uploadFile.getHeader("Content-Disposition");
		int idx = header.lastIndexOf("filename=")+"filename=".length();
		String originalFilename = header.substring(idx).replace("\"", "");
		String savename = UUID.randomUUID().toString();
		
		// Middle tier 에 파일의 body를 저장
		File saveFile = new File(saveFolder,savename);

		byte[] buffer = new byte[1024];
		int pointer = -1;
		try (
			FileOutputStream fos = new FileOutputStream(saveFile);
			InputStream in =  uploadFile.getInputStream();
		)
		{
			while((pointer = in.read(buffer))!=-1) {
				fos.write(buffer, 0, pointer);
			}
		}
		
		Collection<Part> parts  =  req.getParts();
		System.out.println(parts.size());
		
		// Database 에 파일의 메타데이타를 저장.
		long filesize = uploadFile.getSize();
		
		System.out.printf("데이터베이스에 저장할 메타데이터 : 업로더(%s) , 원본명(%s) , \n 파일 크기(%d) , 파일 종류(%s), 저장위치(%s) , 저장URL(%s)"
				,uploader,originalFilename,filesize,filemime,saveFile.getAbsolutePath() , saveUrl+"/"+savename);
		
		FileVO fileVO = new FileVO();
		fileVO.setFilemime(filemime);
		fileVO.setFilesize(filesize);
		fileVO.setSavefilename(savename);
		// 웹리소스로 저장하는 경우에만 생성되는 메타데이터
		fileVO.setOriginalFilename(originalFilename);
		fileVO.setSaveFilePath(saveFile.getAbsolutePath());
		fileVO.setUploader(uploader);
		fileVO.setSaveFileUrl(saveUrl+"/"+savename);
		
		req.getSession().setAttribute("fileVO", fileVO);
				
		resp.sendRedirect(req.getContextPath()+"/13/fileForm.jsp");
	}
}
