package dev.study.main.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.board.web.BoardInsertController;
import dev.study.board.web.Controller;
import dev.study.model.BoardDao;
import dev.study.model.BoardVO;

public class DispatcherServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	
	private void doProcess(HttpServletRequest req, HttpServletResponse resp){
		
		try {

            
			Controller controller = null;
			
			String page = req.getParameter("page"); //등록버튼 수정버튼 삭제버튼  
			
			if(null == page){
				
				
			}
			
			if(page.equals("insert")){
				
				controller = new BoardInsertController();
				
			}else if(page.equals("update")){
				//controller = new BoardUpdateController();
				
			}else if(page.equals("delete")){
				
				//controller = new BoardDeleteController();
			}
			
			
			String returnPg = controller.execute(req,resp);
			
            //페이지 이동
            req.getRequestDispatcher(returnPg).forward(req, resp);

        } catch (Exception e) {
            try {
                //에러 페이지
            	req.setAttribute("message", "에러가 발생하였습니다.");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, resp);
            } catch (ServletException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
		
		
	}
}
