package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;

import com.dta.bean.StudentSignupInfo;
import com.dta.service.IStudentSignupInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.StudentSignupInfoVo;

@Path("studentSignupInfo")
public class StudentSignupInfoResource extends
		BaseAllResource<StudentSignupInfo, StudentSignupInfoVo> {
	// @Autowired
	public IStudentSignupInfoService service = (IStudentSignupInfoService) ServiceProvider
			.getBean("studentSignupInfoServiceImpl");

	public StudentSignupInfoResource() {
		super.setService(service);
		super.setMianId(GlobalConstant.STUDENTSIGNUPINFO);
	}
}