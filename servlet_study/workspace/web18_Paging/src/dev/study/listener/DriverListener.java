package dev.study.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DriverListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sec) {
		String ODriver = sec.getServletContext().getInitParameter("ODriver");
		try{
			Class.forName(ODriver);
			System.out.println("드라이버 로딩 성공");
		}catch(ClassNotFoundException e ){
			System.out.println("드라이버 로딩 실패함..");
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

}