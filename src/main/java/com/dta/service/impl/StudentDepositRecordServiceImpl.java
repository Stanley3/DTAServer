package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.StudentDepositRecord;
import com.dta.dao.IStudentDepositRecordDao;
import com.dta.service.IStudentDepositRecordService;
import com.dta.vo.StudentDepositRecordVo;

@Service
public class StudentDepositRecordServiceImpl extends BaseAllServiceImpl<StudentDepositRecord, StudentDepositRecordVo> implements IStudentDepositRecordService{
	@Autowired
	private IStudentDepositRecordDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}