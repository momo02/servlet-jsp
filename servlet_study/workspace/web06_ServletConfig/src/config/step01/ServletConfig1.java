package config.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletConfig1 extends HttpServlet{

	String name,addr,email; 
	
	public ServletConfig1() {
		System.out.println("call ServletConfig1...");
	}
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("call init...");
		
		//web.xml에 선언해둔 <init-param> 객체들을 가져올수 있다.
		this.name = getInitParameter("name");
		this.addr = getInitParameter("addr");
		this.email = getInitParameter("email");
		
		System.out.println(name +" "+ addr +" "+  email);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out =  resp.getWriter();
		out.println("이름 : " + name + "<br/>");
		out.println("주소 : " + addr + "<br/>");
		out.println("이메일 : " + email + "<br/>");
	}
}
