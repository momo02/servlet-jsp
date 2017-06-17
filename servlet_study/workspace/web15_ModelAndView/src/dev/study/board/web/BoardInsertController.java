package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.main.web.ModelAndView;
import dev.study.model.BoardDao;
import dev.study.model.BoardVO;

public class BoardInsertController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		//값받아와서 vo에 바인딩하기
        BoardVO pvo = new BoardVO();
        pvo.setSeq(Integer.parseInt(req.getParameter("seq")));
        pvo.setTitle(req.getParameter("title"));
        pvo.setContent(req.getParameter("content"));
        pvo.setUser_id(req.getParameter("user_id"));
        pvo.setReg_date(req.getParameter("reg_date"));

        //받은값 디비에 넣기
        BoardDao dao = new BoardDao();
        dao.insertBoard(pvo);

        //성공 페이지
        req.setAttribute("message","게시물 등록에 성공하였습니다!");
//        req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, res);
		
        return new ModelAndView("/WEB-INF/jsp/message.jsp");
	}

}
