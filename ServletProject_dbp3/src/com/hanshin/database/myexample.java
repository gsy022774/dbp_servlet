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


public class myexample extends HttpServlet { //base��� �̸��� ����
		
	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		
		System.out.println("service called");
		PrintWriter out = resp.getWriter();	//getWriter�� out ��ü�� ����Ʈ �޼ҵ带 �̿��ؼ� ����
		resp.setContentType("text/html; charset=UTF-8"); //�ѱ��� ������ �ʰ� ���ڵ��ڡڡڡ�
		out.print("<h1>service �ȳ��ϼ���!</h1><br/>");

		super.service(req, resp); //�߿�!! ���� Ŭ�������� �������̵�. doGet���� doPost���� ���� �� �ش� �޼ҵ� ȣ��
	}
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet called");
		
		resp.setContentType("text/html; charset=UTF-8"); //�ѱ��� ������ �ʰ� ���ڵ��ڡڡڡ�
		
		PrintWriter out = resp.getWriter();	//getWriter�� out ��ü�� ����Ʈ �޼ҵ带 �̿��ؼ� ����
		out.print("<h1>doGet �ȳ��ϼ���!</h1>");
		out.close();
		}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost called");
		
		resp.setContentType("text/html; charset=UTF-8"); //�ѱ��� ������ �ʰ� ���ڵ��ڡڡڡ�
		
		PrintWriter out = resp.getWriter();	//getWriter�� out ��ü�� ����Ʈ �޼ҵ带 �̿��ؼ� ����
		out.print("<html><head><title>Test</title></head>");
		out.print("<body><h1>doPost �ȳ��ϼ���!</h1></body>");
		out.print("</html>");
		out.close();
		}
		
}
