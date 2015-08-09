package com.dta.page;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dta.service.IOrderRecordService;
import com.dta.service.IStudentFinanceInfoService;
import com.dta.utils.ServiceProvider;

public class MoneyPage {
	private IStudentFinanceInfoService studentFinanceInfoService;
	private IOrderRecordService orderRecordService;
	private Integer school_id;
	public MoneyPage(Integer school_id){
		this.school_id = school_id;
		studentFinanceInfoService = (IStudentFinanceInfoService)ServiceProvider.getBean("studentFinanceInfoServiceImpl");
		orderRecordService = (IOrderRecordService)ServiceProvider.getBean("orderRecordServiceImpl");
	}
	public Map<String, Double> getMoney(){
		Double allDepositAmount = studentFinanceInfoService.getAllStudentDespoitAmoutBySchoolId(school_id);
		if(allDepositAmount == null)
			allDepositAmount = 0.0;
		List<Map<String, Object>> statusList = orderRecordService.getAmountGroupByOrderStatus(school_id);
		
		Double allConsumeAmount = 0.0;
		Double allFreezeAmount = 0.0;
		
		if(statusList != null ){
			for(Map<String, Object> map : statusList){
				if(((String)map.get("order_status")).equals("0"))
					allFreezeAmount += ((BigDecimal)map.get("amount")).doubleValue();
				else if(((String)map.get("order_status")).equals("2"))
					allFreezeAmount += ((BigDecimal)map.get("amount")).doubleValue();
				else if(((String)map.get("order_status")).equals("3"))
					allConsumeAmount += ((BigDecimal)map.get("amount")).doubleValue();
			}
		}
		
		Double allBalanceAmount = allDepositAmount - allConsumeAmount - allFreezeAmount;
		Map<String, Double> moneyMap = new HashMap<String, Double>();
		moneyMap.put("allDepositAmount", allDepositAmount);
		moneyMap.put("allConsumeAmount", allConsumeAmount);
		moneyMap.put("allFreezeAmount", allFreezeAmount);
		moneyMap.put("allBalanceAmount", allBalanceAmount);
		return moneyMap;
	}
}
