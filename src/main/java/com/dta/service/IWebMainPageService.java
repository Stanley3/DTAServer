package com.dta.service;

import java.util.Map;

public interface IWebMainPageService {
	/**
	 * 
	 * @param username
	 * @return 
	 * <p>web main.jsp界面的学员总数、今日预约总数、教练总数、现余资金等数据
	 */
	public Map<String, Integer> getStaticInfo(String username);
}
