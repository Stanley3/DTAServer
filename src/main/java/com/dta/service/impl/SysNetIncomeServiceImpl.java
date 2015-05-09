package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SysNetIncome;
import com.dta.dao.ISysNetIncomeDao;
import com.dta.service.ISysNetIncomeService;

@Service
public class SysNetIncomeServiceImpl extends BaseAllServiceImpl<SysNetIncome, SysNetIncome> implements ISysNetIncomeService{
	@Autowired
	private ISysNetIncomeDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}