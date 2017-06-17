package dev.study.board.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.model.BoardDao;
import dev.study.model.BoardVO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by chunkind on 2017. 4. 24..
 */
public class BoardUpdateServlet extends HttpServlet{
    String method = "";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        method = "post";
        execute(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        method = "get";
        execute(req, resp);
    }

    private void execute(HttpServletRequest req, HttpServletResponse res) {
    	
    	BoardVO vo = new BoardVO();
		BoardDao dao = new BoardDao();
		
		try {
			req.setCharacterEncoding("UTF-8");
			
			vo.setUser_id(req.getParameter("user_id"));
			vo.setReg_date(req.getParameter("reg_date"));
			vo.setTitle(req.getParameter("title"));
			vo.setSeq(Integer.parseInt(req.getParameter("seq")));
			vo.setContent(req.getParameter("content"));
			
			dao.updateBoard(vo);
			
			 //성공 페이지
	        req.setAttribute("message","게시물 수정에 성공하였습니다!");
	        req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, res);
		
	 
			
		} catch (Exception e) {
			
			try{
    			
    			req.setAttribute("message", "에러가 발생하였습니다");
    			req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, res);
    		}catch(ServletException e1){
    			e1.printStackTrace();
    		}catch(IOException e1){
    			
    			e1.printStackTrace();
    		}
		}
		
		
		 
    }
}
