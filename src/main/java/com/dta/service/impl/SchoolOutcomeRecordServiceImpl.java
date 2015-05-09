package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SchoolOutcomeRecord;
import com.dta.dao.ISchoolOutcomeRecordDao;
import com.dta.service.ISchoolOutcomeRecordService;

@Service
public class SchoolOutcomeRecordServiceImpl extends BaseAllServiceImpl<SchoolOutcomeRecord, SchoolOutcomeRecord> implements ISchoolOutcomeRecordService{
	@Autowired
	private ISchoolOutcomeRecordDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}