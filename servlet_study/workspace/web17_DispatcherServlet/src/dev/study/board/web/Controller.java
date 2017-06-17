package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.main.web.ModelAndView;

public interface Controller {
	
	//new (페이지 주소, 리다이렉트 여부)
	ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception;


}
