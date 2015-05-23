package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;



import com.dta.bean.StudentDepositRecord;
import com.dta.service.IStudentDepositRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.StudentDepositRecordVo;

@Path("studentDepositRecord")
public class StudentDepositRecordResource extends BaseAllResource<StudentDepositRecord, StudentDepositRecordVo>{
	//@Autowired
	public IStudentDepositRecordService service = (IStudentDepositRecordService)ServiceProvider.getBean("studentDepositRecordServiceImpl");
	public StudentDepositRecordResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.STUDENTDEPOSITRECORD);
	}
}