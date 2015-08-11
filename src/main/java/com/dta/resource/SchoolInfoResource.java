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

import org.springframework.beans.factory.annotation.Autowired;

import com.dta.bean.ResultBean;
import com.dta.bean.SchoolInfo;
import com.dta.bean.SchoolInfoBasedDistance;
import com.dta.service.ISchoolInfoService;
import com.dta.utils.CommonUtil;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.SchoolInfoBasedDistanceVo;
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

	@GET
	@Path("getSchoolInfoByDistance")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSchoolInfoByDistance(
			@BeanParam SchoolInfoBasedDistanceVo vo) {
		try {
			if (vo.getLatitude() == null || vo.getLatitude() == null)
				throw new IllegalArgumentException("未知的经纬度");
			int start = vo.getPage();
			int length = vo.getRows();
			int size = service.getSchoolDistanceInfoSize(vo);
			List<SchoolInfoBasedDistance> schoolList = new ArrayList<SchoolInfoBasedDistance>();
			if (size != 0) {
				schoolList = service.getSchoolDistanceInfo(vo);
				for (int i = 0; i < schoolList.size(); ++i) {
					schoolList.get(i).setDistance(
							CommonUtil.GetDistance(vo.getLatitude(), vo
									.getLongitude(), schoolList.get(i)
									.getLatitude(), schoolList.get(i)
									.getLongitude()));
				}
				CommonUtil.quickSort(schoolList, 0, schoolList.size() - 1);
			}
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("total", size);
			if (length == 0)
				resultMap.put("data", schoolList);
			else
				resultMap.put("data", schoolList.subList(
						start,
						(start + length) >= schoolList.size() ? schoolList
								.size() - 1 : (start + length)));
			return Response.status(200).entity(resultMap).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response
					.status(500)
					.entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION,
							GlobalConstant.SELECT_FAIL)).build();
		}
	}
}