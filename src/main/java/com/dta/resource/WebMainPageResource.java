package com.dta.resource;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dta.bean.ResultBean;
import com.dta.service.IWebMainPageService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.utils.SessionUtil;

@Path("webMainPage")
public class WebMainPageResource {
	Logger logger = LoggerFactory
			.getLogger("com.dta.resource.WebMainPageResource");
	private IWebMainPageService service = (IWebMainPageService) ServiceProvider
			.getBean("webMainPageServiceImpl");

	public WebMainPageResource() {
	}

	@GET
	@Path("getStaticInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStaticInfo(@QueryParam("username") String username) {
		try {
			return Response.status(200).entity(service.getStaticInfo(username))
					.build();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return Response
					.status(500)
					.entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION,
							GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}

	public Map<String, Integer> getStaticInfoByUsername(String username) {
		try {
			Map<String, Integer> map = service.getStaticInfo(username);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return null;
		}
	}

	public Map<String, Integer> getNumbers(String sessionId) {
		return SessionUtil.getNumbers(sessionId);
	}
}
