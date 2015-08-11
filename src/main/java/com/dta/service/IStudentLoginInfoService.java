package com.dta.service;

import com.dta.bean.StudentLoginInfo;
import com.dta.bean.StudentLoginSuccessInfo;
import com.dta.vo.StudentLoginInfoVo;

public interface IStudentLoginInfoService {

	/**
	 * 
	 * @param login_name
	 * @return StudentLoginSuccessInfo
	 *         <p>
	 */
	public StudentLoginSuccessInfo getStudentLoginSuccessInfo(String login_name);
}