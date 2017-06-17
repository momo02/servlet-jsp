package basic.step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletTest3 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.service(req, res);
		
		
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
