package dev.study.board.web;

import dev.study.model.BoardDao;
import dev.study.model.BoardVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chunkind on 2017. 4. 24..
 */
public class BoardSelectServlet extends HttpServlet{
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

            //파라미터 받아 vo에 넣기
            String page = req.getParameter("page"); //요청페이지
            int seq = Integer.parseInt(req.getParameter("seq")); //게시물 번호
            BoardVO pvo = new BoardVO();
            pvo.setSeq(seq);

            //받은값 디비에 넣기
            BoardDao dao = new BoardDao();
            BoardVO rvo = dao.selectBoard(pvo);

            //받아온값 바인딩
            req.setAttribute("rvo", rvo);

            //성공 페이지
            String rpage = "";
            if(page.equals("update")){
                rpage = "/WEB-INF/jsp/update.jsp";
            }else if(page.equals("selectOne")){
                rpage = "/WEB-INF/jsp/detail.jsp";
            }else if(page.equals("delete")){
            	rpage = "boardDeleteServlet.go";
            }else{
                rpage = "/WEB-INF/jsp/error.jsp";
            }
            req.getRequestDispatcher(rpage).forward(req, res);

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
