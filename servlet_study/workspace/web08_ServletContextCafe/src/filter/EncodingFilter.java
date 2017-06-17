package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter{
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		System.out.println("필터 init:::::::::::::::::::::");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//chain.doFilter(arg0, arg1);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
	
}
