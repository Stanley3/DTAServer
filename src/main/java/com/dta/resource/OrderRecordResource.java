package com.dta.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dta.bean.OrderRecord;
import com.dta.bean.ResultBean;
import com.dta.service.IOrderRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.CoachPrecontractRecordVo;
import com.dta.vo.OrderRecordVo;

@Path("orderRecord")
public class OrderRecordResource extends
		BaseAllResource<OrderRecord, OrderRecordVo> {
	// @Autowired
	public IOrderRecordService service = (IOrderRecordService) ServiceProvider
			.getBean("orderRecordServiceImpl");

	public OrderRecordResource() {
		super.setService(service);
		super.setMianId(GlobalConstant.ORDERRECORD);
	}

	@GET
	@Path("getCoachPrecontractedRecord")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCoPreRecord(@BeanParam CoachPrecontractRecordVo vo) {
		try {
			int page = vo.getPage();
			int rows = vo.getRows();
			if(rows != 0)
				vo.setPage((page+1)*rows-rows);
			return Response.status(200).entity(service.getCoPreRecord(vo)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response
					.status(500)
					.entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION,
							GlobalConstant.SELECT_FAIL)).build();
		}
	}
}