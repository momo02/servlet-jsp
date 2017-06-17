package life.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LifeCycleServlet1 extends HttpServlet{
	
	//1. 클래스의 생성자 호출
	public LifeCycleServlet1() {
		System.out.println("1. 생성자 호출");
	}
	
	
	
	//2. init메서드 호출 (GenericServlet) 
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("2. init() 호출");
	}
	
	//3. get 요청이 오면 실행된다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		System.out.println("3. doGet() 호출");
	}
	
	//3. post 요청이 오면 실행된다.
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		System.out.println("3. doPost() 호출");
	}
	
	//4. 톰캣(컨테이너)이 내려갈때.
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("4. destroy() 호출");
	}
}
