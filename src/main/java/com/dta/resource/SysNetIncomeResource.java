package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;

import com.dta.bean.SysNetIncome;
import com.dta.service.ISysNetIncomeService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.SysNetIncomeVo;

@Path("sysNetIncome")
public class SysNetIncomeResource extends
		BaseAllResource<SysNetIncome, SysNetIncomeVo> {
	// @Autowired
	public ISysNetIncomeService service = (ISysNetIncomeService) ServiceProvider
			.getBean("sysNetIncomeServiceImpl");

	public SysNetIncomeResource() {
		super.setService(service);
		super.setMianId(GlobalConstant.SYSNETINCOME);
	}
}