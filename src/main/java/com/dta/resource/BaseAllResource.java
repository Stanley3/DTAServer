package com.dta.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.springframework.beans.factory.annotation.Autowired;


import com.dta.service.IBaseAllService;

public class BaseAllResource<T, V>{
	//@Autowired
	private IBaseAllService<T, V> service;
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(@BeanParam T po){
		service.addObject(po);
		return null;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getObjectById(@PathParam("id")int id){
		System.out.println(id);
		//T po = service.getObjectById(id);
		return Response.status(200).entity("{\"code\":1, \"desc\":\"success\"}").build();
		//return Response.status(200).entity(po).build();
	}

	
	
	public IBaseAllService<T, V> getService() {
		return service;
	}

	public void setService(IBaseAllService<T, V> service) {
		this.service = service;
	}
}