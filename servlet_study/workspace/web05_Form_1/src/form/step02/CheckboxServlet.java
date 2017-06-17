package form.step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckboxServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		
		ex01(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	public void ex01(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
		
		System.out.println("나이 : " + req.getParameter("age"));
		System.out.println("성별 : " + req.getParameter("gender"));
		System.out.println("메뉴 : " + req.getParameter("menu"));
		
		PrintWriter out =res.getWriter();
		out.println( "<html><body>" );
		out.println( "나이 : " + req.getParameter("age")+ "<br/>" );
		out.println( "성별 : " + req.getParameter("gender")+ "<br/>");
		
		out.print( "메뉴 : " );
		
		String[] menu = req.getParameterValues("menu");
		
		/*for(int i =0; i<menu.length; i++){
			out.print( menu[i]+" " );
		}*/ 
		//향상된 for문 
		for(String s : menu){
			out.print( s +" " );
		}
		
		out.println( "</body></html>" );
		out.close(); 
		
	}   
}
