package com.dta.resource;

import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;


import com.dta.bean.EvaluationRecord;
import com.dta.service.IEvaluationRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;

@Path("evaluationRecord")
public class EvaluationRecordResource extends BaseAllResource<EvaluationRecord, EvaluationRecord>{
	//@Autowired
	public IEvaluationRecordService service = (IEvaluationRecordService)ServiceProvider.getBean("evaluationRecordServiceImpl");
	public EvaluationRecordResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.EVALUATIONRECORD);
	}
}