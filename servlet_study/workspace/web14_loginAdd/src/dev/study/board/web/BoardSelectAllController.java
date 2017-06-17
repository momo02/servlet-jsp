package dev.study.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.model.BoardDao;
import dev.study.model.BoardVO;

public class BoardSelectAllController implements Controller{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		
		BoardDao dao = new BoardDao();
        BoardVO listParamVO = new BoardVO();
        listParamVO = (BoardVO) req.getAttribute("listParamVO");
        
        List<BoardVO> list = dao.selectAllBoard(listParamVO);
        
        
        req.setAttribute("list", list);
        
        //페이지 이동
        //req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, res);
        
        return "/WEB-INF/jsp/list.jsp";
		
	}

}
