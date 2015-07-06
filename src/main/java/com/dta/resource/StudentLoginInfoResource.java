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
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.dta.bean.ResultBean;
import com.dta.bean.StudentLoginInfo;
import com.dta.bean.StudentLoginSuccessInfo;
import com.dta.service.IStudentLoginInfoService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.StudentLoginInfoVo;

@Path("studentLoginInfo")
public class StudentLoginInfoResource extends BaseAllResource<StudentLoginInfo, StudentLoginInfoVo>{
	//@Autowired
	public IStudentLoginInfoService service = (IStudentLoginInfoService)ServiceProvider.getBean("studentLoginInfoServiceImpl");
	@Autowired
	public JdbcRealm myRealm;
	
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
			if(myRealm == null)
				System.out.println("myRealm is null");
			else
				System.out.println("myRealm is not null and getAuthenticationCacheName is " + myRealm.getAuthenticationCacheName());
			myRealm.setAuthenticationQuery("select login_pwd from student_login_info where login_name = ?");
			myRealm.setUserRolesQuery("select role_name from sys_role as R join user_roles as UR on R.role_id = UR.role_id join student_login_info as U on UR.user_id = U.student_id where UR.flag = 1 and user_name = ?");
			//myRealm.setPermissionsQuery("select permission_name from sys_permission as P join sys_role as R on P.role_id = R.role_id where role_name = ?");
			UsernamePasswordToken token = new UsernamePasswordToken();
			token.setPassword(password.toCharArray());
			token.setUsername(username);
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			System.out.println("JSESSIONID = " + subject.getSession().getId());
			StudentLoginSuccessInfo studentLoginSuccessInfo = service.getStudentLoginSuccessInfo(username);
			studentLoginSuccessInfo.setCode(Integer.valueOf(1));
			//return Response.status(200).entity(new ResultBean(1, subject.getPrincipal().toString())).build();
			return Response.status(200).entity(studentLoginSuccessInfo).build();
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