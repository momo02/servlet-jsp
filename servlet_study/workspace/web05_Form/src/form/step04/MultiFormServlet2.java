package form.step04;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MultiFormServlet2 extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		
		//1.getParameter 사용
		//step01(req,resp);
		
		//2.getParameterMap 사용
		step02(req,resp);
	}
	
	
	public void step01(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("id");
		String[] hobbyArr = req.getParameterValues("hobby");
		String gender = req.getParameter("gender");
		String command = req.getParameter("command");
		String[] telArr = req.getParameterValues("tel");
		String intro = req.getParameter("intro");
		
		out.println("<html><body>");
		out.println("아이디 : " + id + "<br/>");
		
		out.println("취미--------------- <br/>");
		for(String hobby : hobbyArr){
			 out.println( hobby + "<br/>");
		}
		out.println("성별 : " + gender +"<br/>");
		out.println("히든값 : " + command +"<br/>");
		out.println("전화번호--------------- <br/>");
		for(String tel : telArr){
			 out.println( tel + "<br/>");
		}
		out.println("소개 : " + intro +"<br/>");
		out.println("</body></html>");
		
	}
	
	public void step02(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		
		
		PrintWriter out = resp.getWriter();
		
		
		Map<String,String[]> map = req.getParameterMap();
		Set<String> set = map.keySet();
		
		Iterator<String> it = set.iterator();
		
		out.println("<html><body>");
		
		while(it.hasNext()){
			
			String key = it.next();
			
			out.println( "::::::::::" + key + "::::::::::<br/>");
			
			String[] values = map.get(key);
			
			for(String value : values){
				
				out.println(value + "<br/>");
				
			}
			
		}
		
		out.println("</body></html>");
		
	}

}
