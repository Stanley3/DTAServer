package com.dta.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.session.Session;

public class SessionUtil {
	public static Map<String, Session> map = new HashMap<String, Session>();
	
	public static Map<String, Integer> getNumbers(String sessionId){
		int coachNumbers = 0, studentNumbers = 0, masterNumbers = 0;
		Session session = (Session)map.get(sessionId);
		Integer schoolId = (Integer)session.getAttribute("school_id");
		Set<String> set = map.keySet();
		for(String key : set){
			session = (Session)map.get(key);
			if(schoolId == session.getAttribute("school_id"));
				if("master".equalsIgnoreCase((String)session.getAttribute("source")))
					++masterNumbers;
				else if("coach".equalsIgnoreCase((String)session.getAttribute("source")))
						++coachNumbers;
				else if("student".equalsIgnoreCase((String)session.getAttribute("source")))
						++studentNumbers;
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("studentNumbers", studentNumbers);
		map.put("coachNumbers", coachNumbers);
		map.put("masterNumbers", masterNumbers);
		return map;
	}
}
