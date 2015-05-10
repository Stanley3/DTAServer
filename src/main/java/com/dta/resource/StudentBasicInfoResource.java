package com.dta.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;


import javax.ws.rs.core.Response;

import org.springframework.transaction.annotation.Transactional;

import com.dta.bean.CoachBasicInfo;
import com.dta.bean.ResultBean;
import com.dta.bean.StudentBasicInfo;
import com.dta.bean.StudentLoginInfo;
import com.dta.service.IStudentBasicInfoService;
import com.dta.service.IStudentLoginInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;

@Path("studentBasicInfo")
public class StudentBasicInfoResource extends BaseAllResource<StudentBasicInfo, StudentBasicInfo>{
	//@Autowired
	public IStudentBasicInfoService service = (IStudentBasicInfoService)ServiceProvider.getBean("studentBasicInfoServiceImpl");
	public IStudentLoginInfoService loginInfoService = (IStudentLoginInfoService)ServiceProvider.getBean("studentLoginInfoServiceImpl");
	public StudentBasicInfoResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.STUDENTBASICINFO);
	}
	
}