package com.hanshin.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/my2")
public class myexample2 extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>get</title></head>");
		out.print("<body>");
		out.print("<h1>GET 방식으로 요청되었습니다</h1>");
		
		//서버의 톰캣 버전(8.0이상)이 utf-8로 url 인코딩이 미리 되어있기 때문에 get방식은 따로 지정해 줄 필요가 없음

		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] depts = req.getParameterValues("dept");
		String gender = req.getParameter("gender");
		String birth = req.getParameter("birth");
		String intro = req.getParameter("introduction");

		out.print("ID : " + id + "<br/>");
		out.print("비밀번호 : " + password + "<br/>");
		out.print("이름 : " + name + "<br/>");
		out.print("학부 : ");
		for (int i = 0; i < depts.length; i++) {
			out.print(depts[i] + " ");
		}
		out.print("<br/>");
		out.print("성별 : " + gender + "<br/>");
		out.print("birth : " + birth + "<br/>");
		out.print("소개 : " + intro + "<br/>");
		out.print("전체 Query 문자열 : " + req.getQueryString());

		out.println("</body></html>");
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8"); //한글처리부분★★★
		req.setCharacterEncoding("utf-8"); //한글처리 부분★★★ <body>의 인코딩을 utf-8로 하는 방법.
		
		
		PrintWriter out = resp.getWriter();
		out.print("<html><head><title>Query 문자열 테스트</title></head>");
		out.print("<body>");
		out.print("<h1>POST 방식으로 요청되었습니다</h1>");
		
		
		String id = req.getParameter("id");
		String password = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] depts = req.getParameterValues("dept");
		String gender = req.getParameter("gender");
		String birth = req.getParameter("birth");
		String intro = req.getParameter("introduction");

		out.print("ID : " + id + "<br/>");
		out.print("비밀번호 : " + password + "<br/>");
		out.print("이름 : " + name + "<br/>");
		out.print("취미 : ");
		for (int i = 0; i < depts.length; i++) {
			out.print(depts[i] + " ");
		}
		out.print("<br/>");
		out.print("성별 : " + gender + "<br/>");
		out.print("생일 : " + birth + "<br/>");
		out.print("소개 : " + intro + "<br/>");
		out.print("전체 Query 문자열 : " + req.getQueryString());
		
		out.println("</body></html>");
		out.close();
	}
}