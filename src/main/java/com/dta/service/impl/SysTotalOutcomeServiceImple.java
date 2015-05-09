package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SysTotalOutcome;
import com.dta.dao.ISysTotalOutcomeDao;
import com.dta.service.ISysTotalOutcomeService;

@Service
public class SysTotalOutcomeServiceImple extends BaseAllServiceImpl<SysTotalOutcome, SysTotalOutcome> implements ISysTotalOutcomeService{
	@Autowired
	private ISysTotalOutcomeDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}