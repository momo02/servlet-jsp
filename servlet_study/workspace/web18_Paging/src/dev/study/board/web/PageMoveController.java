package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.main.web.ModelAndView;
import dev.study.model.BoardDao;
import dev.study.model.BoardVO;

public class PageMoveController implements Controller{
	
	private String page;
	
	public PageMoveController(String page){
		this.page = page;
	}

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mav = null;
		
		int seq = -1;
		if(null != req.getAttribute("seq")){
			seq = Integer.parseInt(req.getAttribute("seq").toString());
		}
		
		//search 페이지로 이동
        if(page.equals("search_update") || page.equals("search_delete") || page.equals("search_selectOne")){
        	mav = new ModelAndView("/WEB-INF/jsp/search.jsp");
        }else if(page.equals("insert")){
            BoardDao dao = new BoardDao();
            req.setAttribute("maxSeq",dao.selectBoardMaxSeq());
            mav = new ModelAndView("/WEB-INF/jsp/regist.jsp");
        }else if(page.equals("update")){
        	BoardDao dao = new BoardDao();
        	BoardVO pvo = new BoardVO();
    		pvo.setSeq(seq);
    		BoardVO rvo = dao.selectBoard(pvo);
    		req.setAttribute("rvo", rvo);
    		mav = new ModelAndView("/WEB-INF/jsp/update.jsp");
        }else if(page.equals("login")){
        	mav = new ModelAndView("/WEB-INF/jsp/login.jsp");
        }else{
        	mav = new ModelAndView("/WEB-INF/jsp/main.jsp");
        }
		
		return mav;
	}

}
