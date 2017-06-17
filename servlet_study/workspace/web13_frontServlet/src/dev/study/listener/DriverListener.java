package dev.study.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//리스너

//1.web.xml에 정의
//2.리스너 인터페이스 상속	
//3.각각의 메서드 구현 
public class DriverListener implements ServletContextListener{
	
	//was가 시작할 때
	@Override
	public void contextInitialized(ServletContextEvent config) {
		
		  try {
			  
			//Class.forName("oracle.jdbc.driver.OracleDriver")
	            Class.forName(	config.getServletContext().getInitParameter("ODriver"));
	            System.out.println("리스너 로드 성공");
	            
	        } catch (ClassNotFoundException e) {
	            System.out.println("리스너 로드 실패");
	        }
	}

	//was가 죽을 때 
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
