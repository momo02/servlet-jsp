package listener;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DriverListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sec) {
	    System.out.println("1. 리스너 시작");
	    	    
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("6. 리스너 종료");
	}

}
