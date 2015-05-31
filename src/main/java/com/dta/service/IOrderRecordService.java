package com.dta.service;

import java.util.List;

import com.dta.bean.CoachPrecontractRecord;
import com.dta.bean.OrderRecord;
import com.dta.vo.CoachPrecontractRecordVo;
import com.dta.vo.OrderRecordVo;

public interface IOrderRecordService extends IBaseAllService<OrderRecord, OrderRecordVo>{
	/**
	 * 
	 * @param CoachPrecontractRecordVo vo
	 * @return List<CoachPrecontractRecord>
	 * <p> 获取教练被预约的信息记录
	 */
	public List<CoachPrecontractRecord> getCoPreRecord(CoachPrecontractRecordVo vo) throws Exception;
}