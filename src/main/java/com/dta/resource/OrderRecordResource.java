package com.dta.resource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.dta.bean.CoachFianceSummarizing;
import com.dta.bean.CoachIncomeRecord;
import com.dta.bean.CoachOrderById;
import com.dta.bean.CoachTeachRecord;
import com.dta.bean.MyOrderRecord;
import com.dta.bean.OrderInfo;
import com.dta.bean.OrderRecord;
import com.dta.bean.ResultBean;
import com.dta.bean.TrainingRecord;
import com.dta.service.IOrderRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.CoachIncomeRecordVo;
import com.dta.vo.CoachOrderByIdVo;
import com.dta.vo.CoachPrecontractRecordVo;
import com.dta.vo.CoachTeachRecordVo;
import com.dta.vo.MyOrderRecordVo;
import com.dta.vo.OrderInfoVo;
import com.dta.vo.OrderRecordVo;
import com.dta.vo.TrainingRecordVo;

@Path("orderRecord")
public class OrderRecordResource extends
		BaseAllResource<OrderRecord, OrderRecordVo> {
	// @Autowired
	public IOrderRecordService service = (IOrderRecordService) ServiceProvider
			.getBean("orderRecordServiceImpl");
	private Logger logger = LoggerFactory.getLogger("com.dta.resource.OrderRecordResource");
	
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
	@Path("getLatestRrecontractRecordSize")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getLatestRrecontractRecordSize(@BeanParam CoachPrecontractRecordVo vo){
		try{
			return Response.status(200).entity(service.getLatestRrecontractRecordSize(vo)).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(-1).build();
		}
	}
	
	@GET
	@Path("getLastestCancelRecordSize")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getLastestCancelRecordSize(@BeanParam CoachPrecontractRecordVo vo){
		try{
			System.out.println("********** in orderRecordResource" + vo.getLastQueryTime());
			return Response.status(200).entity(service.getLastestCancelRecordSize(vo)).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(-1).build();
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
	
	@GET
	@Path("getCoachFinanceSumInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCoachFinanceSumInfo(@QueryParam("coach_id") Integer coach_id){
		try{
			double totalIncome = 0;
			int VIPStudentNumbers = 0;
			int teachingTimes = 0;
			int subject2TeachingTimes = 0;
			int subject3TeachingTimes = 0;
			double freezeAmount = 0;
			List<CoachFianceSummarizing> list = service.getCoachFinanceSumInfo(coach_id);
			for(int i=0;i<list.size(); ++i){
				if(list.get(i).getOrder_status() == 2)
					freezeAmount += list.get(i).getOrder_amount();
				else if(list.get(i).getOrder_status() == 3)
					totalIncome += list.get(i).getOrder_amount();
				if(list.get(i).getCourse_status() == 2)
					++subject2TeachingTimes;
				else if(list.get(i).getCourse_status() == 3)
					++subject3TeachingTimes;
				if(list.get(i).getStudent_level() != 0)
					++VIPStudentNumbers;
			}
			teachingTimes = subject2TeachingTimes + subject3TeachingTimes;
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("totalIncome", totalIncome);
			resultMap.put("VIPStudentNumbers", VIPStudentNumbers);
			resultMap.put("teachingTimes", teachingTimes);
			resultMap.put("subject2TeachingTimes", subject2TeachingTimes);
			resultMap.put("subject3TeachingTimes", subject3TeachingTimes);
			resultMap.put("freezeAmount", freezeAmount);
			resultMap.put("coach_id", list.get(0).getCoach_id());
			return Response.status(200).entity(resultMap).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
	
	@GET
	@Path("getCoachTeachRecord")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCoachTeachRecord(@BeanParam CoachTeachRecordVo vo){
		try{
			int size = service.getCoachTeachRecordSize(vo);
			List<CoachTeachRecord> list = new ArrayList<CoachTeachRecord>();
			if(size != 0)
				list = service.getCoachTeachRecord(vo);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("total", size);
			resultMap.put("data", list);
			return Response.status(200).entity(resultMap).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
	
	@Override
	public Response add(@BeanParam OrderRecord po){
		try{
			int result = service.addObject(po);
			switch(result){
			case 0:
				return Response.status(200).entity(new ResultBean(GlobalConstant.OPERATION_FAIL, 
						GlobalConstant.INSERT_FAIL)).build();
			case -1:
				return Response.status(200).entity(new ResultBean(GlobalConstant.OPERATION_FAIL, 
						GlobalConstant.NOTSUFFICIENTFUNDS)).build();
			default:
				return Response.status(200).entity(new ResultBean(GlobalConstant.OPERATION_SUCCESS, 
						GlobalConstant.SUCCESSPRECONTRACT)).build();
			}
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
	
	@GET
	@Path("getStudentOrderRecord")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentOrderRecord(@BeanParam MyOrderRecordVo vo){
		try{
			int size = service.getStudentOrderRecordSize(vo);
			List<MyOrderRecord> list = new ArrayList<MyOrderRecord>();
			if(size != 0)
				list = service.getStudentOrderRecord(vo);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("total", size);
			resultMap.put("data", list);
			return Response.status(200).entity(resultMap).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
	
	@GET
	@Path("getCoachIncomeRecord")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCoachIncomeRecord(@BeanParam CoachIncomeRecordVo vo){
		try{
			int size = service.getCoachIncomeRecordSize(vo);
			List<CoachIncomeRecord> list = new ArrayList<CoachIncomeRecord>();
			if(size != 0)
				list = service.getCoachIncomeRecord(vo);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("total", size);
			resultMap.put("data", list);
			return Response.status(200).entity(resultMap).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
	
	@GET
	@Path("getCoachOrderById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCoachOrderById(@BeanParam CoachOrderByIdVo vo){
		try{
			if(vo.getRows() == -1)
				vo.setRows(0);
			int draw = vo.getDraw();
			int size = service.getCoachOrderByIdSize(vo);
			List<CoachOrderById> listResult = new ArrayList<CoachOrderById>();
			if(size != 0)
				listResult = service.getCoachOrderById(vo);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("draw", draw);
			resultMap.put("recordsTotal", size);
			resultMap.put("recordsFiltered", size);
			resultMap.put("data", listResult);
			return Response.status(200).entity(resultMap).build();
		}catch(Exception e){
			logger.error(e.getMessage());
			e.printStackTrace();
			return Response.status(200).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
	
	@POST
	@Path("coachScanned")
	@Produces(MediaType.APPLICATION_JSON)
	public Response coachScanned(@FormParam("order_id")Integer order_id){
		try{
			boolean rightTime = false;
			if(order_id == null)
				throw new Exception("教练扫描二维码时 订单id为null");
			OrderRecord po = service.getObjectById(order_id);
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			if(StringUtils.hasText(po.getTraining_start_time())){
				Date date = format.parse(format.format(po.getTraining_start_time()));
				long tweleveHoursToMs = 12 * 60 * 60 * 1000;
				if(System.currentTimeMillis() > (date.getTime() - tweleveHoursToMs) 
						&& System.currentTimeMillis() < (date.getTime() + tweleveHoursToMs))
					rightTime = true;
			}
			if(rightTime){
				OrderRecord orderRecord = new OrderRecord();
				orderRecord.setScanned(1);
				orderRecord.setOrder_id(order_id);
				if(service.updateObjectById(orderRecord) == 1)
					return Response.status(200).entity(new ResultBean(GlobalConstant.OPERATION_SUCCESS, GlobalConstant.COACHSCANNEDSUCCESS)).build();
			}
			return Response.status(200).entity(new ResultBean(GlobalConstant.OPERATION_FAIL, GlobalConstant.COACHSCANNEDFAIL)).build();
			
		}catch(Exception e){
			logger.error(e.getMessage());
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, e.getMessage())).build();
		}
	}
	
	@POST
	@Path("cancelPrecontract")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cacelPrcontract(@FormParam("order_id")Integer order_id){
		try{
			if(order_id == null)
				throw new Exception("取消预约时 订单id为null");
			OrderRecord orderRecord = new OrderRecord();
			orderRecord.setOrder_status(1);
			orderRecord.setOrder_id(order_id);
			if(service.updateObjectById(orderRecord) != 1)
				return Response.status(200).entity(new ResultBean(GlobalConstant.OPERATION_FAIL, GlobalConstant.CACELPRECONTRACTFAIL)).build();
			return Response.status(200).entity(new ResultBean(GlobalConstant.OPERATION_SUCCESS, GlobalConstant.CACELPRECONTRACTSUCCESS)).build();
		}catch(Exception e){
			logger.error(e.getMessage());
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, e.getMessage())).build();
		}
	}
}