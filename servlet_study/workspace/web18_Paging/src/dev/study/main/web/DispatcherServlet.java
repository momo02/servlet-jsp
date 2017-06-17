package dev.study.main.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.study.board.web.BoardDeleteController;
import dev.study.board.web.BoardInsertController;
import dev.study.board.web.BoardSelectAllController;
import dev.study.board.web.BoardSelectController;
import dev.study.board.web.BoardUpdateController;
import dev.study.board.web.Controller;
import dev.study.board.web.MemberLoginController;
import dev.study.board.web.MemberLogoutController;
import dev.study.model.BoardDao;
import dev.study.model.BoardVO;
import dev.study.model.MemberVO;
import dev.study.util.Util;

public class DispatcherServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	private void doProcess(HttpServletRequest req, HttpServletResponse res) {
        try {
        	
            String page = req.getParameter("page");
            if(null == page || "".equals(page)) page = "null";
            String seq = req.getParameter("seq");
            
            req.setAttribute("seq", seq);
            req.setAttribute("page", page);
            req.setAttribute("currentDate", Util.getCurrentDate());

            //new
            Controller controller = HandlerMapping.getInstance().createController(page);
            //new
    		ModelAndView mav = controller.execute(req, res);
            
            
            if(mav.isRedirect() == true){
    			res.sendRedirect(mav.getPath());
    		}else{
    			req.getRequestDispatcher(mav.getPath()).forward(req, res);
    		}
            
        } catch (Exception e) {
        	try {
            	req.setAttribute("message", "에러가 발생하였습니다.");
                req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, res);
            } catch (ServletException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
		}

    }
	
}
