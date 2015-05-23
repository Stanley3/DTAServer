package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;



import com.dta.bean.StudentLoginInfo;
import com.dta.service.IStudentLoginInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.StudentLoginInfoVo;

@Path("studentLoginInfo")
public class StudentLoginInfoResource extends BaseAllResource<StudentLoginInfo, StudentLoginInfoVo>{
	//@Autowired
	public IStudentLoginInfoService service = (IStudentLoginInfoService)ServiceProvider.getBean("studentLoginInfoServiceImpl");
	public StudentLoginInfoResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.STUDENTLOGININFO);
	}
}