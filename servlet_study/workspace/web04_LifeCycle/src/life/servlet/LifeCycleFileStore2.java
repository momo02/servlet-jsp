package life.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LifeCycleFileStore2 extends HttpServlet{
	
	// 서블릿의 멤버 변수 count는 요청이 올떄마가 카운트가 될까?? --> 톰캣을 껏다가 키면 다시 초기화가 되기떄문에
	// 이값을 초기화 되지않게 저장하려면 db에 저장하던지 파일로 저장해야한다.
	private int count; //디폴트값 정수형 0 
	private String path ="c:\\test\\count.txt";
	
		//1. 클래스의 생성자 호출
		public LifeCycleFileStore2() {
			System.out.println("1. 생성자 호출");
		}
	
		
		//2. init메서드 호출 (GenericServlet) 
		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			/*super.init();*/
			System.out.println("2. init() 호출");
			
			BufferedReader br = null; //지역변수니까 null로 초기화
			try{
				
				
				                    //FileReader 구버전 (글자를 한글자씩 읽어옴), BufferedReader 신버전
				br = new BufferedReader(new FileReader(path)); //글자를 한줄한줄 라인 단위로 읽어올수 있다.
				String line = br.readLine();
				count = Integer.parseInt(line);
				System.out.println("init에서 읽은 값 : "+ count);
				
			}catch(FileNotFoundException e){
				//파일이 존재하지않으면 ... 일단 상위디렉토리까지 만들어준다.
				File f = new File(path);
				f.getParentFile().mkdirs(); // count.txt 의 상위 디렉토리까지 만들어준다.
				//이건 디렉토리 생성해주는거
				System.out.println("create directory");
				
			}catch(IOException  e){
				System.out.println("error....");
				
			}catch(NumberFormatException e){
				System.out.println("읽어들이는 값이 숫자가 아닙니다.");
				
			}
		}
		
		//3. get 요청이 오면 실행된다.
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//super.doGet(req, resp); //이걸 그대로 쓰면 호출 url이 /aaa이런식일떄 -> url형식이 안맞는다는 에러 
			System.out.println("3. doGet() 호출");
			
			req.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			
			PrintWriter out = resp.getWriter();
			out.print("<html><body bgcolor='orange'>");
			out.print("<h2>Count :: </h2>" + (++count));
			out.print("</body></html>");
			
		}
		
		//3. post 요청이 오면 실행된다.
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//super.doPost(req, resp);
			System.out.println("3. doPost() 호출");
		}
		
		//4. 톰캣(컨테이너)이 내려갈때.
		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			super.destroy();
			System.out.println("4. destroy() 호출");
			
			File f = new File(path);
			f.getParentFile().mkdirs(); // count.txt 의 상위 디렉토리까지 만들어준다.
			//이건 디렉토리 생성해주는거
			System.out.println("create directory");
			try{
				PrintWriter pw = new PrintWriter(new FileWriter(f), true);
				pw.println(count);
				pw.close();
				System.out.println(path + "count 값 :: " + count + " :: 영구적으로 파일 저장.");
			}catch(IOException e){
				System.out.println("정보 저장중 에러발생!!");
				e.printStackTrace();
			}
			
		}
}
