package kr.or.ddit.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
@WebServlet(value="/imageService")
public class ImageServiceServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청 파라미터 확보 : 파라미터명(image)
		// 이미지 스트리밍...
		resp.setContentType("image/jpeg");
		String image = req.getParameter("image");
		
		//화이트스페이스일수도 있뜸
		if(image==null || image.trim().length()==0) {
			resp.sendError(400);
			return;
		}
		File folder = new File("d:/contents");
		File imgFile = new File(folder,image);
		
		//이파일이 실제로 존재하는지에 대해서 파악해봐야한다.
		if(!imgFile.exists()) {
			resp.sendError(404);
			return;
		}
		FileInputStream fis = new FileInputStream(imgFile);
		OutputStream out = resp.getOutputStream();
		byte[] buffer = new byte[1024];
		int pointer = -1;
		while((pointer = fis.read(buffer)) != -1){ // -1 : EOF 문자
			out.write(buffer,0,pointer); //읽어들일 만큼만! 
		}
		fis.close();
		out.close();
	
	}
}
