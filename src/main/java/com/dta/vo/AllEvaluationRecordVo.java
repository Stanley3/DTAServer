package com.dta.vo;

import javax.ws.rs.QueryParam;

/**
 * 
 * @author gujh
 * 查询所有评价用到的vo文件
 */
public class AllEvaluationRecordVo extends PageParam {
	@QueryParam("evaluation")
	private Integer evaluation ;
	@QueryParam("evaluation_type")
	private Integer evaluation_type;
	private Integer order_id;
	private Integer student_id;
	private Integer coach_id;
	private Integer evaluation_record_id;
	private Integer school_id;
	@QueryParam("search")
	private String search;
	private String evaluation_time;
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getEvaluation_time() {
		return evaluation_time;
	}
	public void setEvaluation_time(String evaluation_time) {
		this.evaluation_time = evaluation_time;
	}
	public Integer getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}
	public Integer getEvaluation_type() {
		return evaluation_type;
	}
	public void setEvaluation_type(Integer evaluation_type) {
		this.evaluation_type = evaluation_type;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public Integer getCoach_id() {
		return coach_id;
	}
	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}
	public Integer getEvaluation_record_id() {
		return evaluation_record_id;
	}
	public void setEvaluation_record_id(Integer evaluation_record_id) {
		this.evaluation_record_id = evaluation_record_id;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

}
