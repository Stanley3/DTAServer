package com.dta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.AllEvaluationRecord;
import com.dta.bean.CoachEvaluationInfo;
import com.dta.bean.EvaluationAndOrderInfo;
import com.dta.bean.EvaluationRecord;
import com.dta.bean.MapBean;
import com.dta.dao.IEvaluationRecordDao;
import com.dta.service.IEvaluationRecordService;
import com.dta.vo.AllEvaluationRecordVo;
import com.dta.vo.CoachEvaluationInfoVo;
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

	@Override
	public EvaluationAndOrderInfo getEvaAndOrdById(
			Integer evaluation_record_id) throws Exception {
		// TODO Auto-generated method stub
		if(evaluation_record_id == null)
			throw new Exception("未知的评价id(evaluation_record_id)");
		return dao.getEvaAndOrdById(evaluation_record_id);
	}

	@Override
	public List<CoachEvaluationInfo> getCoachEvaluationInfo(
			CoachEvaluationInfoVo vo) {
		if(vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练的评价信息时coach_id为null");
		return dao.getCoachEvaluationInfo(vo);
	}

	@Override
	public int getCoachEvaluationInfoSize(CoachEvaluationInfoVo vo) {
		if(vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练的评价信息时coach_id为null");
		return dao.getCoachEvaluationInfoSize(vo);
	}

	@Override
	public List<MapBean> getEvaluationSize(Integer coach_id) {
		if(coach_id == null)
			throw new IllegalArgumentException("获取教练的评价个数时coach_id为null");
		return dao.getEvaluationSize(coach_id);
	}
}