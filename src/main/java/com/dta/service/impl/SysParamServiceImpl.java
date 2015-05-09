package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SysParam;
import com.dta.dao.ISysParamDao;
import com.dta.service.ISysParamService;

@Service
public class SysParamServiceImpl extends BaseAllServiceImpl<SysParam, SysParam> implements ISysParamService{
	@Autowired
	private ISysParamDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}