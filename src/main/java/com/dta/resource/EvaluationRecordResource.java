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



import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dta.bean.AllEvaluationRecord;
import com.dta.bean.CoachEvaluationInfo;
import com.dta.bean.EvaluationAndOrderInfo;
import com.dta.bean.EvaluationRecord;
import com.dta.bean.MapBean;
import com.dta.bean.ResultBean;
import com.dta.service.IEvaluationRecordService;
import com.dta.utils.GlobalConstant;
import com.dta.utils.ServiceProvider;
import com.dta.vo.AllEvaluationRecordVo;
import com.dta.vo.CoachEvaluationInfoVo;
import com.dta.vo.EvaluationRecordVo;

@Path("evaluationRecord")
public class EvaluationRecordResource extends BaseAllResource<EvaluationRecord, EvaluationRecordVo>{
	//@Autowired
	public IEvaluationRecordService service = (IEvaluationRecordService)ServiceProvider.getBean("evaluationRecordServiceImpl");
	public EvaluationRecordResource(){
		super.setService(service);
		super.setMianId(GlobalConstant.EVALUATIONRECORD);
	}
	
	/**
	 * 
	 * @param AllEvaluationRecordVo vo
	 * @return 
	 * <p>web界面显示某个订单的详细内容，参数是评价id
	 * <p>教练端教练查询自己的所有评价， 参数是教练id
	 */
	@GET
	@Path("getAllEvaluationRecord")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEvaRec(@BeanParam AllEvaluationRecordVo vo){
		try{
			if(vo.getRows() == -1)
				vo.setRows(0);
			int draw = vo.getDraw() == null ? 0 : vo.getDraw();
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
	
	@GET
	@Path("getEvaluationContent/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEvaAndOrdById(@PathParam("id") Integer evaluation_record_id){
		try{
			EvaluationAndOrderInfo info = service.getEvaAndOrdById(evaluation_record_id);
			if(info.getTraining_end_time() != null && info.getTraining_start_time() != null)
				info.setTrainingTime(info.getTraining_start_time() + "-" + info.getTraining_end_time().split(" ")[1]);
			return Response.status(200).entity(info).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, GlobalConstant.SELECT_FAIL)).build();
		}
	}
	
	@GET
	@Path("getCoachEvaluationInfo")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCoachEvaluationInfo(@BeanParam CoachEvaluationInfoVo vo){
		try{
			int size = service.getCoachEvaluationInfoSize(vo);
			int goodEvaluationSize = 0;
			int badEvaluationSize = 0;
			int midEvaluationSize = 0;
			List<CoachEvaluationInfo> resultList = new ArrayList<CoachEvaluationInfo>();
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap.put("total", size);
			if(size != 0){
				resultList = service.getCoachEvaluationInfo(vo);
				List<MapBean> mapBean = service.getEvaluationSize(vo);
				for(int i=0; i<mapBean.size(); ++i){
					switch(Integer.valueOf(mapBean.get(i).getKey())){
						case 0:
							badEvaluationSize = Integer.valueOf(mapBean.get(i).getValue());
							break;
						case 1:
							midEvaluationSize = Integer.valueOf(mapBean.get(i).getValue());
							break;
						case 2:
							goodEvaluationSize = Integer.valueOf(mapBean.get(i).getValue());
							break;						
					}
				}
			}
			resultMap.put("badEvaluationSize", badEvaluationSize);
			resultMap.put("midEvaluationSize", midEvaluationSize);
			resultMap.put("goodEvaluationSize", goodEvaluationSize);
			resultMap.put("data", resultList);
			return Response.status(200).entity(resultMap).build();
		}catch(Exception e){
			e.printStackTrace();
			return Response.status(500).entity(new ResultBean(GlobalConstant.OPERATION_EXCEPTION, 
					GlobalConstant.OPERATION_EXCEPTION_DESC)).build();
		}
	}
}