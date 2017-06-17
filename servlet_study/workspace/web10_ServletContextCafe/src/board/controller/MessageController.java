package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
			req.setAttribute("send", "hi");
			
			
			//forward :컨테이너내 에서 요청을 넘긴다
			RequestDispatcher rd = req.getRequestDispatcher("message.jsp"); //경로의 시작점은 webContent부터 
			rd.forward(req, res);
			
			//redirect : 브라우저에서 새로 요청을 넘김 .request를 새로 만들어보내서 send hi 는 안찍힘
			//but context 에 저장해둔 값은 출력됨.. 모두공통으로 쓰기떄문
			//res.sendRedirect("message.jsp");
			// res.sendRedirect("message.jsp"); 
			//네이버같은 다른 웹사이트로 리다이렉트도 가능하다. but forward은 컨테이너에서 요청을 넘기는거기떄문에 불가 
			
			// forward : 주소바뀌지않음 컨테이너내에서 req, res 를 가지고 요청을 넘김.
		    // Redirect :웹브라우저로 다시 해당 페이지에 요청을 보낸다. 브라우저에서 주소 변경됨. href=""는 리다이렉트.  
			
			//showView(req, res, context.getAttribute("message")+"");
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
