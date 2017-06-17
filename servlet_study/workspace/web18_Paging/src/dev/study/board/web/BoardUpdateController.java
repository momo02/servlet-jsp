package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.main.web.ModelAndView;
import dev.study.model.BoardDao;
import dev.study.model.BoardVO;

public class BoardUpdateController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        BoardVO pvo = new BoardVO();
        pvo.setTitle(req.getParameter("title"));
        pvo.setContent(req.getParameter("content"));
        pvo.setUser_id(req.getParameter("user_id"));
        pvo.setReg_date(req.getParameter("reg_date"));
        pvo.setSeq(Integer.parseInt(req.getParameter("seq")));
        
        BoardDao dao = new BoardDao();
        dao.updateBoard(pvo);
        
        req.setAttribute("rvo", pvo);
        
		return new ModelAndView("/WEB-INF/jsp/detail.jsp");
	}

}
