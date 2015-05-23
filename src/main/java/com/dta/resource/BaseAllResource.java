package com.dta.resource;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import org.springframework.beans.factory.annotation.Autowired;


































import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.transaction.annotation.Transactional;

import com.dta.bean.CoachBasicInfo;
import com.dta.bean.ResultBean;
import com.dta.bean.SchoolInfo;
import com.dta.bean.StudentBasicInfo;
import com.dta.bean.SysUser;
import com.dta.service.IBaseAllService;
import com.dta.service.impl.NewsInfoServiceImpl;
import com.dta.utils.GlobalConstant;
import com.esotericsoftware.reflectasm.MethodAccess;

public class BaseAllResource<T, V>{
	//@Autowired
	private IBaseAllService<T, V> service;
	private String mianId; //T javabean对应表的主键
	@Context
	private  HttpServletRequest request;
	@Context 
	private HttpServletResponse response;
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response add(@BeanParam T po){
		try{
			if(po instanceof CoachBasicInfo){
				String idCard_no = ((CoachBasicInfo) po).getIdentity_card_no();
				((CoachBasicInfo) po).setLogin_pwd(idCard_no.substring(idCard_no.length() - 6));
			}
			if(service.addObject(po) == 1){
				return Response.status(201).entity(new ResultBean(GlobalConstant.OPERATION_SUCCESS, 
						GlobalConstant.INSERT_SUCCESS)).build();
			}else{
				return Response.status(500).header("Content-Type", "image/jgp").entity(new ResultBean(GlobalConstant.OPERATION_FAIL, 
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
		int table_id = Integer.valueOf(id);
		access.invoke(po, generateMethodName("set", mianId), table_id);
		//System.out.println(access.invoke(po, generateMethodName("get", "order_status")));
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
			String[] strArray = ids.split("\\|");
			ArrayList<Integer> idArray = new ArrayList<Integer>();
			for(int i=0; i<strArray.length; ++i){
				idArray.add(Integer.valueOf(strArray[i]));
			}
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
	
	@GET
	@Path("getAll")
	//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll(@BeanParam V vo){
		try{
			List<T> resultList = service.getAll(vo);
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
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPage(@BeanParam V vo){
		Class<?> cl = vo.getClass();
		try{
			MethodAccess access = MethodAccess.get(cl);
			int page = (Integer)access.invoke(vo, "getPage");
			int draw = (Integer)access.invoke(vo, "getDraw");
			int rows = (Integer)access.invoke(vo, "getRows");
			if(page >= 0 && draw >= 0){
				/*access.invoke(vo, "setPage", (page-1)*rows);*/
				
				List<T> resultList = null;
				if(rows == -1)
					resultList = service.getAll(vo);
				else
					resultList = service.getPage(vo);
				int size = service.getSize(vo);
				if(resultList != null){
					Map<String,Object> resultMap = new HashMap<String, Object>();
					resultMap.put("draw", draw);
					resultMap.put("recordsTotal", size);
					resultMap.put("recordsFiltered", size);
					resultMap.put("data", resultList);
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
	public Response getObjectById(@PathParam("id")int id){
		System.out.println(id);
		if(service != null){
			System.out.println("serive is not null");
			System.out.println(service instanceof NewsInfoServiceImpl );
		}
		try{
			T po = service.getObjectById(id);
			//return Response.status(200).entity("{\"code\":1, \"desc\":\"success\"}").build();
			//System.out.println(po.getClass().getMethod("getUser_name").invoke(po));
			if(po != null){
				/*Map<String, Object> map = new HashMap<String, Object>();
				List<T> list = new ArrayList<T>();
				list.add(po);
				map.put("data", list);*/
				return Response.status(200).entity(po).build();
			}else{
				return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_SUCCESS, 
						GlobalConstant.SELECT_FAIL)).build();
			}
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}

	protected String generateMethodName(String methodName, String mainId){
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

	public HttpServletResponse getResponse() {
		return response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}
}