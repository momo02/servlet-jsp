package config.step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InternationalGreetServlet2 extends HttpServlet{
	
	String greeting;
	
	public InternationalGreetServlet2(){
		//System.out.println( ">>>>>" + getInitParameter("greeting"));
		//서블릿 객체가 되기 전이기때문에  NullPointerException 에러가 남 
		System.out.println("InternationalGreetServlet2 call...");
	}
	
	@Override
	public void init() throws ServletException { //init이 호출된 시점부터 서블릿 객체가 된다.
		this.greeting = getInitParameter("greeting");
		System.out.println(greeting);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out =resp.getWriter();
		out.println("<html><body>");
		out.println(req.getParameter("name"));
		out.println(getInitParameter("greeting")); //getInitParameter 메소드는 이 클래스 내 어디서든 사용가능함.
		out.println(greeting);
		
		out.println("</body></html>");
		out.close();
		
	}
}
