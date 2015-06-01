package com.dta.service;

import java.util.List;

import com.dta.bean.CoachPrecontractRecord;
import com.dta.bean.OrderRecord;
import com.dta.bean.TrainingRecord;
import com.dta.vo.CoachPrecontractRecordVo;
import com.dta.vo.OrderRecordVo;
import com.dta.vo.TrainingRecordVo;

public interface IOrderRecordService extends IBaseAllService<OrderRecord, OrderRecordVo>{
	/**
	 * 
	 * @param CoachPrecontractRecordVo vo
	 * @return List<CoachPrecontractRecord>
	 * <p> 获取教练被预约的信息记录
	 */
	public List<CoachPrecontractRecord> getCoPreRecord(CoachPrecontractRecordVo vo) throws Exception;
	
	/**
	 * 
	 * @param TrainingRecordVo vo
	 * @return List<TrainingRecord>
	 * <p>获取学员的训练记录
	 */
	public List<TrainingRecord> getStuTranRecord(TrainingRecordVo vo) throws Exception;
	
	/**
	 * 
	 * @param TrainingRecordVo vo
	 * @return int
	 * <p>获取学员的训练记录总数
	 * @throws Exception 
	 */
	public int getStuTranRecordSize(TrainingRecordVo vo) throws Exception;
}