package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.main.web.ModelAndView;
import dev.study.model.BoardDao;

public class BoardDeleteController implements Controller{

	@Override
	//old
	//public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	
	//new
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		 //파라미터 받아오기.
        String seq = (String) req.getAttribute("seq");
        
        //게시물 삭제.
        BoardDao dao = new BoardDao();
        dao.deleteBoard(Integer.parseInt(seq));
        
        //메세지.
        req.setAttribute("message", "삭제 하였습니다.");
        
        //페이지 이동.
        //req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, res);
        
        //old
        //return "/WEB-INF/jsp/message.jsp";
	
        //new
        return new ModelAndView("/WEB-INF/jsp/message.jsp");
	}

}
