package com.dta.resource;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.springframework.beans.factory.annotation.Autowired;














import com.dta.bean.ResultBean;
import com.dta.service.IBaseAllService;
import com.dta.service.impl.NewsInfoServiceImpl;
import com.dta.utils.GlobalConstant;
import com.esotericsoftware.reflectasm.MethodAccess;

public class BaseAllResource<T, V>{
	//@Autowired
	private IBaseAllService<T, V> service;
	private String mianId; //T javabean对应表的主键
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(@BeanParam T po){
		try{
			if(service.addObject(po) == 1){
				return Response.status(201).entity(new ResultBean(GlobalConstant.OPERATION_SUCCESS, 
						GlobalConstant.INSERT_SUCCESS)).build();
			}else{
				return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_FAIL, 
						GlobalConstant.INSERT_FAIL)).build();
			}
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
	
	@POST
	@Path("update/{id}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateById(@BeanParam T po, @PathParam("id")String id){
		Class<?> cl = po.getClass();
		try{
		MethodAccess access = MethodAccess.get(cl);
		access.invoke(cl, generateMethodName("set", mianId), id);
		System.out.println(access.invoke(cl, generateMethodName("get", mianId)));
		if(service.updateObjectById(po) == 1){
			return Response.status(201).entity(new ResultBean(GlobalConstant.OPERATION_SUCCESS, 
					GlobalConstant.UPDATE_SUCCESS)).build();
		}else{
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_FAIL, 
					GlobalConstant.UPDATE_FAIL)).build();
		}
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
		
	}
	
	@GET
	@Path("delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteObjectById(@PathParam("id")String id){
		try{
			int table_id = Integer.valueOf(id);
			if(service.deleteObjectById(table_id) == 1){
				return Response.status(200).entity(new ResultBean(GlobalConstant.OPERATION_SUCCESS,
						GlobalConstant.DELETE_SUCCESS)).build();
			}else{
				return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_FAIL, 
						GlobalConstant.DELETE_FAIL)).build();
			}
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
	
	@GET
	@Path("delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteMultiObjects(@QueryParam("ids")String ids){
		try{
			String[] strArray = ids.split("|");
			ArrayList<Integer> idArray = null;
			for(int i=0; i<strArray.length; ++i)
				idArray.add(Integer.valueOf(strArray[i]));
			if(service.deleteMultiData(idArray) >= 0){
				return Response.status(200).entity(new ResultBean(GlobalConstant.OPERATION_SUCCESS, 
						GlobalConstant.DELETE_SUCCESS)).build();
			}else{
				return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_FAIL, 
						GlobalConstant.DELETE_FAIL)).build();
			}
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
	
	@POST
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@BeanParam T po){
		try{
			List<T> resultList = service.getAll(po);
			if(resultList != null){
				return Response.status(200).entity(resultList).build();
			}else{
				return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_FAIL, 
						GlobalConstant.SELECT_FAIL)).build();
			}
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
	
	@POST
	@Path("getPage")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPage(@BeanParam T po){
		Class<?> cl = po.getClass();
		try{
			MethodAccess access = MethodAccess.get(cl);
			int page = (Integer)access.invoke(cl, "getPage");
			int rows = (Integer)access.invoke(cl, "getRows");
			if(page > 0 && rows > 0){
				access.invoke(cl, "setPage", (page-1)*rows);
				List<T> resultList = service.getPage(po);
				int size = service.getSize(po);
				if(resultList != null){
					Map<String,Object> resultMap = new HashMap<String, Object>(); 
					resultMap.put("total", size);
					resultMap.put("rows", resultList);
					return Response.status(200).entity(resultMap).build();
				}
			}
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_FAIL, 
					GlobalConstant.SELECT_FAIL)).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_XML)
	public Response getObjectById(@PathParam("id")int id) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		System.out.println(id);
		if(service != null){
			System.out.println("serive is not null");
			System.out.println(service instanceof NewsInfoServiceImpl );
		}
		T po = service.getObjectById(id);
		//return Response.status(200).entity("{\"code\":1, \"desc\":\"success\"}").build();
		//System.out.println(po.getClass().getMethod("getUser_name").invoke(po));
		return Response.status(200).entity(po).build();
	}

	private String generateMethodName(String methodName, String mainId){
		return methodName + mainId.substring(0, 1).toUpperCase() + mainId.substring(1).toLowerCase();
	}
	
	public IBaseAllService<T, V> getService() {
		return service;
	}

	public void setService(IBaseAllService<T, V> service) {
		this.service = service;
	}

	public String getMianId() {
		return mianId;
	}

	public void setMianId(String mianId) {
		this.mianId = mianId;
	}
}