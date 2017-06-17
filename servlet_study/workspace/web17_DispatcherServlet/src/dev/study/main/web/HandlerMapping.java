package dev.study.main.web;

import dev.study.board.web.BoardDeleteController;
import dev.study.board.web.BoardInsertController;
import dev.study.board.web.BoardSelectAllController;
import dev.study.board.web.BoardSelectController;
import dev.study.board.web.BoardUpdateController;
import dev.study.board.web.Controller;
import dev.study.board.web.MemberLoginController;
import dev.study.board.web.MemberLogoutController;
import dev.study.board.web.PageMoveController;
import dev.study.model.BoardVO;

/**
 * 싱글톤 패턴(안티 패턴)
 * 디자인패턴 중 지양하는 패턴
 *
 */
public class HandlerMapping {
	private static HandlerMapping handlerMapping = null;
	private HandlerMapping(){};
	
	public static HandlerMapping getInstance(){
		if(HandlerMapping.handlerMapping == null){
			
			return new HandlerMapping();
		}else{
			
			return HandlerMapping.handlerMapping;
		}
		
	}
	
	public Controller createController(String command){
		Controller controller = null;
		
		 //dao 작업 후 페이지 이동.
        if(command.equals("do_login")){
        	controller = new MemberLoginController();
        }else if(command.equals("do_logout")){
        	controller = new MemberLogoutController();
        }else if(command.equals("do_selectAll")){
        	BoardVO listParamVO = new BoardVO();
        	controller = new BoardSelectAllController();
        }
        else if(command.equals("do_insert")){
        	controller = new BoardInsertController();
        }
        else if(command.equals("do_update")){
        	controller = new BoardUpdateController();
        }
        else if(command.equals("do_delete")){
        	controller = new BoardDeleteController();
        }
        else if(command.equals("do_selectOne")){
        	controller = new BoardSelectController();
        }
        //new 
        else{
        	controller = new PageMoveController(command);
        }
        
        
        return controller;
        
     
	}
}
