package com.dta.resource;

import javax.ws.rs.Path;

import com.dta.bean.NewsInfo;
import com.dta.service.INewsInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.NewsInfoVo;

@Path("news")
public class NewsInfoResource extends BaseAllResource<NewsInfo, NewsInfoVo>{
	private INewsInfoService service = (INewsInfoService)ServiceProvider.getBean("newsInfoServiceImpl");
	public NewsInfoResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.NEWSINFO);	
	}
}