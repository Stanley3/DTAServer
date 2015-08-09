package com.dta.dao;

import java.util.Map;

public interface IWebMainPageDao {
	/**
	 * 
	 * @param username
	 * @return 
	 * <p>web main.jsp界面的学员总数、今日预约总数、教练总数等数据
	 */
	public Map<String, Integer> getStaticInfo(String username);
}
