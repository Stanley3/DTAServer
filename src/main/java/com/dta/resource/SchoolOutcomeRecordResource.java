package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;

import com.dta.bean.SchoolOutcomeRecord;
import com.dta.service.ISchoolOutcomeRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.SchoolOutcomeRecordVo;

@Path("schoolOutcomeRecord")
public class SchoolOutcomeRecordResource extends
		BaseAllResource<SchoolOutcomeRecord, SchoolOutcomeRecordVo> {
	// @Autowired
	public ISchoolOutcomeRecordService service = (ISchoolOutcomeRecordService) ServiceProvider
			.getBean("schoolOutcomeRecordServiceImpl");

	public SchoolOutcomeRecordResource() {
		super.setService(service);
		super.setMianId(GlobalConstant.SCHOOLOUTCOMERECORD);
	}
}