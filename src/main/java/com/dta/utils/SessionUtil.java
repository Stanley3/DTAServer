package com.dta.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class SessionUtil {
	public static Map<String, Session> map = new HashMap<String, Session>();

	public static Map<String, Integer> getNumbers(String sessionId) {
		int coachNumbers = 0, studentNumbers = 0, masterNumbers = 0;
		Session session = (Session) map.get(sessionId);
		Integer schoolId = (Integer) session.getAttribute("school_id");
		Set<String> set = map.keySet();
		for (String key : set) {
			session = (Session) map.get(key);
			if (schoolId == 0 || schoolId == session.getAttribute("school_id"))
				if ("master".equalsIgnoreCase((String) session
						.getAttribute("source")))
					++masterNumbers;
				else if ("coach".equalsIgnoreCase((String) session
						.getAttribute("source")))
					++coachNumbers;
				else if ("student".equalsIgnoreCase((String) session
						.getAttribute("source")))
					++studentNumbers;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("studentNumbers", studentNumbers);
		map.put("coachNumbers", coachNumbers);
		map.put("masterNumbers", masterNumbers);
		return map;
	}

	public static Integer getSchoolIdByRequest(HttpServletRequest request) {
		// return (Integer)
		// map.get(request.getSession(false).getId()).getAttribute("school_id");
		/*
		 * if(session != null){ result =
		 * (Integer)map.get(session.getId()).getAttribute("school_id"); } return
		 * result;
		 */
		HttpSession session = request.getSession(false);
		Integer result = 0;
		String id;
		if (session != null) {
			result = (Integer) session.getAttribute("school_id");
			id = session.getId();
			System.out.println(id);
		}
		return result;
	}
	
	public static Integer getUserIdByRequest(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		Integer result = 0;
		String id;
		if (session != null) {
			result = (Integer) session.getAttribute("user_id");
			id = session.getId();
			System.out.println(id);
		}
		return result;
	}
}
