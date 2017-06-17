package servlet.context.step02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 동적으로 context-param을 설정한다.
 */
public class WritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	
	//1.변수 선언
	ServletContext servletContext;
	HashMap<String, String> userList;
	
	public void init() throws ServletException {
		//2. 초기화
		servletContext = getServletContext();
		
		////
		/*System.out.println(">>>>1" + servletContext.getInitParameter("userName1"));
		System.out.println(">>>>2" + getInitParameter("userName1"));*/
		
		userList = new HashMap<String, String>();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		//html로부터 값 받아오기.
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPass");
		String name = request.getParameter("userName");
		
		//map에 값 담기.
		userList.put("id", id);
		userList.put("pass", pass);
		userList.put("name", name);
		
		
		//담은 리스트를 컨텍스트에 담기.
		servletContext.setAttribute("userList", userList);
		
		//한글설정
		
		response.setContentType("text/html;charset=utf-8");
		
		//문서객체 생성
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor='pink'>");
		out.println("<b>======= The Communication between Servlets=========<br>");
		out.println("사용자의 정보가 ServletContext에 저장되었습니다...</b><br><br>");
		out.println("<a href='RS'>접속자 명단 보기</a></body></html>");
		out.close();

	}
	
	@Override
	public void destroy() {
		
	}
}
