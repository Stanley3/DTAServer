package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;





import org.springframework.beans.factory.annotation.Autowired;

import com.dta.bean.SchoolInfo;
import com.dta.service.ISchoolInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.SchoolInfoVo;

@Path("schoolInfo")
public class SchoolInfoResource extends BaseAllResource<SchoolInfo, SchoolInfoVo>{
	//@Autowired
	public ISchoolInfoService service = (ISchoolInfoService)ServiceProvider.getBean("schoolInfoServiceImpl");
	/*@Autowired
	private ISchoolInfoService service;*/
	
	public SchoolInfoResource() throws Exception{
		if(service == null)
			throw new Exception("service is null");
		super.setService(service);
		super.setMianId(GlobalConstant.SYSUSER);
	}
	
	
}