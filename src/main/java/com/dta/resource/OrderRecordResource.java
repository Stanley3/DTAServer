package com.dta.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dta.bean.OrderInfo;
import com.dta.bean.OrderRecord;
import com.dta.bean.ResultBean;
import com.dta.bean.TrainingRecord;
import com.dta.service.IOrderRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.CoachPrecontractRecordVo;
import com.dta.vo.OrderInfoVo;
import com.dta.vo.OrderRecordVo;
import com.dta.vo.TrainingRecordVo;

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
			if (rows != 0)
				vo.setPage((page + 1) * rows - rows);
			return Response.status(200).entity(service.getCoPreRecord(vo))
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response
					.status(500)
					.entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION,
							GlobalConstant.SELECT_FAIL)).build();
		}
	}

	@GET
	@Path("getOrder01Size")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrder01Size(@BeanParam CoachPrecontractRecordVo vo){
		try{
			return Response.status(200).entity(service.getOrder01Size(vo)).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response
					.status(500)
					.entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION,
							GlobalConstant.SELECT_FAIL)).build();
		}
	}
	
	@GET
	@Path("getStuTranRecord")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStuTranRecord(@BeanParam TrainingRecordVo vo) {
		try {
			int rows = vo.getRows();
			if(rows == -1)
				vo.setRows(0);
			int size = service.getStuTranRecordSize(vo);
			List<TrainingRecord> resultList = service.getStuTranRecord(vo);
			int draw = vo.getDraw();
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("draw", draw);
			resultMap.put("recordsTotal", size);
			resultMap.put("recordsFiltered", size);
			resultMap.put("data", resultList);
			return Response.status(200).entity(resultMap).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response
					.status(200)
					.entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION,
							GlobalConstant.SELECT_FAIL)).build();
		}
	}
	
	@GET
	@Path("getOrderInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrderInfo(@BeanParam OrderInfoVo vo){
		try{
			if(vo.getRows() == -1)
				vo.setRows(0);
			int draw = vo.getDraw();
			int size = service.getOrderInfoSize(vo);
			List<OrderInfo> listResult = new ArrayList<OrderInfo>();
			if(size != 0)
				listResult = service.getOrderInfo(vo);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("draw", draw);
			resultMap.put("recordsTotal", size);
			resultMap.put("recordsFiltered", size);
			resultMap.put("data", listResult);
			return Response.status(200).entity(resultMap).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
	
	@GET
	@Path("getEvaInfoByOrdId")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvaluationInfoByOrderId(@QueryParam("order_id") Integer order_id){
		try{
			return Response.status(200).entity(service.getEvaluationInfoByOrderId(order_id)).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(200).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
}