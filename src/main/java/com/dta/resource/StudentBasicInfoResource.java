package com.dta.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;


import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.util.FileCopyUtils;

import com.dta.bean.GatherStudentInfo;
import com.dta.bean.ResultBean;
import com.dta.bean.StudentBasicInfo;
import com.dta.service.IStudentBasicInfoService;
import com.dta.service.IStudentLoginInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.StudentBasicInfoVo;
import com.esotericsoftware.reflectasm.MethodAccess;

@Path("studentBasicInfo")
public class StudentBasicInfoResource extends BaseAllResource<StudentBasicInfo, StudentBasicInfoVo>{
	//@Autowired
	public IStudentBasicInfoService service = (IStudentBasicInfoService)ServiceProvider.getBean("studentBasicInfoServiceImpl");
	public IStudentLoginInfoService loginInfoService = (IStudentLoginInfoService)ServiceProvider.getBean("studentLoginInfoServiceImpl");
	public StudentBasicInfoResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.STUDENTBASICINFO);
	}
	
	@POST
	@Path("handleWithPhoto")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	//@Produces(MediaType.APPLICATION_JSON)
	public void addWithPhoto() {
		HttpServletRequest request = super.getRequest();
		HttpServletResponse response = super.getResponse();
		PrintWriter printer = null;
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
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
				StudentBasicInfo po = new StudentBasicInfo();
				while (iterator.hasNext()) {
					FileItemStream item = iterator.next();
					String name = item.getFieldName();
					InputStream stream = item.openStream();
					if (item.isFormField()) {
						String value = Streams.asString(stream, "utf8");
						System.out.println("获取到的表单域名：" + name + ", 其值为：" + value);
						MethodAccess access = MethodAccess
								.get(StudentBasicInfo.class);
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
							po.setStudent_photo(FileCopyUtils.copyToByteArray(streamTmp));
					}
				}
				int result = 0;
				if(po.getStudent_id() != null)//更新
					result = service.updateObjectById(po);
				else  //新增
					result = service.addObject(po);
				if (result == 1){
					response.setStatus(200);
					printer.println("<script>alert('success');window.parent.document.getElementById('form').reset();</script>");
					printer.flush();
				}
				else {
					printer.println("<script>alert('error')</script>");
					printer.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
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
		StudentBasicInfo po = service.downloadPhoto(id);
		if (po != null && po.getStudent_photo() != null) {
			response.setHeader("Content-Type", "image/jpeg;charset=utf-8");
			response.setHeader("Content-Disposition",
					"attachment;filename=\"pic.jpg\"");
			try {
				OutputStream out = response.getOutputStream();
				out.write(po.getStudent_photo());
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
	
	@GET
	@Path("getStuByIDCard")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStuByIDCard(@QueryParam("identity_card_no") String identity_card_no){
		try{
			Integer student_id = service.getStuByIDCard(identity_card_no);
			if(student_id == null || student_id == 0){
				return Response.status(200).entity(new ResultBean(GlobalConstant.OPERATION_FAIL, GlobalConstant.SELECT_FAIL)).build();
			}
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("student_id", student_id);
			return Response.status(200).entity(map).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(200).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, GlobalConstant.SELECT_FAIL)).build();
		}
	}
	
	@GET
	@Path("gatherStudentInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response gatherStudentInfo(@QueryParam("student_id")Integer student_id){
		try{
			List<GatherStudentInfo> list = service.gatherStudentInfo(student_id);
			String subject_2_start_training_time = "";
			String subject_3_start_training_time = "";
			int subject_2_used_course = 0;
			int subject_3_used_course = 0;
			int subject_2_used_day = 0;
			int subject_3_used_day = 0;
			boolean foundCourse3 = false;
			boolean foundCourse2 = false;
			int subject_2 = 0, subject_3 = 0;
			if(list != null && list.size() != 0){
				for(int i=0; i<list.size(); ++i){
					if(list.get(i).getCourse_status() == 2){
						if(!foundCourse2 ){
							subject_2_start_training_time = list.get(i).getTraining_start_time();
							subject_2 = i;
							foundCourse2 = true;
						}
						++subject_2_used_course;
					}else if(list.get(i).getCourse_status() == 3){
						if(!foundCourse3){
							subject_3_start_training_time = list.get(i).getTraining_start_time();
							subject_3 = i;
							foundCourse3 = true;
						}
						++subject_3_used_course;
					}
				}
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(!subject_3_start_training_time.isEmpty()){
				Date date = format.parse(subject_3_start_training_time);
				Date currentDate = new Date();
				subject_3_used_day = (int)((currentDate.getTime() - date.getTime()) / (24 * 3600 * 1000));
			}
			if(!subject_2_start_training_time.isEmpty()){
				Date date = format.parse(subject_2_start_training_time);
				Date currentDate = new Date();
				subject_2_used_day = (int)((currentDate.getTime() - date.getTime()) / (24 * 3600 * 1000));
			}
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("subject_2_used_course", subject_2_used_course);
			resultMap.put("subject_2_passed", list != null ? list.get(subject_2).getSubject_2_passed() : 0);
			resultMap.put("subject_2_used_day", subject_2_used_day);
			resultMap.put("subject_3_used_course", subject_3_used_course);
			resultMap.put("subject_3_passed", list != null ? list.get(subject_3).getSubject_3_passed() : 0);
			resultMap.put("subject_3_used_day", subject_3_used_day);
			return Response.status(200).entity(resultMap).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.SELECT_FAIL)).build();
		}
	}
}