package form.step01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기다..
		
		// 1. 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 2. PrintWriter 객체 리턴받고.
		PrintWriter out = response.getWriter();
			
		// 3. html 폼에 입력된 값을 받아온다. getParameterNames()를 사용해서
		// 폼에 입력된 값 받아서 웹으로 다시 출력
		Enumeration<String> en = request.getParameterNames();
		while(en.hasMoreElements()){
			String key = en.nextElement();
			
			
			if(key.equals("hobby")){ //select박스에서 선택한 value값이 여러개일 때 
				
				String[] value = request.getParameterValues(key);
				
				out.println(key + " : <br/>");
				
				for(String i : value){ //자바의 향상된 for문
				
					out.println(i + "<br/>");
					//key는 jsp페이지에서 넘겨진 input의 name속성과 같다.
				}
				
			
			}else{
				
				String value = request.getParameter(key);
				out.println(key + " : " + value + "<br>"); 
				
			}
			
		}
		out.close();
	}

	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}*/
}
