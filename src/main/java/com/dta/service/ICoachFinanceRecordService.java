package com.dta.service;

import com.dta.bean.CoachFinanceRecord;
import com.dta.vo.CoachFinanceRecordVo;

public interface ICoachFinanceRecordService extends
		IBaseAllService<CoachFinanceRecord, CoachFinanceRecordVo> {

	public Integer getFinanceIdByCoachId(Integer coach_id);

	/**
	 * 
	 * @param coach_id
	 *            教练id
	 * @param amount
	 *            订单金额
	 * @return <p>
	 *         将某个教练订单的金额统计到该教练在教练财务记录表中对记录的收入总额中，若不存在该项，则新增一条
	 */
	public int addOrUpdateCoachIncomeAmount(Integer coach_id, double amount);
}