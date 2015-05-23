package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SysTotalIncome;
import com.dta.dao.ISysTotalIncomeDao;
import com.dta.service.ISysTotalIncomeService;
import com.dta.vo.SysTotalIncomeVo;

@Service
public class SysTotalIncomeServiceImpl extends BaseAllServiceImpl<SysTotalIncome, SysTotalIncomeVo> implements ISysTotalIncomeService{
	@Autowired
	private ISysTotalIncomeDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}