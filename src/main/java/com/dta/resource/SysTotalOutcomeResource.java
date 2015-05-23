package com.dta.resource;

import javax.ws.rs.Path;

import com.dta.bean.SysTotalOutcome;
import com.dta.service.ISysTotalOutcomeService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.SysTotalOutcomeVo;

@Path("sysTotalOutcome")
public class SysTotalOutcomeResource extends BaseAllResource<SysTotalOutcome, SysTotalOutcomeVo>{
	private ISysTotalOutcomeService service = (ISysTotalOutcomeService)ServiceProvider.getBean("sysTotalOutcomeServiceImple");
	public SysTotalOutcomeResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.SYSTOTALOUTCOME);	
	}
}