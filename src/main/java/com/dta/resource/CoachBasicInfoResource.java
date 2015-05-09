package com.dta.resource;

import javax.ws.rs.Path;

import com.dta.bean.CoachBasicInfo;
import com.dta.bean.SysTotalOutcome;
import com.dta.service.ICoachBasicInfoService;
import com.dta.service.ISysTotalOutcomeService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;

@Path("coachBasicInfo")
public class CoachBasicInfoResource extends BaseAllResource<CoachBasicInfo, CoachBasicInfo>{
	private ICoachBasicInfoService service = (ICoachBasicInfoService)ServiceProvider.getBean("sysTotalOutcomeServiceImple");
	public CoachBasicInfoResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.COACHBASICINFO);	
	}
}