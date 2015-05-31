package com.dta.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.dta.bean.ResultBean;
import com.dta.bean.SchoolInfo;
import com.dta.service.ISchoolInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.SchoolInfoVo;

@Path("schoolInfo")
public class SchoolInfoResource extends
		BaseAllResource<SchoolInfo, SchoolInfoVo> {
	// @Autowired
	public ISchoolInfoService service = (ISchoolInfoService) ServiceProvider
			.getBean("schoolInfoServiceImpl");

	/*
	 * @Autowired private ISchoolInfoService service;
	 */

	public SchoolInfoResource() throws Exception {
		if (service == null)
			throw new Exception("service is null");
		super.setService(service);
		super.setMianId(GlobalConstant.SCHOOLINFO);
	}

	@GET
	@Path("getAvaiableCoachNumbers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAvaiableCoachNumbers(
			@QueryParam("school_id") int school_id) {
		try {
			return Response
					.status(200)
					.entity(new ResultBean(GlobalConstant.OPERATION_SUCCESS,
							String.valueOf(service
									.getAvaiableCoachNumbers(school_id))))
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response
					.status(500)
					.entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION,
							GlobalConstant.SELECT_FAIL)).build();
		}
	}
}