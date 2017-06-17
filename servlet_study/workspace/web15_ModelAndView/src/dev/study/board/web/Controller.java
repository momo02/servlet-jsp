package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.main.web.ModelAndView;

public interface Controller {
	//old (목적지 주소만 리턴)
	//String execute(HttpServletRequest req, HttpServletResponse res) throws Exception;
	
	//new (페이지 주소, 리다이렉트 여부)
	ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception;


}
