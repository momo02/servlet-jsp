package basic.step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * 서블릿을 만드려면 servlet 클래스 상속을 받아야한다.
 * javax.servlet.GenericServlet은 추상 클래스로 
 * service()메서드를 반드시 구현해야한다.
 * 
 * 
 * 1. 요청이 was(Web application Server, servlet container)로 오게되면
 *  HttpRequest를 Container에게 보낸다.
 * 2. Servlet Container는 HttpServletRequest, HttpServletResponse 두 객체를 생성한다.
 * 3. 요청한 URL을 분석하여 web.xml (DD파일, 배포서술자, Deployment Descriptor)를 
 * 참조해서 서블릿을 찾는다. 
 * 4. Service() 메서드를 호출한다. (생성한 req,res를 참조)
 * 5. doGet() 또는 doPost()메서드를 호출. (생성한 req,res를 참조)
 * 6. 동적인 페이지를 생성 후 HttpServletResponse객체에 응답을 보낸다.
 * 7. 응답이 완료되면 HttpServletRequest, HttpServletResponse 객체를 소멸 시킨다.
 */

/*
 * GenericServlet  부모
 * service
 * 
 * HttpServlet  자식 
 * doGet, doPost 
 * 
 * 자식인 HttpServlet 상속받아서 쓰게되면 
 * service 메소드는 디폴트로 구현되어있음. 
 * 
 * GenericServlet 을 상속받아 
 * service 메소드를 오버라이딩하여  재구현 한다.
 */
public class GenericTest1 extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) 
			                      throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		out.println("<html><body><h2>hello</h2></body></html>");
		out.flush();
		out.close();
	}
	
}
