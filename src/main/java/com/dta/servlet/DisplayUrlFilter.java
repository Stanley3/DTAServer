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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisplayUrlFilter implements Filter{
	private Logger logger = LoggerFactory.getLogger("com.dta.servlet.DisplayUrlFilter");
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		logger.info("DisplayUrlFilter is destoryed.");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest)request; 
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		String url = httpRequest.getRequestURI();
		if(!url.contains("media")){
			logger.info("the request uri is {}", url);
			//httpResponse.sendRedirect(httpRequest.getRequestURL().toString().split(";")[0]);
		}
		System.out.println("是否登录失败:" + request.getAttribute("shiroLoginFailure") == null);
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("DisplayUrlFilter is init.");
	}

}
