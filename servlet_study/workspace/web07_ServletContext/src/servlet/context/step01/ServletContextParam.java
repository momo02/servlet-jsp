package servlet.context.step01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//6.메서드 들이 콜되는 순서.
public class ServletContextParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//1.ServletContext 선언.
	ServletContext context;
	
	public ServletContextParam(){
		
		System.out.println("1.생성자 호출!!!!");
		/*context.setInitParameter("userFile22", "aaaaa");*/
		
		System.out.println("1-1.context param에 저장한 값 꺼내기");
		/*System.out.println(">>>" + context.getInitParameter("userName1") );*///에러. 아직 값이 null 
		
		System.out.println("1-2.init param에 저장한 값 꺼내기");
		/*System.out.println(">>>" + getInitParameter("userName1"));*///에러. 아직 값이 null 
		
		// init이 호출된 시점부터 서블릿 객체가 되기때문에
		// 생성자 호출시에는 context param에 저장된 값도, init param에 저장된 값도 읽어올 수 없다. 
		
	}
	
	//context.setInitParameter("userFile22", "aaaaa");
	@Override
	public void init() throws ServletException { //서블릿이 만들어질때 딱 한번 호출 
		
		System.out.println("2.init 메서드호출!!!!");
		
		//2.servlet Context를 초기화한다.
		context = getServletContext();
		
		//3.하나하나 뽑기.
		
		String userName1 = context.getInitParameter("userName1");
		String userName2 =context.getInitParameter("userName2");
		String userName3 =context.getInitParameter("userName3");
		String userFile = context.getInitParameter("userFile");
		
		
//		System.out.println(context.getInitParameter("userFile22"));   ///null 
		System.out.println(">>>"  + context.getInitParameter("userName1"));
		
		
		/*context.setInitParameter("userFile22", "aaaaa"); //이 메서드는 왜 있는거지??
		System.out.println(context.getInitParameter("userFile22"));*/
		
		
		//4.Collection API를 이용하여 뽑기.
		Enumeration<String> en = context.getInitParameterNames();
		while(en.hasMoreElements()){
			String key = en.nextElement();
			String value = context.getInitParameter(key);
			System.out.println("key :" + key + ", value : " + value);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("2.doGet 메서드호출!!!!");
		//5.한글설정.
		
		//방법1
	//	response.setCharacterEncoding("UTF-8");
	//	response.setContentType("text/html");
		//방법2
		response.setContentType("text/html; charset=UTF-8"); //이렇게 합쳐쓸수 있다
		
		//문서객체 초기화
		PrintWriter out = response.getWriter();
		out.println("<h3><b>콘솔을 확인하세요.</b></h3>");
		out.close();
	}
	
	@Override
	public void destroy() {
		
	}
}
