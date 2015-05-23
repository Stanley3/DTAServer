package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;



import com.dta.bean.CoachWithdrawRecord;
import com.dta.service.ICoachWithdrawRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.CoachWithdrawRecordVo;

@Path("coachWithdrawRecord")
public class CoachWithdrawRecordResource extends BaseAllResource<CoachWithdrawRecord, CoachWithdrawRecordVo>{
	//@Autowired
	public ICoachWithdrawRecordService service = (ICoachWithdrawRecordService)ServiceProvider.getBean("coachWithdrawRecordServiceImpl");
	public CoachWithdrawRecordResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.COACHWITHDRAWRECORD);
	}
}