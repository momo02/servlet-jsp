package dev.study.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.main.web.ModelAndView;

public interface Controller {
	ModelAndView execute(HttpServletRequest req, HttpServletResponse res) throws Exception;
}
