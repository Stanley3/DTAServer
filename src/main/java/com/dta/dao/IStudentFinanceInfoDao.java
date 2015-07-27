package com.dta.dao;

public interface IStudentFinanceInfoDao {
	/**
	 * 
	 * @param Integer student_id
	 * @return double
	 * <p>根据学员id获取学员的可用余额
	 */
	public Double getStudentBalanceById(Integer student_id);
	
}
