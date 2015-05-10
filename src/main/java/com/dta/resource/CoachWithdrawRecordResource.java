package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;


import com.dta.bean.CoachWithdrawRecord;
import com.dta.service.ICoachWithdrawRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;

@Path("coachWithdrawRecord")
public class CoachWithdrawRecordResource extends BaseAllResource<CoachWithdrawRecord, CoachWithdrawRecord>{
	//@Autowired
	public ICoachWithdrawRecordService service = (ICoachWithdrawRecordService)ServiceProvider.getBean("coachWithdrawRecordServiceImpl");
	public CoachWithdrawRecordResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.COACHWITHDRAWRECORD);
	}
}