package com.dta.service;

import com.dta.bean.StudentFinanceInfo;

public interface IStudentFinanceInfoService {

	int updateObject(StudentFinanceInfo po);

	StudentFinanceInfo getStudentFinanceInfoById(Integer student_id);

	int addObject(StudentFinanceInfo po);

	Double getStudentBalanceById(Integer student_id);

	/**
	 * 
	 * @param student_id
	 * @param amount
	 * @param sign
	 *            (1或-1)
	 * @return <p>
	 *         增加或减少学员财务信息的资金余额。
	 *         <p>
	 *         给学员返款时，sign=1；学员下订单时，sign=-1。
	 */
	int updateBalanceByStudentId(Integer student_id, Double amount, Integer sign);

	/**
	 * 
	 * @param student_id
	 * @param amount
	 * @return <p>
	 *         根据学员id增添或更新学员财务信息
	 *         <p>
	 *         在学员充值时调用该方法，将学员的充值金额统计到学员财务信息表。
	 */
	int addOrUpdateStudentFinanceInfo(Integer student_id, Double amount);

	/**
	 * 
	 * @param school_id
	 * @return <p>
	 *         获取某驾校名下所有学员的充值总额；若school_id为0表示获取所有学员的充值总额
	 */
	public Double getAllStudentDespoitAmoutBySchoolId(Integer school_id);

}
