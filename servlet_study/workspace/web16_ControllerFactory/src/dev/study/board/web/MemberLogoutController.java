package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.main.web.ModelAndView;

public class MemberLogoutController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//세션 끊는법.
    	req.getSession().invalidate();
    	req.setAttribute("message", "로그아웃 되었습니다.");
    	return new ModelAndView("/WEB-INF/jsp/message.jsp");
	}

}
