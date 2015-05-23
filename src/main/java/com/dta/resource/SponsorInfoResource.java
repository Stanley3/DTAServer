package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;



import com.dta.bean.SponsorInfo;
import com.dta.service.ISponsorInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.SponsorInfoVo;

@Path("sponsorInfo")
public class SponsorInfoResource extends BaseAllResource<SponsorInfo, SponsorInfoVo>{
	//@Autowired
	public ISponsorInfoService service = (ISponsorInfoService)ServiceProvider.getBean("sponsorInfoServiceImpl");
	public SponsorInfoResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.SPONSORINFO);
	}
}