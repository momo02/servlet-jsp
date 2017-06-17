package dev.study.board.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.model.BoardDao;
import dev.study.model.BoardVO;

import java.io.IOException;

/**
 * Created by chunkind on 2017. 4. 24..
 */
public class BoardDeleteServlet extends HttpServlet{
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
        try {
              //한글처리
        	req.setCharacterEncoding("UTF-8");
        	res.setContentType("text/html;charset=UTF-8");
         //삭제 로직
        	
        	BoardVO rvo =	(BoardVO)req.getAttribute("rvo");
         
        	BoardDao dao = new BoardDao();
        	
        	dao.deleteBoard(rvo.getSeq());
        	
              //메세지.
              req.setAttribute("message", "삭제 하였습니다.");
              
              //페이지 이동.
              req.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(req, res);

          } catch (Exception e) {
              try {
                  //에러 페이지
               req.setAttribute("message", "에러가 발생하였습니다.");
                  req.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(req, res);
              } catch (ServletException e1) {
                  e1.printStackTrace();
              } catch (IOException e1) {
                  e1.printStackTrace();
              }
          }
      }
}