package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.CoachWithdrawRecord;
import com.dta.dao.ICoachWithdrawRecordDao;
import com.dta.service.ICoachWithdrawRecordService;
import com.dta.vo.CoachWithdrawRecordVo;

@Service
public class CoachWithdrawRecordServiceImpl extends BaseAllServiceImpl<CoachWithdrawRecord, CoachWithdrawRecordVo> implements ICoachWithdrawRecordService{
	@Autowired
	private ICoachWithdrawRecordDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}