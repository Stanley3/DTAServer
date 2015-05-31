package com.dta.dao;

import java.util.List;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.CoachPrecontractRecordVo;
import com.dta.vo.OrderRecordVo;
import com.dta.bean.CoachPrecontractRecord;
import com.dta.bean.OrderRecord;
public interface IOrderRecordDao extends IBaseAllDao<OrderRecord, OrderRecordVo> {
	
	/**
	 * 
	 * @param CoachPrecontractRecordVo vo
	 * @return List<CoachPrecontractRecord>
	 * <p>获取教练的预约信息
	 */
	public List<CoachPrecontractRecord> getCoPreRecord(CoachPrecontractRecordVo vo);
}
