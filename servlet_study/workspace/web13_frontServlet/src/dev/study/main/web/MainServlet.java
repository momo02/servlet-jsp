package dev.study.main.web;

import dev.study.model.BoardDao;
import dev.study.model.BoardVO;
import dev.study.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by chunkind on 2017. 4. 24..
 */
public class MainServlet extends HttpServlet{
    String method = "";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        method = "post";
        prosecce(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        method = "get";
        prosecce(req, resp);
    }

    private void prosecce(HttpServletRequest req, HttpServletResponse res) {
        try {
            String returnPg = "";

            String page = req.getParameter("page");
            if(null == page || "".equals(page)) page = "null";

            //페이지 정보
            req.setAttribute("page", page);
            //날짜
            req.setAttribute("currentDate", Util.getCurrentDate());


            if(page.equals("selectAll")){
            	BoardVO listParamVO = new BoardVO();
            	listParamVO.setFirstIndex("1");
            	listParamVO.setRecordCountPerPage("2");
            	req.setAttribute("listParamVO", listParamVO);
                returnPg = "boardSelectAllServlet.go";
            }else if(page.equals("insert")){
                BoardDao dao = new BoardDao();
                req.setAttribute("maxSeq",dao.selectBoardMaxSeq());
                returnPg = "/WEB-INF/jsp/regist.jsp";
            }else if(page.equals("update")){
                returnPg = "/WEB-INF/jsp/search.jsp";
            }else if(page.equals("delete")){
                returnPg = "/WEB-INF/jsp/search.jsp";
            }else if(page.equals("selectOne")){
                returnPg = "/WEB-INF/jsp/search.jsp";
            }else{
                returnPg = "/WEB-INF/jsp/main.jsp";
            }

            req.getRequestDispatcher(returnPg).forward(req, res);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}





