package com.dta.resource;

import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
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
import org.springframework.util.FileCopyUtils;

import com.dta.bean.CoachBasicInfo;
import com.dta.bean.ResultBean;
import com.dta.service.ICoachBasicInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.esotericsoftware.reflectasm.MethodAccess;

@Path("coachBasicInfo")
public class CoachBasicInfoResource extends
		BaseAllResource<CoachBasicInfo, CoachBasicInfo> {
	private ICoachBasicInfoService service = (ICoachBasicInfoService) ServiceProvider
			.getBean("coachBasicInfoServiceImpl");

	public CoachBasicInfoResource() {
		super.setService(service);
		super.setMianId(GlobalConstant.COACHBASICINFO);
	}

	@POST
	@Path("addWithPhoto")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addWithPhoto() {
		HttpServletRequest request = super.getRequest();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
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
				while (iterator.hasNext()) {
					FileItemStream item = iterator.next();
					String name = item.getFieldName();
					InputStream stream = item.openStream();
					if (item.isFormField()) {
						MethodAccess access = MethodAccess
								.get(CoachBasicInfo.class);
						access.invoke(po, generateMethodName("set", name),
								Streams.asString(stream));
					} else {
						po.setPhoto(FileCopyUtils.copyToByteArray(stream));
					}
				}
				if (service.addObject(po) == 1)
					return Response
							.status(200)
							.entity(new ResultBean(
									GlobalConstant.OPERATION_SUCCESS,
									GlobalConstant.INSERT_SUCCESS)).build();
				else {
					return Response
							.status(200)
							.entity(new ResultBean(
									GlobalConstant.OPERATION_FAIL,
									GlobalConstant.INSERT_FAIL)).build();
				}
			} catch (Exception e) {
				e.printStackTrace();
				return Response
						.status(500)
						.entity(new ResultBean(
								GlobalConstant.OPERATION_EXCEPTION,
								GlobalConstant.OPERATION_EXCEPTION_DESC))
						.build();
			}
		}
	}

	@GET
	@Path("downloadPhoto")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response download(@QueryParam("id") int id) {
		HttpServletResponse response = super.getResponse();
		CoachBasicInfo po = service.downloadPhoto(id);
		if (po.getPhoto() != null) {
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
	@Produces(MediaType.APPLICATION_JSON)
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
						MethodAccess access = MethodAccess
								.get(CoachBasicInfo.class);
						access.invoke(po, generateMethodName("set", name),
								Streams.asString(stream));
					} else {
						po.setPhoto(FileCopyUtils.copyToByteArray(stream));
					}
				}
				if (service.updateObjectById(po) == 1)
					return Response
							.status(200)
							.entity(new ResultBean(
									GlobalConstant.OPERATION_SUCCESS,
									GlobalConstant.UPDATE_SUCCESS)).build();
				else {
					return Response
							.status(200)
							.entity(new ResultBean(
									GlobalConstant.OPERATION_FAIL,
									GlobalConstant.UPDATE_FAIL)).build();
				}
			} catch (Exception e) {
				e.printStackTrace();
				return Response
						.status(500)
						.entity(new ResultBean(
								GlobalConstant.OPERATION_EXCEPTION,
								GlobalConstant.OPERATION_EXCEPTION_DESC))
						.build();
			}
		}
	}
}