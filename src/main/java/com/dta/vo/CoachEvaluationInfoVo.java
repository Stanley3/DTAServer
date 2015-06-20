package com.dta.vo;

import javax.ws.rs.QueryParam;

/**
 * 
 * @author gujh
 * <p>App教练端请求我的评价信息时查询参数映射到的bean文件
 */
public class CoachEvaluationInfoVo extends PageParam {
	@QueryParam("coach_id")
	private Integer coach_id;
	@QueryParam("evaluation")//评价
	private Integer evaluation;
	
	public Integer getCoach_id() {
		return coach_id;
	}
	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}
	public Integer getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}
}
