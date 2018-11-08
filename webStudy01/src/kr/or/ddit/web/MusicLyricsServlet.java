package kr.or.ddit.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/songs")
public class MusicLyricsServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		ServletContext context = req.getServletContext();
		File folder = new File("d:/contents");
		String[] filenames = folder.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				String mime = context.getMimeType(name);
				return mime.startsWith("text/");
			}
		});

		StringBuffer options = new StringBuffer();
		String pattern = "<option>%s</option>\n";
		for (String name : filenames) {
			options.append(String.format(pattern, name));
		}

		InputStream is = this.getClass().getResourceAsStream("music.html");
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader reader = new BufferedReader(isr);
		reader.readLine();
		String temp = null;
		StringBuffer html = new StringBuffer();

		while ((temp = reader.readLine()) != null) {
			html.append(temp + "\n");
		}

		int start = html.indexOf("@songTitle");
		int end = start + "@songTitle".length();
		html.replace(start, end, options.toString());

		PrintWriter out = resp.getWriter();
		out.println(html.toString());
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String musicName = req.getParameter("musicTitle");
		System.out.println(musicName);
		if (musicName == null && musicName.trim().length() == 0) {
			resp.sendError(400);
			return;
		}

		File folder = new File("d:/contents");
		File musicFile = new File(folder, musicName);
		if (!musicFile.exists()) {
			resp.sendError(404);
			return;
		}

		FileInputStream fis = new FileInputStream(musicFile);
		InputStreamReader isr = new InputStreamReader(fis, "EUC-KR");
		BufferedReader br = new BufferedReader(isr);
		String pattern = "%s %s";
		String temp = null;

		StringBuffer html = new StringBuffer();
		html.append("<html>");
		html.append("<body>");
		while ((temp = br.readLine()) != null) {
			html.append(String.format(pattern, temp, "<br>"));
		}
		br.close();
		html.append("</body>");
		html.append("</html>");

		PrintWriter out = resp.getWriter();
		out.println(html.toString());
		out.close();
	}
}
