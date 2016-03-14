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
	private static String IGNORE_Login_URL = "ignoreLoginUrl";
	private static String IGNORE_REGISTER_URL = "ignoreRegisterUrl";
	private String redirectUrl;
	private String ignoreLoginUrl;
	private String ignoreRegisterUrl;

	public void init(FilterConfig filterConfig) throws ServletException {
		ignoreLoginUrl = filterConfig.getInitParameter(IGNORE_Login_URL);
		ignoreRegisterUrl = filterConfig.getInitParameter(IGNORE_REGISTER_URL);
		redirectUrl = filterConfig.getInitParameter(redirectUrl);
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest  httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response; 
		HttpSession session = httpServletRequest.getSession();
		String host = request.getRemoteAddr();
		if(httpServletRequest.getRequestURI().indexOf(ignoreRegisterUrl)>-1 || httpServletRequest.getRequestURI().indexOf(ignoreLoginUrl)>-1){
			chain.doFilter(request, response);
			return ;
		}
		if(session.getAttribute(LoginConstant.USER_NAME)==null){
			httpServletResponse.sendRedirect("/login/showErr");
			return ;
		}else{
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		
	}

}
