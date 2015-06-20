package com.dta.service;

import java.util.List;

import com.dta.bean.AllEvaluationRecord;
import com.dta.bean.CoachFianceSummarizing;
import com.dta.bean.CoachPrecontractRecord;
import com.dta.bean.OrderInfo;
import com.dta.bean.OrderRecord;
import com.dta.bean.TrainingRecord;
import com.dta.vo.CoachPrecontractRecordVo;
import com.dta.vo.OrderInfoVo;
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
	 * @param CoachPrecontractRecordVo vo
	 * @return int
	 * <p> 获取上次查询和当前时间这个时间段内新增预约的总数 
	 */
	public int getLatestRrecontractRecordSize(CoachPrecontractRecordVo vo);
	
	/**
	 * 
	 * @param CoachPrecontractRecordVo vo
	 * @return int
	 * <p> 获取上次查询和当前时间这个时间段内取消预约的总数 
	 */
	public int getLastestCancelRecordSize(CoachPrecontractRecordVo vo);
	
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
	
	/**
	 * 
	 * @param Integer coach_id
	 * @return List<CoachFianceSummarizing>
	 * <p>App端获取教练财务信息
	 */
	public List<CoachFianceSummarizing> getCoachFinanceSumInfo(Integer coach_id);
}