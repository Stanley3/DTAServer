package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;



import com.dta.bean.SysTotalIncome;
import com.dta.service.ISysTotalIncomeService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.SysTotalIncomeVo;

@Path("sysTotalIncome")
public class SysTotalIncomeResource extends BaseAllResource<SysTotalIncome, SysTotalIncomeVo>{
	//@Autowired
	public ISysTotalIncomeService service = (ISysTotalIncomeService)ServiceProvider.getBean("sysTotalIncomeServiceImpl");
	public SysTotalIncomeResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.SYSUSER);
	}
}