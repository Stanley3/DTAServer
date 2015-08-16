package com.dta.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dta.bean.DisplayStudentDepositReocrd;
import com.dta.bean.ResultBean;
import com.dta.bean.ShowDepositRecord;
import com.dta.bean.StudentDepositRecord;
import com.dta.bean.VIPStudentOfCoachInfo;
import com.dta.service.IStudentDepositRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.utils.SessionUtil;
import com.dta.vo.DisplayStudentDepositRecordVo;
import com.dta.vo.ShowDepositRecordVo;
import com.dta.vo.StudentDepositRecordVo;
import com.dta.vo.VIPStudentOfCoachInfoVo;

@Path("studentDepositRecord")
public class StudentDepositRecordResource extends
		BaseAllResource<StudentDepositRecord, StudentDepositRecordVo> {
	// @Autowired
	public IStudentDepositRecordService service = (IStudentDepositRecordService) ServiceProvider
			.getBean("studentDepositRecordServiceImpl");

	public StudentDepositRecordResource() {
		super.setService(service);
		super.setMianId(GlobalConstant.STUDENTDEPOSITRECORD);
	}

	@GET
	@Path("getStuDepInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStuDepInfo(@BeanParam ShowDepositRecordVo vo) {
		try {
			if (vo.getRows() == -1)
				vo.setRows(0);
			int draw = vo.getDraw() == null ? 0 : vo.getDraw();
			int size = 0;
			List<ShowDepositRecord> resultList = new ArrayList<ShowDepositRecord>();
			Map<String, Object> resultMap = new HashMap<String, Object>();
			if (vo.getSearch() != null && !vo.getSearch().isEmpty()) {
				Pattern pattern = Pattern.compile("^\\d+$");
				Matcher matcher = pattern.matcher(vo.getSearch());
				if (matcher.matches())
					vo.setDeposit_date(vo.getSearch());
				size = service.globalSerachSize(vo);
				if (size != 0)
					resultList = service.globalSerach(vo);
				resultMap.put("recordsTotal", size);
			} else {
				size = service.getStuDepInfoSize(vo);
				if (size != 0)
					resultList = service.getStuDepInfo(vo);
				resultMap.put("recordsTotal", size);
			}
			resultMap.put("draw", draw);
			resultMap.put("recordsFiltered", size);
			/*
			 * if(size != 0) resultList= service.getStuDepInfo(vo);
			 */
			resultMap.put("data", resultList);
			return Response.status(200).entity(resultMap).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response
					.status(200)
					.entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION,
							GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}

	@GET
	@Path("getVIPStudentOfCoachInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVIPStudentOfCoachInfo(
			@BeanParam VIPStudentOfCoachInfoVo vo) {
		try {
			int size = service.getVIPStudentOfCoachInfoSize(vo);
			List<VIPStudentOfCoachInfo> list = new ArrayList<VIPStudentOfCoachInfo>();
			if (size != 0)
				list = service.getVIPStudentOfCoachInfo(vo);
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
	@Path("getStudentDepositRecord")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentDepositRecord(
			@BeanParam DisplayStudentDepositRecordVo vo) {
		try {
			int size = service.displayStudentDepositRecordSize(vo);
			List<DisplayStudentDepositReocrd> list = new ArrayList<DisplayStudentDepositReocrd>();
			if (size != 0)
				list = service.displayStudentDepositRecord(vo);
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
	@Override
	public Response add(@BeanParam StudentDepositRecord po){
		po.setDepositor_id(SessionUtil.getUserIdByRequest(super.getRequest()));
		return super.add(po);
	}
}