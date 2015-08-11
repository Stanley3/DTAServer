package com.dta.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
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

import com.dta.bean.DisplayCoachScheduleInfo;
import com.dta.bean.EditScheduleInfo;
import com.dta.bean.ResultBean;
import com.dta.bean.ScheduleInfo;
import com.dta.bean.SelectCoach;
import com.dta.service.IOrderRecordService;
import com.dta.service.IScheduleInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.ScheduleInfoVo;
import com.dta.vo.SelectCoachVo;

@Path("scheduleInfo")
public class ScheduleInfoResource extends
		BaseAllResource<ScheduleInfo, ScheduleInfoVo> {
	// @Autowired
	public IScheduleInfoService service = (IScheduleInfoService) ServiceProvider
			.getBean("scheduleInfoServiceImpl");
	public IOrderRecordService orderService = (IOrderRecordService) ServiceProvider
			.getBean("orderRecordServiceImpl");
	private Logger logger = LoggerFactory
			.getLogger("com.dta.resource.ScheduleInfoResource");

	public ScheduleInfoResource() {
		super.setService(service);
		super.setMianId(GlobalConstant.SCHEDULEINFO);
	}

	@GET
	@Path("selectCoach")
	@Produces(MediaType.APPLICATION_JSON)
	public Response selectCoach(@BeanParam SelectCoachVo vo) {
		try {
			int size = service.selectCoachSize(vo);
			List<SelectCoach> list = new ArrayList<SelectCoach>();
			if (size != 0)
				list = service.selectCoach(vo);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("total", size);
			resultMap.put("data", list);
			return Response.status(200).entity(resultMap).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response
					.status(500)
					.entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION,
							GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}

	@GET
	@Path("getCoachSomedayTeachInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response displayCoachScheduleInfo(
			@QueryParam("coach_id") Integer coach_id,
			@QueryParam("schedule_date") String schedule_date,
			@QueryParam("subject") Integer subject,
			@QueryParam("student_id") Integer student_id) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("coach_id", coach_id);
			map.put("schedule_date", schedule_date);
			map.put("subject", subject);
			List<DisplayCoachScheduleInfo> list = service
					.displayCoachScheduleInfo(map);
			byte[] precontractedDurationInfo = new byte[24];
			for (int i = 0; i < 24; ++i)
				precontractedDurationInfo[i] = 0;
			if (list != null && list.size() > 0) {
				if (list.get(0).getIsOnDuty() != 0) {
					String startTime = schedule_date + " 00:00:00";
					String endTime = schedule_date + " 23:59:59";
					Map<String, Object> trainingTimeMap = new HashMap<String, Object>();
					trainingTimeMap.put("startTime", startTime);
					trainingTimeMap.put("endTime", endTime);
					trainingTimeMap.put("student_id", student_id);
					List<String> trainingTimeList = orderService
							.getStudentSomedayPrecontractInfo(trainingTimeMap);
					for (int i = 0; trainingTimeList != null
							&& i < trainingTimeList.size(); ++i) {
						String tmep = trainingTimeList.get(i);
						int index = Integer.valueOf(tmep.split(" ")[1]
								.split(":")[0]);
						++precontractedDurationInfo[index];
					}
				}
				StringBuilder tmp = new StringBuilder();
				for (int i = 0; i < 24; ++i)
					tmp.append(precontractedDurationInfo[i]);
				list.get(0).setScheduleInfo(tmp.toString());
				return Response.status(200).entity(list.get(0)).build();
			} else
				return Response.status(200).entity(null).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response
					.status(500)
					.entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION,
							e.getMessage())).build();
		}
	}

	@POST
	@Path("editScheduleInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response editScheduleInfo(@BeanParam ScheduleInfo scheduleInfo) {
		try {
			/*
			 * ScheduleInfo scheduleInfo = new ScheduleInfo();
			 * scheduleInfo.setSchedule_id(po.getSchedule_id());
			 * scheduleInfo.setContent(po.getContent());
			 * scheduleInfo.setSubject(po.getSubject());
			 * scheduleInfo.setStudent_attribute(po.getStudent_attribute());
			 * scheduleInfo.setStudent_toplimit(po.getStudent_toplimit());
			 * scheduleInfo.setDevice_attribude(po.getDevice_attribute());
			 * scheduleInfo.setDevice_type(po.getDevice_type());
			 */
			if (service.updateObjectById(scheduleInfo) == 1)
				return Response
						.status(200)
						.entity(new ResultBean(
								GlobalConstant.OPERATION_SUCCESS,
								GlobalConstant.UPDATE_SUCCESS)).build();
			else
				return Response
						.status(200)
						.entity(new ResultBean(GlobalConstant.OPERATION_FAIL,
								GlobalConstant.UPDATE_FAIL)).build();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return Response
					.status(500)
					.entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION,
							e.getMessage())).build();
		}
	}
}