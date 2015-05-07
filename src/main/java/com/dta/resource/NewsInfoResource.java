package com.dta.resource;

import javax.ws.rs.Path;

import com.dta.bean.NewsInfo;
import com.dta.service.INewsInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;

@Path("news")
public class NewsInfoResource extends BaseAllResource<NewsInfo, NewsInfo>{
	private INewsInfoService service = (INewsInfoService)ServiceProvider.getBean("newsInfoServiceImpl");
	public NewsInfoResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.NEWSINFO);	
	}
}