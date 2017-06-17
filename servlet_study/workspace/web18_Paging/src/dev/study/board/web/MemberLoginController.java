package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.study.main.web.ModelAndView;
import dev.study.model.BoardDao;
import dev.study.model.MemberVO;

public class MemberLoginController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
    	MemberVO pvo = new MemberVO();
    	pvo.setUser_id(req.getParameter("user_id"));
    	pvo.setUser_pw(req.getParameter("user_pw"));
    	
    	BoardDao dao = new BoardDao();
    	MemberVO rvo = dao.doLogin(pvo);
    	
    	if(pvo.getUser_id().equals(rvo.getUser_id())){
    		HttpSession session = req.getSession();
    		session.setAttribute("rvo", rvo);
    		return new ModelAndView("/WEB-INF/jsp/main.jsp");
    	}else{
    		req.setAttribute("message", "아이디 혹은 비밀번호가 잘못되었습니다");
    		return new ModelAndView("/WEB-INF/jsp/message.jsp");
    	}
	}

}
