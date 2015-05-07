package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;


import com.dta.bean.SysUser;
import com.dta.service.ISysUserService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;

@Path("sysUser")
public class SysUserResource extends BaseAllResource<SysUser, SysUser>{
	//@Autowired
	public ISysUserService service = (ISysUserService)ServiceProvider.getBean("sysUserServiceImpl");
	public SysUserResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.SYSUSER);
	}
}