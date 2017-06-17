package listener;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sun.javafx.property.adapter.PropertyDescriptor.Listener;

import util.Log;

/**
 * @quickCode ##
* @project  test01_Servlet
* @path listener.MyListener.java
* @auth CK
* @date 2017. 4 . 3. 오후 8:07:58
* @other 
* TODO CK
 */
public class MyListener implements ServletContextListener{ 

	private ServletContext servletContext;
	private String rootPath;
	private String filePath;
	private String fullPath;
	
	
	
	/**
	 * @auth CK
	* @date 2017. 4. 3. 오후 8:10:23
	* @other 
	* 톰캣 초기화시. 로그를 출력한다.
	 */
	public void contextInitialized(ServletContextEvent servletContextEvent){
		try{
			//서블릿컨택스트 초기화
			servletContext = servletContextEvent.getServletContext();
			
			/**
			 * rootPath는 os마다 다를수 있고 이클립스가 설치된 컴퓨터마다 다를수 있어서
			 * 동적으로 구함.
			 */
			rootPath = servletContextEvent.getServletContext().getRealPath(".");
			
			System.out.println("rootPath>>> " + rootPath);
			
			//filePath는 동일하므로 context 에서 저장하여 사용함.
			filePath = servletContext.getInitParameter("filePath");
			 							//WEB-INF/member.txt
			//fullPath를 컨텍스트에 저장.
			fullPath = rootPath + "/" + filePath;
			servletContext.setAttribute("fullPath", fullPath);
			
			//파일이 없으면 만들어준다.
			File file = new File(fullPath);
			File dir = new File(file.getParent());
			if(!dir.exists()) dir.mkdirs();
			if(!file.exists()) file.createNewFile();
			
			//톰켓 시작 로그를 남긴다.
			Log.writeLog("톰켓 시작", fullPath);
			
			//로그를 출력하는 메서드.
			Log.printLog(servletContext.getResourceAsStream(filePath));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @auth CK
	* @date 2017. 4. 3. 오후 8:10:38
	* @other 
	* TODO CK
	* 톰캣 종료시 종료 로그를 남긴다.
	 */
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		Log.writeLog("톰켓 종료", fullPath);
	}

}
