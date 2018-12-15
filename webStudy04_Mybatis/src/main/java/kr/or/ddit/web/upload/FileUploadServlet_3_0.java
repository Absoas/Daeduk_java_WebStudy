package kr.or.ddit.web.upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.vo.FileVO;

//@WebServlet("/upload")
//@MultipartConfig
public class FileUploadServlet_3_0 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
//		File saveFolder = new File("D:\\saveFiles");
//		/saveFiles 에 저장
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
			resp.sendError(400);
			return;
		}		
		
//		Content-Disposition: form-data; name="uploadFile"; filename="Chrysanthemum.jpg"
		String header = uploadFile.getHeader("Content-Disposition");
		int idx = header.lastIndexOf("filename=")+"filename=".length();
		
		String originalFilename = header.substring(idx).replace("\"", "");
		System.out.println(originalFilename);
 		String savename = UUID.randomUUID().toString();
		
		
 		// Middle tier 에 파일의 body 를 저장.
		File saveFile = new File(saveFolder, savename);
		byte[] buffer = new byte[1024];
		int pointer = -1;
		try(
			InputStream in = uploadFile.getInputStream();
			FileOutputStream fos = new FileOutputStream(saveFile);
		){		
			while((pointer = in.read(buffer))!=-1) {
				fos.write(buffer, 0, pointer);
			}
		}
		Collection<Part> parts = req.getParts();
		System.out.println(parts.size());
		
		// Database  에 파일의 메타데이터를 저장.
		
		long filesize = uploadFile.getSize();

		System.out.printf("데이터베이스에 저장할 메타데이터 : 업로더(%s), 원본명(%s), \n"+
						  " 파일크기(%d), 파일종류(%s), 저장위치(%s), \n 저장URL(%s)", 
				uploader, originalFilename, filesize, filemime, 
				saveFile.getAbsolutePath(), saveUrl+"/"+savename);
		FileVO fileVO = new FileVO();
		fileVO.setUploader(uploader);
		fileVO.setOriginalFilename(originalFilename);
		fileVO.setSaveFilename(savename);
		// 웹리소스로 저장하는 경우에만 생성되는 메타데이터.
		fileVO.setSaveFileUrl(saveUrl+"/"+savename);
		fileVO.setSaveFilePath(saveFile.getAbsolutePath());
		fileVO.setFilesize(filesize);
		fileVO.setFilemime(filemime);
		
		req.getSession().setAttribute("fileVO", fileVO);
		
		resp.sendRedirect(req.getContextPath() + "/13/fileForm.jsp");
	}
}


















