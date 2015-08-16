package com.dta.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SchoolDepositRecord;
import com.dta.dao.ISchoolDepositRecordDao;
import com.dta.service.ISchoolDepositRecordService;
import com.dta.vo.SchoolDepositRecordVo;

@Service
public class SchoolDepositRecordServiceImpl extends BaseAllServiceImpl<SchoolDepositRecord, SchoolDepositRecordVo>
		implements ISchoolDepositRecordService {
	@Autowired
	private ISchoolDepositRecordDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}
