package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.StudentLoginInfo;
import com.dta.bean.StudentLoginSuccessInfo;
import com.dta.dao.IStudentLoginInfoDao;
import com.dta.service.IStudentLoginInfoService;
import com.dta.vo.StudentLoginInfoVo;

@Service
public class StudentLoginInfoServiceImpl extends
		BaseAllServiceImpl<StudentLoginInfo, StudentLoginInfoVo> implements
		IStudentLoginInfoService {
	@Autowired
	private IStudentLoginInfoDao dao;

	public void init() {
		super.setDao(dao);
	}

	@Override
	public StudentLoginSuccessInfo getStudentLoginSuccessInfo(String login_name) {
		// TODO Auto-generated method stub
		return dao.getStudentLoginSuccessInfo(login_name);
	}
}