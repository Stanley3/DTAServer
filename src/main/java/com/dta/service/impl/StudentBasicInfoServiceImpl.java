package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.StudentBasicInfo;
import com.dta.dao.IStudentBasicInfoDao;
import com.dta.service.IStudentBasicInfoService;

@Service
public class StudentBasicInfoServiceImpl extends BaseAllServiceImpl<StudentBasicInfo, StudentBasicInfo> implements IStudentBasicInfoService{
	@Autowired
	private IStudentBasicInfoDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}