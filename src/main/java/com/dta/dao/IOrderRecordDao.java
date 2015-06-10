package com.dta.dao;

import java.util.List;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.CoachPrecontractRecordVo;
import com.dta.vo.OrderInfoVo;
import com.dta.vo.OrderRecordVo;
import com.dta.vo.TrainingRecordVo;
import com.dta.bean.AllEvaluationRecord;
import com.dta.bean.CoachPrecontractRecord;
import com.dta.bean.OrderInfo;
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
	
	/**
	 * <p>获取所有订单的相关信息，web全部订单界面使用
	 * @param vo
	 * @return
	 */
	public List<OrderInfo> getOrderInfo(OrderInfoVo vo);
	public int getOrderInfoSize(OrderInfoVo vo);
	
	/**
	 * <p>查看订单界面根据订单id获取评价信息
	 * @param Integer order_id
	 * @return List<AllEvaluationRecord>
	 */
	public AllEvaluationRecord getEvaluationInfoByOrderId(Integer order_id);
}

