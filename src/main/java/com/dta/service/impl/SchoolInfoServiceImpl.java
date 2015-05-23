package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SchoolInfo;
import com.dta.dao.ISchoolInfoDao;
import com.dta.service.ISchoolInfoService;
import com.dta.vo.SchoolInfoVo;

@Service
public class SchoolInfoServiceImpl extends BaseAllServiceImpl<SchoolInfo, SchoolInfoVo> implements ISchoolInfoService{
	@Autowired
	private ISchoolInfoDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}