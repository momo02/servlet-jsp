package util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @quickCode ##
* @project  test01_Servlet
* @path util.FileUtil.java
* @auth CK
* @date 2017. 4. 3. 오후 8:00:59
* @other 
* 로그 관련 유틸.
 */
public class Log {

	/**
	 * @auth CK
	* @date 2017. 4. 3. 오후 8:00:30
	* @other 
	* 파일에 로그를 등록한다.
	 */
	public static boolean writeLog(String message, String filePath){
		boolean result = true;
		
		try{
			FileOutputStream fos = new FileOutputStream(filePath, true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
			
			//날짜.
			SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss초");
		    String date = fm.format(new Date());
			
			osw.write("["+date+"]"+message+"\n");
			osw.flush();
			osw.close();
		}catch(Exception e){
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}
	
	/**
	 * @auth CK
	* @date 2017. 4. 3. 오후 8:01:53
	* @other 
	* 로그기록을 보여준다.
	 */
	public static boolean printLog(InputStream is){
		boolean result =true;
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			System.out.println("=============== 로그 ================");
			while((line = br.readLine()) != null){
				System.out.println(line);
			}
			System.out.println("====================================");
		}catch(Exception e){
			System.out.println("파일 내용을 읽어오지 못했습니다.");
			result = false;
		}
		
		return result;
	}
	
}







