package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.main.web.ModelAndView;
import dev.study.model.BoardDao;
import dev.study.model.BoardVO;

public class BoardSelectController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
        int seq = Integer.parseInt(req.getParameter("seq")); //게시물 번호
        BoardVO pvo = new BoardVO();
        pvo.setSeq(seq);

        BoardDao dao = new BoardDao();
        BoardVO rvo = dao.selectBoard(pvo);

        req.setAttribute("rvo", rvo);
        
        return new ModelAndView("/WEB-INF/jsp/detail.jsp");
	}

}
