package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SchoolIncome;
import com.dta.dao.ISchoolIncomeDao;
import com.dta.service.ISchoolIncomeService;

@Service
public class SchoolIncomeServiceImpl extends BaseAllServiceImpl<SchoolIncome, SchoolIncome> implements ISchoolIncomeService{
	@Autowired
	private ISchoolIncomeDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}