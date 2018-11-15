package kr.or.ddit.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet("/fileBrowser.do")
public class ServerFileBrowser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		File webContent = new File(getServletContext().getRealPath(""));

		for (final File fileEntry : webContent.listFiles()) {
			if (!fileEntry.isDirectory()) {
				
			} 
		}
		
//		String view = "/WEB-INF/views/fileBrowser.jsp";
//		RequestDispatcher rd  = req.getRequestDispatcher(view);
//		rd.forward(req, resp);
	}
}
