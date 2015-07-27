package com.dta.dao;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.CoachFinanceRecordVo;
import com.dta.bean.CoachFinanceRecord;
public interface ICoachFinanceRecordDao extends IBaseAllDao<CoachFinanceRecord, CoachFinanceRecordVo> {
	
	/**
	 * 
	 * @param Integer order_id
	 * @param Double amount
	 * @return 
	 * <p>将这笔订单的金额统计到教练财务记录表的总额字段
	 */
	public int updateAmountByOrderId(Integer order_id, Double amount);
	
	public Integer getFinanceIdByCoachId(Integer coach_id);
}
