package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;


import com.dta.bean.SysRole;
import com.dta.service.ISysRoleService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;

@Path("sysRole")
public class SysRoleResource extends BaseAllResource<SysRole, SysRole>{
	//@Autowired
	public ISysRoleService service = (ISysRoleService)ServiceProvider.getBean("sysRoleServiceImpl");
	public SysRoleResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.SYSROLE);
	}
}