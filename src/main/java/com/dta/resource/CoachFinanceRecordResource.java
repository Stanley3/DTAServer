package com.dta.resource;

import javax.ws.rs.Path;

import com.dta.bean.CoachFinanceRecord;
import com.dta.service.ICoachFinanceRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.CoachFinanceRecordVo;

@Path("coachFinanceRecord")
public class CoachFinanceRecordResource extends BaseAllResource<CoachFinanceRecord, CoachFinanceRecordVo>{
	private ICoachFinanceRecordService service = (ICoachFinanceRecordService)ServiceProvider.getBean("coachFinanceRecordServiceImpl");
	public CoachFinanceRecordResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.COACHFINANCERECORD);	
	}
}