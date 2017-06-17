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
    	try {
            //한글처리
//            req.setCharacterEncoding("utf-8");
//            res.setContentType("text/html");
//            res.setCharacterEncoding("utf-8");

            //수정값 받아오기.
            BoardVO pvo = new BoardVO();
            pvo.setTitle(req.getParameter("title"));
            pvo.setContent(req.getParameter("content"));
            pvo.setUser_id(req.getParameter("user_id"));
            pvo.setReg_date(req.getParameter("reg_date"));
            pvo.setSeq(Integer.parseInt(req.getParameter("seq")));
            
            BoardDao dao = new BoardDao();
            dao.updateBoard(pvo);
            
            req.setAttribute("rvo", pvo);
            
            //페이지 이동
            req.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(req, res);

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
