package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.model.BoardDao;
import dev.study.model.BoardVO;

public class BoardUpdateController implements Controller{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//수정값 받아오기.
        BoardVO pvo = new BoardVO();
        pvo.setTitle(req.getParameter("title"));
        pvo.setContent(req.getParameter("content"));
        pvo.setUser_id(req.getParameter("user_id"));
        pvo.setReg_date(req.getParameter("reg_date"));
        pvo.setSeq(Integer.parseInt(req.getParameter("seq")));
        
        BoardDao dao = new BoardDao();
        dao.updateBoard(pvo);
        
        req.setAttribute("rvo", pvo);
        
        //페이지 이동
//        req.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(req, res);
        
		return "/WEB-INF/jsp/detail.jsp";
	}

}
