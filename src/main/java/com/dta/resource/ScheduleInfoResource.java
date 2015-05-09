package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;


import com.dta.bean.ScheduleInfo;
import com.dta.service.IScheduleInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;

@Path("scheduleInfo")
public class ScheduleInfoResource extends BaseAllResource<ScheduleInfo, ScheduleInfo>{
	//@Autowired
	public IScheduleInfoService service = (IScheduleInfoService)ServiceProvider.getBean("scheduleInfoServiceImpl");
	public ScheduleInfoResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.SCHEDULEINFO);
	}
}