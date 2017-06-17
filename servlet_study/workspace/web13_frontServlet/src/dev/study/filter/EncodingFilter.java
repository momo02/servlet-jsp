package dev.study.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * 필터 구현방법
 * 1.web.xml에 정의
 * 2.Filter 인터페이스 구현
 * 3.메서드 구현
 *
 */
public class EncodingFilter implements Filter {

	String encodingType;
	String docType;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		//사전 작업
		 //한글처리
        req.setCharacterEncoding(encodingType);
        res.setContentType(docType);
        res.setCharacterEncoding(encodingType);
		
		chain.doFilter(req, res); //사전작업을 한 후 에 서블릿으로 요청을 넘긴다. 
		
		
		//사후 작업
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		encodingType = config.getInitParameter("encodingType");  // web.xml 내의 필터 설정값 구함
		docType = config.getInitParameter("docType");
	}

}
