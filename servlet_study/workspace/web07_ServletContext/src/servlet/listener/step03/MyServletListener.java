package servlet.listener.step03;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletListener implements ServletContextListener{
	
	private ServletContext servletContext;
	private InputStream is = null;
	private BufferedReader br = null;
	
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		System.out.println("톰캣이 올라갈때 실행");
	}
	
	
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("톰캣이 내려갈때 실행");
	}
	
}