package com.dta.page;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dta.service.IOrderRecordService;
import com.dta.service.IStudentBasicInfoService;
import com.dta.service.IStudentDepositRecordService;
import com.dta.service.IStudentFinanceInfoService;
import com.dta.utils.ServiceProvider;

public class MoneyPage {
	private IStudentFinanceInfoService studentFinanceInfoService;
	private IOrderRecordService orderRecordService;
	private IStudentBasicInfoService studentBasicInfoService;
	private IStudentDepositRecordService studentDepositRecordService;
	private Integer school_id;

	public MoneyPage(Integer school_id) {
		this.school_id = school_id;
		studentFinanceInfoService = (IStudentFinanceInfoService) ServiceProvider
				.getBean("studentFinanceInfoServiceImpl");
		orderRecordService = (IOrderRecordService) ServiceProvider
				.getBean("orderRecordServiceImpl");
		studentBasicInfoService = (IStudentBasicInfoService) ServiceProvider
				.getBean("studentBasicInfoServiceImpl");
		studentDepositRecordService = (IStudentDepositRecordService) ServiceProvider
				.getBean("studentDepositRecordServiceImpl");
	}

	public Map<String, Double> getMoney() {
		Double allDepositAmount = studentFinanceInfoService
				.getAllStudentDespoitAmoutBySchoolId(school_id);
		if (allDepositAmount == null)
			allDepositAmount = 0.0;
		List<Map<String, Object>> statusList = orderRecordService
				.getAmountGroupByOrderStatus(school_id);

		Double allConsumeAmount = 0.0;
		Double allFreezeAmount = 0.0;

		if (statusList != null) {
			for (Map<String, Object> map : statusList) {
				if (((String) map.get("order_status")).equals("0"))
					allFreezeAmount += ((BigDecimal) map.get("amount"))
							.doubleValue();
				else if (((String) map.get("order_status")).equals("2"))
					allFreezeAmount += ((BigDecimal) map.get("amount"))
							.doubleValue();
				else if (((String) map.get("order_status")).equals("3"))
					allConsumeAmount += ((BigDecimal) map.get("amount"))
							.doubleValue();
			}
		}

		Double allBalanceAmount = allDepositAmount - allConsumeAmount
				- allFreezeAmount;
		Map<String, Double> moneyMap = new HashMap<String, Double>();
		moneyMap.put("allDepositAmount", allDepositAmount);
		moneyMap.put("allConsumeAmount", allConsumeAmount);
		moneyMap.put("allFreezeAmount", allFreezeAmount);
		moneyMap.put("allBalanceAmount", allBalanceAmount);
		return moneyMap;
	}

	/**
	 * 
	 * @return 各种学员的总数
	 */
	public Map<String, Integer> getStudentNumbers() {
		Integer allStudentNumbers, // 所有学员总数
		allConsumedStudentNumbers, // 已消费学员总数
		allDepositedStudentNumbers, // 已充值学员总数
		allChartered2Numbers, // 包科二学员总数
		allChartered3Numbers, // 包科三学员总数
		allFree2Numbers, // 自由科二学员总数
		allFree3Numbers; // 自由科三学员总数
		Map<String, Integer> paramMap = new HashMap<String, Integer>(5);
		paramMap.put("school_id", school_id);
		allStudentNumbers = studentBasicInfoService.getStudentNumbers(paramMap);
		if (allStudentNumbers == null)
			allStudentNumbers = 0;
		paramMap.put("student_level", 2);
		paramMap.put("subject", 2);
		allChartered2Numbers = studentBasicInfoService
				.getStudentNumbers(paramMap);
		if (allChartered2Numbers == null)
			allChartered2Numbers = 0;
		paramMap.put("student_level", 0);
		allFree2Numbers = studentBasicInfoService.getStudentNumbers(paramMap);
		if (allFree2Numbers == null)
			allFree2Numbers = 0;
		paramMap.put("student_level", 3);
		paramMap.put("subject", 3);
		allChartered3Numbers = studentBasicInfoService
				.getStudentNumbers(paramMap);
		if (allChartered3Numbers == null)
			allChartered3Numbers = 0;
		paramMap.put("student_level", 0);
		allFree3Numbers = studentBasicInfoService.getStudentNumbers(paramMap);
		if (allFree3Numbers == null)
			allFree3Numbers = 0;
		allDepositedStudentNumbers = studentDepositRecordService
				.getDepositedStudentNumbers(school_id);
		if (allDepositedStudentNumbers == null)
			allDepositedStudentNumbers = 0;
		Map<String, Integer> numbersMap = new HashMap<String, Integer>();
		numbersMap.put("allStudentNumbers", allStudentNumbers);
		numbersMap.put("allChartered2Numbers", allChartered2Numbers);
		numbersMap.put("allChartered3Numbers", allChartered3Numbers);
		numbersMap.put("allFree2Numbers", allFree2Numbers);
		numbersMap.put("allFree3Numbers", allFree3Numbers);
		numbersMap
				.put("allDepositedStudentNumbers", allDepositedStudentNumbers);
		return numbersMap;
	}
}
