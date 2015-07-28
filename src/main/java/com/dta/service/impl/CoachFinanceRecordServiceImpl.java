package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@Transactional
	public int addOrUpdateCoachIncomeAmount(Integer coach_id, double amount) {
		// TODO Auto-generated method stub
		int result = 0;
		Integer fincance_record_id = getFinanceIdByCoachId(coach_id);
		CoachFinanceRecord coachFinanceRecord;
		if(fincance_record_id == null || fincance_record_id == 0){
			coachFinanceRecord = new CoachFinanceRecord();
			coachFinanceRecord.setCoach_id(coach_id);
			coachFinanceRecord.setIncome_amount(amount);
			coachFinanceRecord.setPayed_amount(0.0);
			result = dao.addObject(coachFinanceRecord);
		}else{
			coachFinanceRecord = dao.getObjectById(fincance_record_id);
			if(coachFinanceRecord != null){
				coachFinanceRecord.setIncome_amount(amount + coachFinanceRecord.getIncome_amount());
				result = dao.updateObjectById(coachFinanceRecord);
			}
		}
		return result;
	}

	@Override
	public Integer getFinanceIdByCoachId(Integer coach_id) {
		// TODO Auto-generated method stub
		return dao.getFinanceIdByCoachId(coach_id);
	}
}