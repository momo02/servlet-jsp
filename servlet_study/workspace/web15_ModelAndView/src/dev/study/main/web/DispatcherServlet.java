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
            //old
        	//String returnPg = "/WEB-INF/jsp/main.jsp";
        	//new
        	ModelAndView mav = new ModelAndView("/WEB-INF/jsp/main.jsp");
        	
        	
            String page = req.getParameter("page");
            if(null == page || "".equals(page)) page = "null";
            
            String seq = req.getParameter("seq");

            //페이지 정보
            req.setAttribute("page", page);
            //날짜
            req.setAttribute("currentDate", Util.getCurrentDate());

            Controller controller = null;
            
            //dao 작업 후 페이지 이동.
            if(page.equals("do_login")){
            	controller = new MemberLoginController();
            }else if(page.equals("do_logout")){
            	controller = new MemberLogoutController();
            }else if(page.equals("do_selectAll")){
            	BoardVO listParamVO = new BoardVO();
            	req.setAttribute("listParamVO", listParamVO);
            	
            	controller = new BoardSelectAllController();
            }
            else if(page.equals("do_insert")){
            	controller = new BoardInsertController();
            }
            else if(page.equals("do_update")){
            	controller = new BoardUpdateController();
            }
            else if(page.equals("do_delete")){
            	if(null != null){
            		req.setAttribute("seq", seq);
            	}
            	controller = new BoardDeleteController();
            }
            else if(page.equals("do_selectOne")){
            	controller = new BoardSelectController();
            }
            
            if(null != controller){
          
            	mav = controller.execute(req, res); 
            	
           
            }
            
            //search 페이지로 이동
            if(page.equals("search_update") || page.equals("search_delete") || page.equals("search_selectOne")){
            	mav = new ModelAndView("/WEB-INF/jsp/search.jsp");
            }
            
            //page 이동.
            else if(page.equals("insert")){
                BoardDao dao = new BoardDao();
                req.setAttribute("maxSeq",dao.selectBoardMaxSeq());
                mav = new ModelAndView("/WEB-INF/jsp/regist.jsp");
            }
            else if(page.equals("update")){
            	BoardDao dao = new BoardDao();
            	
            	BoardVO pvo = new BoardVO();
            	if(seq != null){
            		pvo.setSeq(Integer.parseInt(seq));
            		BoardVO rvo = dao.selectBoard(pvo);
            		req.setAttribute("rvo", rvo);
            		mav = new ModelAndView("/WEB-INF/jsp/update.jsp");
            	}else{
            		System.out.println("seq가 없습니다.");
            	}
            	
            }
            else if(page.equals("login")){
            	mav = new ModelAndView("/WEB-INF/jsp/login.jsp");
            }
            
            
         	if(mav.isRedirect()){
        		res.sendRedirect(mav.getPath());
        	}else{
        		req.getRequestDispatcher(mav.getPath()).forward(req, res);
        	}
        	
            
            
            
        } catch (Exception e) {
        	try {
                //에러 페이지
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
