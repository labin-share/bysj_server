package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import constant.LoginConstant;

public class LoginFilter implements Filter{
	
	private static String REDIRECT_URL = "redirectUrl";
	private String redirectUrl;

	public void init(FilterConfig filterConfig) throws ServletException {
		redirectUrl = filterConfig.getInitParameter(REDIRECT_URL);
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response; 
		HttpSession session = httpServletRequest.getSession();
		if(httpServletRequest.getRequestURI().indexOf(redirectUrl)>-1){
			chain.doFilter(request, response);
		}
		if(session.getAttribute(LoginConstant.USER_NAME)==null){
			httpServletResponse.sendRedirect(redirectUrl);
		}else{
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		
	}

}
