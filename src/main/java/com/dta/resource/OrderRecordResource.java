package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;


import com.dta.bean.OrderRecord;
import com.dta.service.IOrderRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;

@Path("orderRecord")
public class OrderRecordResource extends BaseAllResource<OrderRecord, OrderRecord>{
	//@Autowired
	public IOrderRecordService service = (IOrderRecordService)ServiceProvider.getBean("orderRecordServiceImpl");
	public OrderRecordResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.ORDERRECORD);
	}
}