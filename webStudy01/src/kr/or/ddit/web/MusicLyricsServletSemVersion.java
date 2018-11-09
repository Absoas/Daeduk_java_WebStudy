package kr.or.ddit.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/song")
public class MusicLyricsServletSemVersion extends HttpServlet{
      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String song = req.getParameter("song");
         int status = 0;
         String message = null;
         if(song == null || song.trim().length() ==0) {
            status = HttpServletResponse.SC_BAD_REQUEST; //400
            message = "가사 파일을 선택해주세요.";
         }
         File folder = new File("d:/contents");
         File songFile = new File(folder, song);
         if(!songFile.exists()) {
            status = HttpServletResponse.SC_NOT_FOUND; //404
            message = "해당 곡은 가사가 없습니다.";
         }
         if(status != 0) {
            resp.sendError(status, message);
            return;
         }
         
         resp.setContentType("text/html;charset = UTF-8");

        // java 1.7 : try with resource 구문
         
      try (
//          Closable 객체를 할당
            FileInputStream fis = new FileInputStream(songFile);
            InputStreamReader isr = new InputStreamReader(fis, "MS949"); // byte형태로 변경해주는 stream
            BufferedReader reader = new BufferedReader(isr); // 한 줄씩 읽기 위한 buffer, 안해주면 한 글자씩 읽음(느림)
            PrintWriter out = resp.getWriter();) {

         String temp = null; // 임시변수(누적 위함)
         StringBuffer html = new StringBuffer();
         while ((temp = reader.readLine()) != null) {
            html.append("<p>" + temp + "</p>");
            System.out.println(temp);
         }

         out.println(html);
      }
   }
}