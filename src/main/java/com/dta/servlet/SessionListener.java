package com.dta.servlet;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

import com.dta.utils.SessionUtil;

public class SessionListener extends SessionListenerAdapter {

	@Override
	public void onStart(Session session) {
		System.out.println("后台获取到active session：" + session.getId());
		if (session.getAttribute("source") == null)
			session.setAttribute("source", "master");
		SessionUtil.map.put((String) session.getId(), session);
	}

	@Override
	public void onStop(Session session) {
		System.out.println("后台获取stoping session：" + session.getId());
		SessionUtil.map.remove((String) session.getId());
	}

	@Override
	public void onExpiration(Session session) {
		System.out.println("后台获取expired session：" + session.getId());
		SessionUtil.map.remove((String) session.getId());
	}
}