package com.dta.dao;

import java.util.List;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.CoachPrecontractRecordVo;
import com.dta.vo.OrderRecordVo;
import com.dta.vo.TrainingRecordVo;
import com.dta.bean.CoachPrecontractRecord;
import com.dta.bean.OrderRecord;
import com.dta.bean.TrainingRecord;
public interface IOrderRecordDao extends IBaseAllDao<OrderRecord, OrderRecordVo> {
	
	/**
	 * 
	 * @param CoachPrecontractRecordVo vo
	 * @return List<CoachPrecontractRecord>
	 * <p>获取教练的预约信息
	 */
	public List<CoachPrecontractRecord> getCoPreRecord(CoachPrecontractRecordVo vo);
	
	/**
	 * 
	 * @param TrainingRecordVo vo
	 * @return List<TrainingRecord>
	 * <p>获取学员的训练记录
	 */
	public List<TrainingRecord> getStuTranRecord(TrainingRecordVo vo);
	
	/**
	 * 
	 * @param TrainingRecordVo vo
	 * @return int
	 * <p>获取学员的训练记录总数
	 */
	public int getStuTranRecordSize(TrainingRecordVo vo);
}

