package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormNameServlet extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, res);
	}
	
	
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		
		
		
	}
	 
	 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		
		System.out.println("여기들어왔닝????");
		
		req.setCharacterEncoding("UTF-8"); //요청 데이터(파라미터)의 인코딩 
		//(req.getParameter로 파라미터를 꺼내오기전에 인코딩 설정을 해줘야 제대로 적용)
		
		String name = req.getParameter("name");
	
		resp.setContentType("text/html"); //응답 데이터의 컨텐츠타입
		resp.setCharacterEncoding("UTF-8"); //응답 데이터의 인코딩
		// (얘도 마찬가지로 resp.getWriter로 데이터를 뽑기 전에 설정해줘야함)
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("전송한 이름은 " +name + "입니다.");
		out.println("</body></html>");
		out.flush();
		out.close();
		
	}
	
}
