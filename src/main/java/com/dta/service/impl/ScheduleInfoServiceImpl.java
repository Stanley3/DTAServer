package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.ScheduleInfo;
import com.dta.dao.IScheduleInfoDao;
import com.dta.service.IScheduleInfoService;

@Service
public class ScheduleInfoServiceImpl extends BaseAllServiceImpl<ScheduleInfo, ScheduleInfo> implements IScheduleInfoService{
	@Autowired
	private IScheduleInfoDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}