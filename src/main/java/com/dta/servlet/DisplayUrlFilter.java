package com.dta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.regex.Pattern;

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
import org.springframework.util.StringUtils;

import com.dta.service.ISysUserService;
import com.dta.service.impl.SysUserServiceImpl;
import com.dta.utils.ServiceProvider;

public class DisplayUrlFilter implements Filter {
	private Logger logger = LoggerFactory
			.getLogger("com.dta.servlet.DisplayUrlFilter");

	// private ISysUserService sysService =
	// (ISysUserService)ServiceProvider.getBean("sysUserServiceImpl");
	// private ISysUserService sysService = new SysUserServiceImpl();
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		logger.info("DisplayUrlFilter is destoryed.");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		ISysUserService sysService = (ISysUserService) ServiceProvider
				.getBean("sysUserServiceImpl");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String url = httpRequest.getRequestURI();
		if (!url.contains("media")) {
			logger.info("***************************************");
			logger.info("the request uri is {} ", url);
			logger.info("***************************************");
			// httpResponse.sendRedirect(httpRequest.getRequestURL().toString().split(";")[0]);
		}
		System.out.println("用request获取的sessionid为："
				+ httpRequest.getSession().getId());

		boolean loginFailure = request.getAttribute("shiroLoginFailure") != null;
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession(false);
		System.out.println("用subject获取的sessionid为：" + session.getId());
		boolean needSetAttribute = true;
		if (loginFailure
				|| session == null
				|| (session != null && session.getAttribute("school_id") != null))
			needSetAttribute = false;
		if (needSetAttribute) {
			String username = (String) subject.getPrincipal();
			if (StringUtils.hasText(username)) {
				try {
					Map<String, Object> map = sysService
							.getSchoolIdByUsername(username);
					if (map != null) {
						session.setAttribute("school_id",
								(Integer) map.get("school_id"));
						session.setAttribute("school_name",
								(String) map.get("school_name"));
					} else {
						logger.error("web端用户登录时，不能根据用户名信息获取用户所在的驾校信息");
						return;
					}
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
		}
		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		logger.info("DisplayUrlFilter is init.");
	}

}
