package com.hanshin.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class myexample extends HttpServlet { //base라는 이름의 서블릿
		
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		System.out.println("service called");
		PrintWriter out = resp.getWriter();	//getWriter는 out 객체에 프린트 메소드를 이용해서 전송
		resp.setContentType("text/html; charset=UTF-8"); //한글이 깨지지 않게 인코딩★★★★
		out.print("<h1>service 안녕하세요!</h1><br/>");

		super.service(req, resp); //중요!! 상위 클래스에서 오버라이드. doGet인지 doPost인지 구분 후 해당 메소드 호출
	}
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet called");
		
		resp.setContentType("text/html; charset=UTF-8"); //한글이 깨지지 않게 인코딩★★★★
		
		PrintWriter out = resp.getWriter();	//getWriter는 out 객체에 프린트 메소드를 이용해서 전송
		out.print("<h1>doGet 안녕하세요!</h1>");
		out.close();
		}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost called");
		
		resp.setContentType("text/html; charset=UTF-8"); //한글이 깨지지 않게 인코딩★★★★
		
		PrintWriter out = resp.getWriter();	//getWriter는 out 객체에 프린트 메소드를 이용해서 전송
		out.print("<html><head><title>Test</title></head>");
		out.print("<body><h1>doPost 안녕하세요!</h1></body>");
		out.print("</html>");
		out.close();
		}
		
}
