package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SponsorInfo;
import com.dta.dao.ISponsorInfoDao;
import com.dta.service.ISponsorInfoService;

@Service
public class SponsorInfoServiceImpl extends BaseAllServiceImpl<SponsorInfo, SponsorInfo> implements ISponsorInfoService{
	@Autowired
	private ISponsorInfoDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}