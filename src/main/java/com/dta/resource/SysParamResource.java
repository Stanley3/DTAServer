package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;

import com.dta.bean.SysParam;
import com.dta.service.ISysParamService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.SysParamVo;

@Path("sysParam")
public class SysParamResource extends BaseAllResource<SysParam, SysParamVo> {
	// @Autowired
	public ISysParamService service = (ISysParamService) ServiceProvider
			.getBean("sysParamServiceImpl");

	public SysParamResource() {
		super.setService(service);
		super.setMianId(GlobalConstant.SYSUSER);
	}
}