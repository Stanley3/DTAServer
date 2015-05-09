package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SchoolInfo;
import com.dta.dao.ISchoolInfoDao;
import com.dta.service.ISchoolInfoService;

@Service
public class SchoolInfoServiceImpl extends BaseAllServiceImpl<SchoolInfo, SchoolInfo> implements ISchoolInfoService{
	@Autowired
	private ISchoolInfoDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}