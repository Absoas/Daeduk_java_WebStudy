package kr.or.ddit.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/image.do")
public class ImageServiceServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String imgName = req.getParameter("image");
		if (imgName == null || imgName.trim().length() == 0) {
			resp.sendError(400);
			return;
		}
		File folder = new File("d:/contents");
		File imgFile = new File(folder,imgName);
		if(!imgFile.exists()) {
			resp.sendError(404);
			return;
		}
		
		ServletContext context = req.getServletContext();
		resp.setContentType(context.getMimeType(imgName));
		
		FileInputStream fis = new FileInputStream(imgFile);
		OutputStream out = resp.getOutputStream();
		byte[] buffer = new byte[1024];
		int pointer = -1;
		while ((pointer = fis.read(buffer)) != -1) {
			out.write(buffer,0,pointer);
		}
		fis.close();
		out.close();
	}
}
