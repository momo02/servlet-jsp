package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.main.web.ModelAndView;
import dev.study.model.BoardDao;

public class BoardDeleteController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String seq = (String) req.getAttribute("seq");
        
        BoardDao dao = new BoardDao();
        dao.deleteBoard(Integer.parseInt(seq));
        
        req.setAttribute("message", "삭제 하였습니다.");
        
        return new ModelAndView("/WEB-INF/jsp/message.jsp");
	}

}
