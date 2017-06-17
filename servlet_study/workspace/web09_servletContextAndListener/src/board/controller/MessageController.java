package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @quickCode ##
* @project  test01_Servlet
* @path board.controller.MessageController.java
* @auth CK
* @date 2017. 4. 3. 오후 8:07:46
* @other 
* TODO CK
 */
public class MessageController extends HttpServlet{
	
	private ServletContext context;
	
	@Override
	public void init() throws ServletException {
		context = getServletContext();
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			showView(req, res, context.getAttribute("message")+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//로그인이 완료되면 보여줄 페이지
	public void showView(HttpServletRequest req, HttpServletResponse res, String message) throws Exception{
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");
		
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login페이지</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>"+context.getAttribute("message")+"</div>");
		out.println("</body>");
		out.println("</html>");
		
	}
}
