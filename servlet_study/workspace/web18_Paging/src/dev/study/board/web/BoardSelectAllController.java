package dev.study.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.main.web.ModelAndView;
import dev.study.model.BoardDao;
import dev.study.model.BoardVO;
import dev.study.paging.PagingBean;

public class BoardSelectAllController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception{
		BoardDao dao = new BoardDao();
        BoardVO listParamVO = new BoardVO();
        listParamVO = (BoardVO) req.getAttribute("listParamVO");
        
        /////////////////////////////new : paging 코드 추가////////////////////////////
        //1. 게시물의 전체 갯수가 필욯다.
        int totalCnt = dao.selectBoardListCount();
        //2. 현재 페이지를 알아야 한다.
        int currentPg = 1;
        //프론트에서 보낸 페이지가 있다면 변경!!
        if(null != req.getParameter("currentPg")){
        	currentPg = Integer.parseInt(req.getParameter("currentPg"));
        }
        PagingBean paging = new PagingBean(totalCnt, currentPg);
        if(null == listParamVO) listParamVO = new BoardVO();
        listParamVO.setPaging(paging);
        //requestScope영역에 담는다.
        req.setAttribute("paging", paging);
        ////////////////////////////////////////////////////////////////////////////
        
        List<BoardVO> list = dao.selectAllBoard(listParamVO);
        
        req.setAttribute("list", list);
        
        return new ModelAndView("/WEB-INF/jsp/list.jsp");
	}

}
