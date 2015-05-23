package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.CoachFinanceRecord;
import com.dta.dao.ICoachFinanceRecordDao;
import com.dta.service.ICoachFinanceRecordService;
import com.dta.vo.CoachFinanceRecordVo;

@Service
public class CoachFinanceRecordServiceImpl extends BaseAllServiceImpl<CoachFinanceRecord, CoachFinanceRecordVo> implements ICoachFinanceRecordService{
	@Autowired
	private ICoachFinanceRecordDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}