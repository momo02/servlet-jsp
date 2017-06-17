package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.model.BoardDao;
import dev.study.model.BoardVO;

public class BoardSelectController implements Controller{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//파라미터 받아 vo에 넣기
        int seq = Integer.parseInt(req.getParameter("seq")); //게시물 번호
        BoardVO pvo = new BoardVO();
        pvo.setSeq(seq);

        //받은값 디비에 넣기
        BoardDao dao = new BoardDao();
        BoardVO rvo = dao.selectBoard(pvo);

        //받아온값 바인딩
        req.setAttribute("rvo", rvo);

		return "/WEB-INF/jsp/detail.jsp";
	}

}
