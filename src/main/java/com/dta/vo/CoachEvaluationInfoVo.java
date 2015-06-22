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
	@QueryParam("course_status")
	private Integer course_status;
	
	public Integer getCourse_status() {
		return course_status;
	}
	public void setCourse_status(Integer course_status) {
		this.course_status = course_status;
	}
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
