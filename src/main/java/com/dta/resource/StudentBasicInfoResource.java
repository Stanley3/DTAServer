package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;


import com.dta.bean.StudentBasicInfo;
import com.dta.service.IStudentBasicInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;

@Path("studentBasicInfo")
public class StudentBasicInfoResource extends BaseAllResource<StudentBasicInfo, StudentBasicInfo>{
	//@Autowired
	public IStudentBasicInfoService service = (IStudentBasicInfoService)ServiceProvider.getBean("StudentBasicInfoImpl");
	public StudentBasicInfoResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.STUDENTBASICINFO);
	}
}