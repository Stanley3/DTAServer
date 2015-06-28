package com.dta.resource;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;



import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.dta.bean.ResultBean;
import com.dta.bean.StudentLoginInfo;
import com.dta.service.IStudentLoginInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.StudentLoginInfoVo;

@Path("studentLoginInfo")
public class StudentLoginInfoResource extends BaseAllResource<StudentLoginInfo, StudentLoginInfoVo>{
	//@Autowired
	public IStudentLoginInfoService service = (IStudentLoginInfoService)ServiceProvider.getBean("studentLoginInfoServiceImpl");
	public StudentLoginInfoResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.STUDENTLOGININFO);
	}
	
	@POST
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(@FormParam("username")String username, 
							@FormParam("password")String password,
							@FormParam("source")String source){
		try{
			UsernamePasswordToken token = new UsernamePasswordToken();
			token.setPassword(password.toCharArray());
			token.setUsername(username);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			return Response.status(200).entity(new ResultBean(1, subject.getPrincipal().toString())).build();
		}catch(AuthenticationException ae){
			return Response.status(200).entity(new ResultBean(2, "wrong username or password")).build();
		}
		catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
		
	}
}