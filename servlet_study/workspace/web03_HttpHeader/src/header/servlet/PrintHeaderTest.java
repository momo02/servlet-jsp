package header.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrintHeaderTest extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println(":::::::::::::::doGet");
		// TODO Auto-generated method stub
		//한글 처리
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		//화면 출력 
		PrintWriter out = resp.getWriter();
		
		//전송할때 개발자도구(F12) network > Request Header 정보에 있는 데이터가 뿌려진다
		Enumeration<String> en = req.getHeaderNames();
		
		while(en.hasMoreElements()){ //다음 값이 있는지 (true,false) 
			String key = en.nextElement(); //다음 값의 키를 가져온다.
			String value = req.getHeader(key);
			out.println("key : "+ key + "<br/> value : " + value + "<br/><br/>");
			
		}
	
		
		
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		System.out.println(":::::::::::::::doPost");
		//한글 처리
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		
		//화면 출력 
		PrintWriter out = resp.getWriter();
		
		//전송할때 개발자도구(F12) network > Request Header 정보에 있는 데이터가 뿌려진다
		Enumeration<String> en = req.getHeaderNames();
		
		while(en.hasMoreElements()){ //다음 값이 있는지 (true,false) 
			String key = en.nextElement(); //다음 값의 키를 가져온다.
			String value = req.getHeader(key);
			out.println("key : "+ key + "<br/> value : " + value + "<br/><br/>");
			
		}
	
		
		
		out.flush();
		out.close();
	}
}
