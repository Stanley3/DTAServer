package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.StudentSignupInfo;
import com.dta.dao.IStudentSignupInfoDao;
import com.dta.service.IStudentSignupInfoService;

@Service
public class StudentSignupInfoServiceImpl extends BaseAllServiceImpl<StudentSignupInfo, StudentSignupInfo> implements IStudentSignupInfoService{
	@Autowired
	private IStudentSignupInfoDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}