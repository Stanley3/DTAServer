package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.EvaluationRecord;
import com.dta.dao.IEvaluationRecordDao;
import com.dta.service.IEvaluationRecordService;
import com.dta.vo.EvaluationRecordVo;

@Service
public class EvaluationRecordServiceImpl extends BaseAllServiceImpl<EvaluationRecord, EvaluationRecordVo> implements IEvaluationRecordService{
	@Autowired
	private IEvaluationRecordDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}