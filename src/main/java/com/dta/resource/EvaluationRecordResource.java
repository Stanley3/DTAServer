package com.dta.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

//import org.springframework.beans.factory.annotation.Autowired;



import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dta.bean.AllEvaluationRecord;
import com.dta.bean.EvaluationRecord;
import com.dta.bean.ResultBean;
import com.dta.service.IEvaluationRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.AllEvaluationRecordVo;
import com.dta.vo.EvaluationRecordVo;

@Path("evaluationRecord")
public class EvaluationRecordResource extends BaseAllResource<EvaluationRecord, EvaluationRecordVo>{
	//@Autowired
	public IEvaluationRecordService service = (IEvaluationRecordService)ServiceProvider.getBean("evaluationRecordServiceImpl");
	public EvaluationRecordResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.EVALUATIONRECORD);
	}
	
	@GET
	@Path("getAllEvaluationRecord")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEvaRec(@BeanParam AllEvaluationRecordVo vo){
		try{
			if(vo.getRows() == -1)
				vo.setRows(0);
			int draw = vo.getDraw();
			int size = 0;
			List<AllEvaluationRecord> resultList = new ArrayList<AllEvaluationRecord>();
			Map<String, Object> resultMap = new HashMap<String, Object>();
			if(vo.getSearch() != null && !vo.getSearch().isEmpty()){
				Pattern pattern = Pattern.compile("^\\d+$");
				Matcher matcher = pattern.matcher(vo.getSearch());
				if(matcher.matches())
					vo.setEvaluation_time(vo.getSearch());
				size = service.globalSearchSize(vo);
				if(size != 0)
					resultList = service.globalSearch(vo);
				resultMap.put("recordsTotal", service.getAllEvaRecSize(vo));
			}
			else{
				size = service.getAllEvaRecSize(vo);
				if(size != 0)
					resultList = service.getAllEvaRec(vo);
				resultMap.put("recordsTotal", size);
			}
			resultMap.put("draw", draw);
			resultMap.put("recordsFiltered", size);
			if(size != 0)
				resultList= service.getAllEvaRec(vo);
			resultMap.put("data", resultList);
			return Response.status(200).entity(resultMap).build();
			
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, GlobalConstant.SELECT_FAIL)).build();
		}
	}
}