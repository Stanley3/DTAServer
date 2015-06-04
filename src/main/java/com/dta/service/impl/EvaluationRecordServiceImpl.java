package com.dta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.AllEvaluationRecord;
import com.dta.bean.EvaluationRecord;
import com.dta.dao.IEvaluationRecordDao;
import com.dta.service.IEvaluationRecordService;
import com.dta.vo.AllEvaluationRecordVo;
import com.dta.vo.EvaluationRecordVo;

@Service
public class EvaluationRecordServiceImpl extends BaseAllServiceImpl<EvaluationRecord, EvaluationRecordVo> implements IEvaluationRecordService{
	@Autowired
	private IEvaluationRecordDao dao;
	
	public void init(){
		super.setDao(dao);
	}

	@Override
	public List<AllEvaluationRecord> getAllEvaRec(AllEvaluationRecordVo vo) {
		// TODO Auto-generated method stub
		return dao.getAllEvaRec(vo);
	}

	@Override
	public int getAllEvaRecSize(AllEvaluationRecordVo vo) {
		// TODO Auto-generated method stub
		System.out.println(vo.getEvaluation());
		return dao.getAllEvaRecSize(vo);
	}

	@Override
	public List<AllEvaluationRecord> globalSearch(AllEvaluationRecordVo vo) {
		// TODO Auto-generated method stub
		return dao.globalSearch(vo);
	}

	@Override
	public int globalSearchSize(AllEvaluationRecordVo vo) {
		// TODO Auto-generated method stub
		return dao.globalSearchSize(vo);
	}
}