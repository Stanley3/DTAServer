package com.dta.dao;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.StudentLoginInfoVo;
import com.dta.bean.StudentLoginInfo;
import com.dta.bean.StudentLoginSuccessInfo;

public interface IStudentLoginInfoDao extends
		IBaseAllDao<StudentLoginInfo, StudentLoginInfoVo> {

	/**
	 * 
	 * @param login_name
	 * @return StudentLoginSuccessInfo
	 *         <p>
	 */
	public StudentLoginSuccessInfo getStudentLoginSuccessInfo(String login_name);
}
