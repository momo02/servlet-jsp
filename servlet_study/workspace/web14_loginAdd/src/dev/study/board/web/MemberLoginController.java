package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.study.model.BoardDao;
import dev.study.model.MemberVO;

public class MemberLoginController implements Controller{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String returnPg = "";
		
		//프론트에서 받아온 값
    	MemberVO pvo = new MemberVO();
    	pvo.setUser_id(req.getParameter("user_id"));
    	pvo.setUser_pw(req.getParameter("user_pw"));
    	
    	//백에서 받아온값
    	BoardDao dao = new BoardDao();
    	MemberVO rvo = dao.doLogin(pvo);
    	
    	//페이지 이동
    	if(pvo.getUser_id().equals(rvo.getUser_id())){
    		//로그인이 되었을때
    		//req.setAttribute("rvo", rvo);
    		
    		//세션사용
    		HttpSession session = req.getSession();
    		session.setAttribute("rvo", rvo);
    		return "/WEB-INF/jsp/main.jsp";
    	}else{
    		//로그인 실패.
    		req.setAttribute("message", "아이디 혹은 비밀번호가 잘못되었습니다");
    		return "/WEB-INF/jsp/message.jsp";
    	}
		
	}

}
