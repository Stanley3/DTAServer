package com.dta.dao;

import java.util.Map;

import com.dta.bean.StudentFinanceInfo;

public interface IStudentFinanceInfoDao {
	/**
	 * 
	 * @param Integer student_id
	 * @return double
	 * <p>根据学员id获取学员的可用余额
	 */
	public Double getStudentBalanceById(Integer student_id);
	
	public int addObject(StudentFinanceInfo po);
	
	public int updateObject(StudentFinanceInfo po);
	
	/**
	 * 
	 * @param student_id
	 * @return
	 * <p>根据学员id获取学员的财务信息
	 */
	public StudentFinanceInfo getStudentFinanceInfoById(Integer student_id);
	
	/**
	 * 
	 * @param school_id
	 * @return
	 * <p>获取某驾校名下所有学员的充值总额；若school_id为0表示获取所有学员的充值总额
	 */
	public Double getAllStudentDespoitAmoutBySchoolId(Map<String, Object>map);
}
