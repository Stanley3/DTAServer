package com.dta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class DisplayUrlFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("*****DisplayUrlFilter is destoryed.*****");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest)request; 
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		String url = httpRequest.getRequestURI();
		if(!url.contains("media")){
			System.out.println("*****execute DisplayUrlFilter.*****");
			System.out.println("*****the request uri is " + url + "*****");
			System.out.println("*****the request url is " + httpRequest.getRequestURL().toString() + "*****");
			//httpResponse.sendRedirect(httpRequest.getRequestURL().toString().split(";")[0]);
		}
		/*String source = httpRequest.getParameter("source");
		if(source != null && (source.equalsIgnoreCase("android") || source.equalsIgnoreCase("ios"))){
			System.out.println("***** in *****");
			UsernamePasswordToken token = new UsernamePasswordToken();
			token.setHost(httpRequest.getRemoteHost());
			token.setPassword(httpRequest.getParameter("password").toCharArray());
			token.setRememberMe(false);
			token.setUsername(httpRequest.getParameter("username"));
			SecurityUtils.setSecurityManager(org.apache.shiro.util.ThreadContext.getSecurityManager());
			Subject subject = SecurityUtils.getSubject();
			try{
				subject.login(token);
				System.out.println("*****subject is validate :" + subject.isAuthenticated() + ".*****");
				Session session = subject.getSession();
				System.out.println("*****session id is :" + session.getId() + ".*****");
				System.out.println("*****http session id is: " + httpRequest.getSession().getId() + ".*****");
				PrintWriter print = httpResponse.getWriter();
				String result = "{\"code\":" + 1 + ", \"desc\":\"" + subject.getPrincipal().toString() + "\"}";
				print.print(result);
				print.flush();
			}catch(AuthenticationException ae){
				System.out.println("***** AuthenticationException *****");
				PrintWriter print = httpResponse.getWriter();
				String exception = "{\"code\":" + 2 + ", \"desc\":\"exceptioin\"}"; 
				print.print(exception);
				print.flush();
			}
		}*/
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("*****DisplayUrlFilter is init.*****");
	}

}
