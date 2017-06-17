package dev.study.board.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.study.model.BoardDao;
import dev.study.model.BoardVO;

import java.io.IOException;
import java.util.List;

/**
 * Created by chunkind on 2017. 4. 24..
 */
public class BoardSelectAllServlet extends HttpServlet{
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

            BoardDao dao = new BoardDao();
            BoardVO listParamVO = new BoardVO();
            listParamVO = (BoardVO) req.getAttribute("listParamVO");
            
            List<BoardVO> list = dao.selectAllBoard(listParamVO);
            
            
            req.setAttribute("list", list);
            
            //페이지 이동
            req.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, res);

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
