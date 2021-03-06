package com.dta.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.CoachIncomeRecordVo;
import com.dta.vo.CoachOrderByIdVo;
import com.dta.vo.CoachPrecontractRecordVo;
import com.dta.vo.CoachTeachRecordVo;
import com.dta.vo.MyOrderRecordVo;
import com.dta.vo.OrderInfoVo;
import com.dta.vo.OrderRecordVo;
import com.dta.vo.TrainingRecordVo;
import com.dta.bean.AllEvaluationRecord;
import com.dta.bean.CoachFianceSummarizing;
import com.dta.bean.CoachIncomeRecord;
import com.dta.bean.CoachOrderById;
import com.dta.bean.CoachPrecontractRecord;
import com.dta.bean.CoachTeachRecord;
import com.dta.bean.MyOrderRecord;
import com.dta.bean.OrderInfo;
import com.dta.bean.OrderRecord;
import com.dta.bean.TrainingRecord;

public interface IOrderRecordDao extends
		IBaseAllDao<OrderRecord, OrderRecordVo> {

	/**
	 * 
	 * @param CoachPrecontractRecordVo
	 *            vo
	 * @return List<CoachPrecontractRecord>
	 *         <p>
	 *         获取教练的预约信息
	 */
	public List<CoachPrecontractRecord> getCoPreRecord(
			CoachPrecontractRecordVo vo);

	/**
	 * 
	 * @param CoachPrecontractRecordVo
	 *            vo
	 * @return int
	 *         <p>
	 *         获取上次查询和当前时间这个时间段内新增预约的总数
	 */
	public int getLatestRrecontractRecordSize(CoachPrecontractRecordVo vo);

	/**
	 * 
	 * @param CoachPrecontractRecordVo
	 *            vo
	 * @return int
	 *         <p>
	 *         获取上次查询和当前时间这个时间段内取消预约的总数
	 */
	public int getLastestCancelRecordSize(CoachPrecontractRecordVo vo);

	/**
	 * 
	 * @param TrainingRecordVo
	 *            vo
	 * @return List<TrainingRecord>
	 *         <p>
	 *         获取学员的训练记录
	 */
	public List<TrainingRecord> getStuTranRecord(TrainingRecordVo vo);

	/**
	 * 
	 * @param TrainingRecordVo
	 *            vo
	 * @return int
	 *         <p>
	 *         获取学员的训练记录总数
	 */
	public int getStuTranRecordSize(TrainingRecordVo vo);

	/**
	 * <p>
	 * 获取所有订单的相关信息，web全部订单界面使用
	 * 
	 * @param vo
	 * @return
	 */
	public List<OrderInfo> getOrderInfo(OrderInfoVo vo);

	public int getOrderInfoSize(OrderInfoVo vo);

	/**
	 * <p>
	 * 查看订单界面根据订单id获取评价信息
	 * 
	 * @param Integer
	 *            order_id
	 * @return List<AllEvaluationRecord>
	 */
	public AllEvaluationRecord getEvaluationInfoByOrderId(Integer order_id);

	/**
	 * 
	 * @param Integer
	 *            coach_id
	 * @return List<CoachFianceSummarizing>
	 *         <p>
	 *         App端获取教练财务信息
	 */
	public List<CoachFianceSummarizing> getCoachFinanceSumInfo(Integer coach_id);

	/**
	 * 
	 * @param CoachTeachRecordVo
	 *            vo
	 * @return List<CoachTeachRecord>
	 *         <p>
	 *         App端获取教练的授课记录
	 */
	public List<CoachTeachRecord> getCoachTeachRecord(CoachTeachRecordVo vo);

	/**
	 * 
	 * @param CoachTeachRecordVo
	 *            vo
	 * @return List<CoachTeachRecord>
	 *         <p>
	 *         App端获取教练授课记录的总数
	 */
	public int getCoachTeachRecordSize(CoachTeachRecordVo vo);

	/**
	 * 
	 * @param Map
	 *            <String, Object> map
	 * @return List<String>
	 *         <p>
	 *         获取某个学员某天的预约信息，用于学员预约教练时间段界面
	 */
	public List<String> getStudentSomedayPrecontractInfo(Map<String, Object> map);

	/**
	 * 
	 * @param Integer
	 *            student_id
	 * @return Double
	 *         <p>
	 *         获取学员的消费总额
	 */
	public Double getStudentConsumeAmount(Integer student_id);

	/**
	 * 
	 * @param MyOrderRecordVo
	 *            vo
	 * @return List<MyOrderRecord>
	 *         <p>
	 *         App学员端 获取学员已经预约和练习记录
	 */
	public List<MyOrderRecord> getStudentOrderRecord(MyOrderRecordVo vo);

	/**
	 * 
	 * @param MyOrderRecordVo
	 *            vo
	 * @return int
	 *         <p>
	 *         App学员端 获取学员已经预约或练习记录的总数
	 */
	public int getStudentOrderRecordSize(MyOrderRecordVo vo);

	/**
	 * 
	 * @param CoachIncomeRecordVo
	 *            vo
	 * @return List<CoachIncomeRecord>
	 *         <p>
	 *         App教练端获取教练的收入记录
	 */
	public List<CoachIncomeRecord> getCoachIncomeRecord(CoachIncomeRecordVo vo);

	/**
	 * 
	 * @param CoachIncomeRecordVo
	 *            vo
	 * @return List<CoachIncomeRecord>
	 *         <p>
	 *         App教练端获取教练收入记录的总数
	 */
	public int getCoachIncomeRecordSize(CoachIncomeRecordVo vo);

	/**
	 * 
	 * @param CoachOrderByIdVo
	 *            vo
	 * @return List<CoachOrderById>
	 *         <p>
	 *         web界面通过教练的id获取教练的订单记录
	 */
	public List<CoachOrderById> getCoachOrderById(CoachOrderByIdVo vo);

	/**
	 * 
	 * @param CoachOrderByIdVo
	 *            vo
	 * @return int
	 *         <p>
	 *         web界面通过教练的id获取教练订单记录的总数
	 */
	public int getCoachOrderByIdSize(CoachOrderByIdVo vo);

	/**
	 * 
	 * @param school_id
	 * @return <p>
	 *         扫描订单表，获取某个驾校名下所有学员的消费总额（order_status = 3), 冻结总额(order_status =
	 *         0,2); 若驾校id为0，则获取所有学员的消费总额和冻结总额
	 */
	public List<Map<String, Object>> getAmountGroupByOrderStatus(
			Map<String, Object> map);
	
	/**
	 * 
	 * @param school_id
	 * @return
	 * <p>获取已消费学员的总数
	 */
	public int getConsumedStudentNumbers(@Param(value="school_id")Integer school_id);
	
	/**
	 * 
	 * @param map
	 * @return
	 * 夜中批量处理数据时，根据条件获取订单表的内容
	 */
	public List<OrderRecord> scanOrderRecord(Map<String, Object>map);
}
