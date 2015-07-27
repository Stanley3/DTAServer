package com.dta.service;

import com.dta.bean.CoachFinanceRecord;
import com.dta.vo.CoachFinanceRecordVo;

public interface ICoachFinanceRecordService extends IBaseAllService<CoachFinanceRecord, CoachFinanceRecordVo>{
	
	
	public Integer getFinanceIdByCoachId(Integer coach_id);

	public int addOrUpdateCoachIncomeAmount(Integer coach_id, double amount);
}