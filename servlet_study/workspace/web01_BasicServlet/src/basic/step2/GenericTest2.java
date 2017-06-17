package basic.step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericTest2 extends GenericServlet{

	//background color = yellow
	//body bgcolor = 'yellow'
	//<h1>hello</h1>

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException{
		
		
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		PrintWriter out = res.getWriter();
		
		
		out.println("<html>");
		out.println("<body bgcolor = 'yellow'>");
		out.println("<h1>hello 안녕하세요~~!!</h1>");
		
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
	}
	
	
	
}
