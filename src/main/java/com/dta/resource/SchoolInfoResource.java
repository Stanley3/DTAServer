package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;


import com.dta.bean.SchoolInfo;
import com.dta.service.ISchoolInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;

@Path("schoolInfo")
public class SchoolInfoResource extends BaseAllResource<SchoolInfo, SchoolInfo>{
	//@Autowired
	public ISchoolInfoService service = (ISchoolInfoService)ServiceProvider.getBean("schoolInfoServiceImpl");
	public SchoolInfoResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.SYSUSER);
	}
}