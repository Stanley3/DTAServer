package com.dta.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.bean.StudentFinanceInfo;
import com.dta.dao.IStudentFinanceInfoDao;
import com.dta.service.IStudentFinanceInfoService;

@Service
public class StudentFinanceInfoServiceImpl implements
		IStudentFinanceInfoService {
	@Autowired
	private IStudentFinanceInfoDao dao;

	@Override
	public Double getStudentBalanceById(Integer student_id) {
		// TODO Auto-generated method stub
		return dao.getStudentBalanceById(student_id);
	}

	@Override
	@Transactional
	public int addObject(StudentFinanceInfo po) {
		// TODO Auto-generated method stub
		return dao.addObject(po);
	}

	@Override
	@Transactional
	public int updateObject(StudentFinanceInfo po) {
		// TODO Auto-generated method stub
		if (po.getStudent_finance_id() == null)
			throw new IllegalArgumentException("更新学员财务信息时，学员财务记录id为null");
		return dao.updateObject(po);
	}

	@Override
	public StudentFinanceInfo getStudentFinanceInfoById(Integer student_id) {
		// TODO Auto-generated method stub
		if (student_id == null)
			throw new IllegalArgumentException("根据学员id获取学员财务信息时，学员id为null");
		return null;
	}

	@Override
	@Transactional
	public int updateBalanceByStudentId(Integer student_id, Double amount,
			Integer sign) {
		StudentFinanceInfo studentFinaceInfo = dao
				.getStudentFinanceInfoById(student_id);
		if (studentFinaceInfo != null) {
			Double oldAmount = studentFinaceInfo.getStudent_account_balance();
			studentFinaceInfo.setStudent_account_balance(oldAmount + amount
					* sign);
			studentFinaceInfo.setStudent_finance_amount(null);
			return dao.updateObject(studentFinaceInfo);
		}
		return 0;
	}

	@Override
	@Transactional
	public int addOrUpdateStudentFinanceInfo(Integer student_id, Double amount) {
		StudentFinanceInfo studentFinanceInfo = dao
				.getStudentFinanceInfoById(student_id);
		Double oldAmount, oldBalance;
		if (studentFinanceInfo != null) {
			oldAmount = studentFinanceInfo.getStudent_finance_amount();
			oldBalance = studentFinanceInfo.getStudent_account_balance();
			studentFinanceInfo.setStudent_finance_amount(oldAmount + amount);
			studentFinanceInfo.setStudent_account_balance(oldBalance + amount);
			return dao.updateObject(studentFinanceInfo);
		} else {
			studentFinanceInfo = new StudentFinanceInfo();
			studentFinanceInfo.setStudent_finance_amount(amount);
			studentFinanceInfo.setStudent_account_balance(amount);
			return dao.addObject(studentFinanceInfo);
		}
	}

	@Override
	public Double getAllStudentDespoitAmoutBySchoolId(Integer school_id) {
		if (school_id == null)
			throw new IllegalArgumentException("根据驾校id获取名下的所有学员充值总额时，驾校id为null");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("school_id", school_id);
		return dao.getAllStudentDespoitAmoutBySchoolId(map);
	}

}
