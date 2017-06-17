package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.context.vo.PersonVO;

public class ViewServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private List<PersonVO> list;
    
    public ViewServlet(){
    	System.out.println("1:::ViewServlet 생성자");
    }
    
	@Override
    public void init() throws ServletException {
		System.out.println("2:::ViewServlet init");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3:::ViewServlet doGet");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("3:::ViewServlet doPost");
		
		//req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = resp.getWriter();
		
		PersonVO p = (PersonVO)req.getAttribute("personInfo");
		
		out.println("이름 : " + p.getName());
		out.println("나이 : " + p.getAge());
	}
	 
	@Override
	public void destroy() {
		
	}
}
