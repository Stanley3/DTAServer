package com.dta.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;

import com.dta.bean.CoachBasicInfo;
import com.dta.bean.ResultBean;
import com.dta.bean.StudentLoginSuccessInfo;
import com.dta.service.ICoachBasicInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.CoachBasicInfoVo;
import com.esotericsoftware.reflectasm.MethodAccess;

@Path("coachBasicInfo")
public class CoachBasicInfoResource extends
		BaseAllResource<CoachBasicInfo, CoachBasicInfoVo> {
	private ICoachBasicInfoService service = (ICoachBasicInfoService) ServiceProvider
			.getBean("coachBasicInfoServiceImpl");
	@Autowired
	public JdbcRealm myRealm;
	
	public CoachBasicInfoResource() {
		super.setService(service);
		super.setMianId(GlobalConstant.COACHBASICINFO);
	}

	@POST
	@Path("addWithPhoto")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	//@Produces(MediaType.APPLICATION_JSON)
	public void addWithPhoto() {
		HttpServletRequest request = super.getRequest();
		HttpServletResponse response = super.getResponse();
		PrintWriter printer = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			/*return Response
					.status(200)
					.entity(new ResultBean(GlobalConstant.OPERATION_FAIL,
							GlobalConstant.NOFILE)).build();*/
			response.setStatus(200);
			try {
				printer = response.getWriter();
				printer.println("<script>alert('未找到文件');document.getElementsByTagName('form')[0].reset();</script>");
				printer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		} else {
			try {
				ServletFileUpload fileUpload = new ServletFileUpload();
				FileItemIterator iterator = fileUpload.getItemIterator(request);
				printer = response.getWriter();
				CoachBasicInfo po = new CoachBasicInfo();
				while (iterator.hasNext()) {
					FileItemStream item = iterator.next();
					String name = item.getFieldName();
					InputStream stream = item.openStream();
					if (item.isFormField()) {
						String value = Streams.asString(stream, "utf8");
						System.out.println("获取到的表单域名：" + name + ", 其值为：" + value);
						MethodAccess access = MethodAccess
								.get(CoachBasicInfo.class);
						if(value != null && !value.isEmpty())//非必输项有可能是空的
							try{
								access.invoke(po, generateMethodName("set", name),
										value);
							}catch(ClassCastException e){
								access.invoke(po, generateMethodName("set", name),
										Integer.valueOf(value));
							}
					} else {
						InputStream streamTmp = stream;
						int size = streamTmp.available();
						if(size != 0)
							po.setPhoto(FileCopyUtils.copyToByteArray(streamTmp));
					}
				}
				if (service.addObject(po) == 1){
					response.setStatus(200);
					printer.println("<script>alert('success');window.parent.document.getElementById('form').reset();</script>");
					printer.flush();
					/*return Response
							.status(200)
							.entity(new ResultBean(
									GlobalConstant.OPERATION_SUCCESS,
									GlobalConstant.INSERT_SUCCESS)).build();*/
					//return null;
				}
				else {
					/*return Response
							.status(200)
							.entity(new ResultBean(
									GlobalConstant.OPERATION_FAIL,
									GlobalConstant.INSERT_FAIL)).build();*/
					printer.println("<script>alert('error')</script>");
					printer.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
				/*return Response
						.status(500)
						.entity(new ResultBean(
								GlobalConstant.OPERATION_EXCEPTION,
								GlobalConstant.OPERATION_EXCEPTION_DESC))
						.build();*/
				printer.println("<script>alert('exception')</script>");
				printer.flush();
			}
		}
	}

	@GET
	@Path("downloadPhoto")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response download(@QueryParam("id") int id) {
		HttpServletResponse response = super.getResponse();
		CoachBasicInfo po = service.downloadPhoto(id);
		if (po != null && po.getPhoto() != null) {
			response.setHeader("Content-Type", "image/jpeg;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=\"pic.jpg\"");
			try {
				OutputStream out = response.getOutputStream();
				out.write(po.getPhoto());
				return Response
						.status(500)
						.entity(new ResultBean(GlobalConstant.OPERATION_FAIL,
								GlobalConstant.UPDATE_SUCCESS)).build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response
						.status(500)
						.entity(new ResultBean(
								GlobalConstant.OPERATION_EXCEPTION,
								GlobalConstant.OPERATION_EXCEPTION_DESC))
						.build();
			}
		} else {
			System.err.println("不存在图片");
			return Response
					.status(500)
					.entity(new ResultBean(GlobalConstant.OPERATION_FAIL,
							GlobalConstant.SELECT_FAIL)).build();
		}
	}

	@POST
	@Path("updateWithPhoto/{id}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_HTML)
	public Response updateWithPhoto(@PathParam("id") int id) {
		HttpServletRequest request = super.getRequest();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		isMultipart = true;
		if (!isMultipart) {
			return Response
					.status(200)
					.entity(new ResultBean(GlobalConstant.OPERATION_FAIL,
							GlobalConstant.NOFILE)).build();
		} else {
			try {
				ServletFileUpload fileUpload = new ServletFileUpload();
				FileItemIterator iterator = fileUpload.getItemIterator(request);
				CoachBasicInfo po = new CoachBasicInfo();
				po.setCoach_id(id);
				while (iterator.hasNext()) {
					FileItemStream item = iterator.next();
					String name = item.getFieldName();
					InputStream stream = item.openStream();
					if (item.isFormField()) {
						String value = Streams.asString(stream, "utf8");
						MethodAccess access = MethodAccess
								.get(CoachBasicInfo.class);
						if(value != null && !value.isEmpty())//非必输项有可能是空的
							try{
								access.invoke(po, generateMethodName("set", name),
										value);
							}catch(ClassCastException e){
								access.invoke(po, generateMethodName("set", name),
										Integer.valueOf(value));
							}
					} else {
						InputStream streamTmp = stream;
						int size = streamTmp.available();
						if(size != 0)
							po.setPhoto(FileCopyUtils.copyToByteArray(streamTmp));
					}
				}
				if (service.updateObjectById(po) == 1)
					return Response
							.status(200)
							.entity("<script>alert('success');window.parent.document.getElementById('form').reset();</script>").build();
				else {
					return Response
							.status(200)
							.entity("<script>alert('error')</script>").build();
				}
			} catch (Exception e) {
				e.printStackTrace();
				return Response
						.status(500)
						.entity("<script>alert('exception')</script>")
						.build();
			}
		}
	}
	
	public Response getPage(@BeanParam CoachBasicInfoVo vo){
		String search = vo.getSearch();
		if(search != null && !search.isEmpty()){
			int size = service.getSize(vo);
			List<CoachBasicInfo> resultList = service.globalSearch(vo);
			Map<String,Object> resultMap = new HashMap<String, Object>();
			resultMap.put("draw", (Integer)vo.getDraw());
			resultMap.put("recordsTotal", size);
			resultMap.put("recordsFiltered", service.globalSearchSize(vo));
			resultMap.put("data", resultList);
			return Response.status(200).entity(resultMap).build();
		}else
			return super.getPage(vo);
	}
	
	@GET
	@Path("getCoachInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCoachInfo(@QueryParam("coach_id")Integer coach_id){
		try{
			return Response.status(200).entity(service.getCoachInfo(coach_id)).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
	
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@FormParam("username")String username, 
							@FormParam("password")String password,
							@FormParam("source")String source){
		try{
			if(myRealm == null)
				System.out.println("myRealm is null");
			else
				System.out.println("myRealm is not null and getAuthenticationCacheName is " + myRealm.getAuthenticationCacheName());
			myRealm.setAuthenticationQuery("select login_pwd from coach_basic_info where phone = ?");
			myRealm.setUserRolesQuery("select role_name from sys_role as R join user_roles as UR on R.role_id = UR.role_id join coach_basic_info as C on UR.user_id = C.coach_id where UR.flag = 2 and phone = ?");
			//myRealm.setPermissionsQuery("select permission_name from sys_permission as P join sys_role as R on P.role_id = R.role_id where role_name = ?");
			UsernamePasswordToken token = new UsernamePasswordToken();
			token.setPassword(password.toCharArray());
			token.setUsername(username);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			System.out.println("JSESSIONID = " + subject.getSession().getId());
			Integer coach_id = service.getCoachInfoByName(username);
			//return Response.status(200).entity(new ResultBean(1, subject.getPrincipal().toString())).build();
			return Response.status(200).entity(new ResultBean(1, String.valueOf(coach_id))).build();
		}catch(AuthenticationException ae){
			return Response.status(200).entity(new ResultBean(2, "用户名或密码错误")).build();
		}
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}finally{
			myRealm.setAuthenticationQuery("select user_pwd from sys_user where user_name = ?");
			myRealm.setUserRolesQuery("select role_name from sys_role as R join user_roles as UR on R.role_id = UR.role_id join sys_user as U on UR.user_id = U.user_id where flag = 0 and user_name = ?");
		}
		
	}
}