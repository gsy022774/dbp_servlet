package com.hanshin.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/my3")
public class myexample3 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String v_ = req.getParameter("value");
		int v = Integer.parseInt(v_);
		String op = req.getParameter("operator");	
		
		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();
		
		
		int result = 0;
		if(op.equals("=")) {
			int prev = (int) session.getAttribute("value");
			String prev_op = (String) session.getAttribute("operator");
			
			if(prev_op.equals("+")) {
				result = prev + v;
			} else if(prev_op.equals("-")) {
				result = prev - v;
			}
			
			resp.getWriter().printf("Result is %d\n", result);
			
		} else {
			
			session.setAttribute("value", v);
			session.setAttribute("operator", op);
			
			
			// 값과 연산자를 저장
			application.setAttribute("value", v);
			application.setAttribute("operator", op);
			
			session.setAttribute("value", v);
			session.setAttribute("operator", op);
			
			resp.sendRedirect("Calculator2.html");
			
		}
		
	}	
}