package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.context.vo.PersonVO;

public class EnteranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public EnteranceServlet() {
		System.out.println("2. EnteranceServlet 생성자 호출 ");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("3. EnteranceServlet init 호출 ");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("4. EnteranceServlet doPost 호출 ");
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		PersonVO p = new PersonVO(name,age);
		
		request.setAttribute("personInfo", p);
		
		RequestDispatcher rd = request.getRequestDispatcher("ViewServlet"); //ViewServlet으로 요청을 넘긴다 
		                                                       // /ViewServlet이렇게 써도 ok 
		//요청을 넘길때  처음 요청방식이 get이면 get, post면 post로 넘어감. 
		

		rd.forward(request, response);
		
	}
	
	@Override
	public void destroy() {
		System.out.println("5. EnteranceServlet destroy 호출 ");
	}
}
