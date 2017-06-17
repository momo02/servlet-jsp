package form.step02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 1. 한글처리
 * 2. PrintWriter 받고
 * 3. thml폼에 입력된 값을 받아서 웹으로 출력
 * 	  이때 getParameter(), getParameterValues()를 사용
 */
public class CheckBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		//1.getParameter로 작성..
		//ex01(request, response);
		
		
		//2.getParameterMap()으로 다시 작성.
		ex02(request, response);
		
		
	}
	
	public void ex01( HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		
		String age = request.getParameter("age");
		String gender = request.getParameter("gender");
		
		String[] menu = request.getParameterValues("menu");
		//name="menu"의 값으로 넘겨진 값이 여러개일때 
		//ex) checkbox 또는 multiple select의 경우에
		//             넘겨진 다수의 값들을 이렇게 받을 수 있음
		
		out.println("<html><body><h2><b>");
		out.println("다음은" + age + "기" + gender + " 성들이 좋아하는 메뉴들입니다..<br>");
		out.println("</b></h2><p>");
		for(String s : menu) {
			out.println("<li>" + s + "<br>");
		}
		out.println("</body></html>");
	}
	
	public void ex02( HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		
		Map<String,String[]> map = request.getParameterMap(); 
		  //전달된 parameter들을 key-value 쌍의  Map 컬렉션으로 꺼낸다.
		Set<String> set = map.keySet();
		//KeySet 메소드로 키들을  Set 컬렉션으로 가져온다. 
		Iterator<String> it = set.iterator();
		//이제 iterator메소드를 사용해서 Iterator를 만들 수 있다. 
		
		out.println("<html><body>");
		
		while(it.hasNext()){
			
			String key = it.next(); //Iterator를 사용해서 key값들을 하나씩 꺼낸다.
		
			out.println("key :" + key + "<br/>");
			
			String[] value = map.get(key);//꺼낸 key를 사용해서  Map에서 key에 해당하는 값을 꺼낸다.
			
			out.println("value 갯수 : " + value.length);
			out.println("value : ");
			
			for(String s : value){
				
				out.println(s + "<br/>");
				
			}
			
			
		}
		
		out.println("</body></html>");
		
		
		
		/*
		Map<String, String[]> map = request.getParameterMap();
		Set<String> set = map.keySet(); 
		//KeySet 메소드로 키들을  Set 컬렉션으로 가져온다. 
		Iterator<String> it = set.iterator();
		//이제 iterator메소드를 사용해서 Iterator를 만들 수 있다. 
		
		while (it.hasNext()) {
			String key = it.next().toString();
			String[] value = map.get(key);

			out.println(key + " :: ");
			for (int i = 0; i < value.length; i++) {
				out.println(value[i] + "  ");
				if (i == value.length - 1)
					out.println("<br>");
			}
		}*/
		
	}
	
}
