package com.dta.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dta.bean.ResultBean;
import com.dta.service.IGlobalService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.LatestNumberVo;

@Path("global")
public class GlobalResource {
	private IGlobalService service = (IGlobalService) ServiceProvider
			.getBean("globalServiceImpl");

	@GET
	@Path("getLatestNumber")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLastestNumber(@BeanParam LatestNumberVo vo) {
		try {
			System.out.println(vo.getCoach_id());
			System.out.println(vo.getLastQueryCancelTime());
			System.out.println(vo.getLastQueryEvaluationTime());
			System.out.println(vo.getLastQueryPrecontractTime());
			return Response.status(200).entity(service.getLatestNumber(vo))
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response
					.status(500)
					.entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION,
							GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
}
