package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.protocol.giopmsgheaders.ReplyMessage_1_0;

import util.Log;

/**
 * @quickCode ##
* @project  test01_Servlet
* @path board.controller.LoginController.java
* @auth CK
* @date 2017. 4. 3. 오후 8:07:40
* @other 
* TODO CK
 */
public class LoginController extends HttpServlet{
	
	private ServletContext servletContext;
	private String fullPath;
	
	
	@Override
	public void init() throws ServletException {
		
		System.out.println("LoginController...init");
		servletContext  = getServletContext();
		fullPath = (String)servletContext.getAttribute("fullPath");
		
	}
	
	protected void doPost(HttpServletRequest req
		, HttpServletResponse res) throws ServletException, IOException {
		
		//코드 구현...
		
		System.out.println("LoginController...doPost");
		
		//한글 설정
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8;"); 
		
		//html에 입력한 값을 가져온다.
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		
		//web.xml에 선언해둔 <init-param> 객체들을 가져온다
		String id2= getInitParameter("id");
		String pass2 = getInitParameter("pass");
		
		if(id2.equals(id)){
			
			if(pass2.equals(pass)){
				
				Log.writeLog(id+" 로그인 성공!", fullPath);
				servletContext.setAttribute("message", id+" 로그인 성공!");
				
			}else{ //비밀번호가 틀렸을 시 
				
				Log.writeLog(id+" 로그인 실패(비밀번호)", fullPath);
				servletContext.setAttribute("message", id+" 로그인 실패(비밀번호)");
			}
			
			
		}else{ //아이디가 틀렸을 시 
			
			Log.writeLog(id+" 로그인 실패(아이디)", fullPath);
			servletContext.setAttribute("message", id+" 로그인 실패(아이디)");
			
		}
		
		
		//messageServlet 으로 이동.
		RequestDispatcher rd = req.getRequestDispatcher("messageServlet.do");
		rd.forward(req, res); //요청을 다른곳으로 보냄. request와 response를 그대로 가지고 .. 
		                       //redirect와는 다르게 요청이 넘어가도 url이바뀌지않음 
	}
	
	
}
