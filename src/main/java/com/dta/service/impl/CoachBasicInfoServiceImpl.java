package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.CoachBasicInfo;
import com.dta.dao.ICoachBasicInfoDao;
import com.dta.service.ICoachBasicInfoService;

@Service
public class CoachBasicInfoServiceImpl extends BaseAllServiceImpl<CoachBasicInfo, CoachBasicInfo> implements ICoachBasicInfoService{
	@Autowired
	private ICoachBasicInfoDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}