package dev.study.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chunkind on 2017. 4. 24..
 */
public class BoardDao {

    String URL = "jdbc:oracle:thin:@victory.cs8zfdntdlzp.ap-northeast-2.rds.amazonaws.com:1521:orcl";
    String USER = "victory";
    String PASS = "victory123";

    public Connection getConnection(){
        Connection c = null;
        try {
            c = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    ///////////////////비즈니스 로직//////////////////

    //게시물 삭제
    public boolean deleteBoard(int seq){
        boolean result = false;

        Connection c = null;
        PreparedStatement ps = null;

        try{
            c = getConnection();
            String sql = "DELETE FROM STUDY_BOARD WHERE SEQ = ?";
            ps = c.prepareStatement(sql);
            ps.setInt(1, seq);

            result = ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    //게시물 등록
    public int insertBoard(BoardVO vo){
        int result = 0;

        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = getConnection();
            String sql = "insert into study_board(seq, title, content, user_id, reg_date) " +
                         "values(?, ?, ?, ?, to_date(?,'YYYY-MM-DD HH24:MI:SS'))";
            ps = c.prepareStatement(sql);
            ps.setInt(1, vo.getSeq());
            ps.setString(2, vo.getTitle());
            ps.setString(3, vo.getContent());
            ps.setString(4, vo.getUser_id());
            ps.setString(5, vo.getReg_date());

            result = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("결과 : " + result);
                if(null != c) c.close();
                if(null != ps) ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    //게시물 수정
    public boolean updateBoard(BoardVO vo){
        boolean result = false;

        Connection c = null;
        PreparedStatement ps = null;

        try{
            c = getConnection();
            String sql = "UPDATE STUDY_BOARD SET TITLE = ?, CONTENT = ?, USER_ID = ?, REG_DATE = to_date(?,'YYYY-MM-DD HH24:MI:SS') WHERE SEQ = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1, vo.getTitle());
            ps.setString(2, vo.getContent());
            ps.setString(3, vo.getUser_id());
            ps.setString(4, vo.getReg_date());
            ps.setInt(5, vo.getSeq());

            result = ps.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }


        return result;
    }

    //게시물 샐랙트
    public BoardVO selectBoard(BoardVO vo){
        BoardVO rvo = new BoardVO();

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            c = getConnection();
            String sql = "SELECT SEQ, TITLE, CONTENT, USER_ID, TO_CHAR(REG_DATE,'YYYY-MM-DD HH24:MI:SS') FROM STUDY_BOARD";

            String value = "";
            if(null != vo.getTitle()){
                sql += " WHERE TITLE = ?";
                value = vo.getTitle();
            }else if(null != vo.getContent()){
                sql += " WHERE CONTENT = ?";
                value = vo.getContent();
            }else if(null != vo.getUser_id()){
                sql += " WHERE USER_ID = ?";
                value = vo.getUser_id();
            }else if(null != vo.getReg_date()){
                sql += " WHERE REG_DATE = ?";
                value = vo.getReg_date();
            }else{
                sql += " WHERE SEQ = ?";
                value = vo.getSeq()+"";
            }
            ps = c.prepareStatement(sql);
            ps.setString(1, value);

            rs = ps.executeQuery();
            if(rs.next()){
                rvo.setSeq(rs.getInt(1));
                rvo.setTitle(rs.getString(2));
                rvo.setContent(rs.getString(3));
                rvo.setUser_id(rs.getString(4));
                rvo.setReg_date(rs.getString(5));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return rvo;
    }
    
    //게시물 리스트 가져오기.
    public List<BoardVO> selectAllBoard(BoardVO pvo){
    	List<BoardVO> list = new ArrayList<BoardVO>();
    	BoardVO rvo = null;
    	
    	Connection c = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	try{
    		c = getConnection();
    		String sql = "";
    		sql += "SELECT SEQ";
    		sql += "	 , TITLE";
    		sql += "	 , CONTENT";
    		sql += "	 , USER_ID";
    		sql += "	 , REG_DATE";
    		sql += "  FROM STUDY_BOARD";
    		sql += " ORDER BY SEQ";
    		ps = c.prepareStatement(sql);
    		rs = ps.executeQuery();
    		
    		while(rs.next()){
    			rvo = new BoardVO();
    			rvo.setSeq(rs.getInt(1));
    			rvo.setTitle(rs.getString(2));
    			rvo.setContent(rs.getString(3));
    			rvo.setUser_id(rs.getString(4));
    			rvo.setReg_date(rs.getString(5));
    			list.add(rvo);
    		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return list;
    }

    //게시물 최고 seq 가져오기
    public int selectBoardMaxSeq(){
        int result = -1;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getConnection();
            String sql = "SELECT STUDY_BOARD_SEQ.NEXTVAL FROM DUAL";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            if(rs.next()){
                result = rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    //게시물 갯수 가져오기.
    public int selectBoardListCount(){
        int result = -1;
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            c = getConnection();
            String sql = "SELECT COUNT(1) FROM STUDY_BOARD";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            if(rs.next()){
                result = rs.getInt(1);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    
    public MemberVO doLogin(MemberVO pvo){
    	MemberVO rvo = new MemberVO();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
        	//jdbc 2단계 커낵션 얻어오기.
            c = getConnection();
            /////////////////jdbc 3단계 쿼리문 생성//////////////////////
            String sql = "SELECT ID, PW FROM MEMBER WHERE ID = ? AND PW =?";
            ps = c.prepareStatement(sql);
            ps.setString(1, pvo.getUser_id());
            ps.setString(2, pvo.getUser_pw());
            //////////////////////////////////////////////
            //jdbc 4단계 결과 받아오기.
            rs = ps.executeQuery();
            if(rs.next()){
                rvo.setUser_id(rs.getString(1));
                rvo.setUser_pw(rs.getString(2));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rvo;
    }
    
    //테스트를 위한 메인
    public static void main(String[] args) throws ClassNotFoundException{
        BoardDao dao = new BoardDao();
        
        //로그인 테스트
        MemberVO pvo = new MemberVO();
        pvo.setUser_id("kjs");
        pvo.setUser_pw("wnstjd");
        Class.forName("oracle.jdbc.driver.OracleDriver");
        MemberVO rvo = dao.doLogin(pvo);
        System.out.println(rvo.toString());
        
        
        //게시물 등록
//        BoardVO registerPvo = new BoardVO();
//        registerPvo.setTitle("제목입니당.");
//        registerPvo.setContent("내용입니당.");
//        registerPvo.setUser_id("chunkind");
//        registerPvo.setReg_date(Util.getCurrentDate());
//        dao.insertBoard(pvo);

        //게시물 삭제
//        dao.deleteBoard(2);

        //게시물 1개 가져오기
//        BoardVO selectPvo = new BoardVO();
//        selectPvo.setSeq(3);
//        BoardVO rvo = dao.selectBoard(selectPvo);
//        System.out.println(rvo.toString());

        //게시물 수정
//        BoardVO updatePvo = new BoardVO();
//        updatePvo.setTitle("변경된 제목 입니당");
//        updatePvo.setContent("변경된 내용 입니당");
//        updatePvo.setUser_id("chunkind");
//        updatePvo.setReg_date(Util.getCurrentDate());
        //변경할 seq 지정
//        updatePvo.setSeq(3);
//        dao.updateBoard(updatePvo);

        //seq 구하기
//        int result = dao.selectBoardMaxSeq();
        
        //리스트 가져오기.
//        BoardVO selectAllPvo = new BoardVO();
//        selectAllPvo.setFirstIndex("1");
//        selectAllPvo.setRecordCountPerPage("2");
//        
//        List<BoardVO> list = dao.selectAllBoard(selectAllPvo);
//        System.out.println(list.toString());
        
        
        //리스트 갯수 가져오기.
//        int totalListCnt = dao.selectBoardListCount();
//        System.out.println(totalListCnt);
        
    }

}
