package com.dta.vo;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import com.dta.vo.PageParam;

public class EvaluationRecordVo extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@QueryParam("evaluation_record_id")
	private Integer evaluation_record_id;
	@QueryParam("student_id")
	private Integer student_id;
	@QueryParam("coach_id")
	private Integer coach_id;
	@QueryParam("order_id")
	private Integer order_id;
	@QueryParam("content")
	private String content;
	@QueryParam("skill")
	private Integer skill;
	@QueryParam("service_attitude")
	private Integer service_attitude;
	@QueryParam("hygiene")
	private Integer hygiene;
	@QueryParam("evaluation_time")
	private String evaluation_time;
	@QueryParam("evalution_type")
	private Integer evalution_type;
	@QueryParam("validation")
	private Integer validation;
	public void setEvaluation_record_id(Integer evaluation_record_id){
		this.evaluation_record_id = evaluation_record_id;
	}
	public Integer getEvaluation_record_id() {
		return evaluation_record_id;
	}
	public void setStudent_id(Integer student_id){
		this.student_id = student_id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setCoach_id(Integer coach_id){
		this.coach_id = coach_id;
	}
	public Integer getCoach_id() {
		return coach_id;
	}
	public void setOrder_id(Integer order_id){
		this.order_id = order_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setSkill(Integer skill){
		this.skill = skill;
	}
	public Integer getSkill() {
		return skill;
	}
	public void setService_attitude(Integer service_attitude){
		this.service_attitude = service_attitude;
	}
	public Integer getService_attitude() {
		return service_attitude;
	}
	public void setHygiene(Integer hygiene){
		this.hygiene = hygiene;
	}
	public Integer getHygiene() {
		return hygiene;
	}
	public void setEvaluation_time(String evaluation_time){
		this.evaluation_time = evaluation_time;
	}
	public String getEvaluation_time() {
		return evaluation_time;
	}
	public void setEvalution_type(Integer evalution_type){
		this.evalution_type = evalution_type;
	}
	public Integer getEvalution_type() {
		return evalution_type;
	}
	public void setValidation(Integer validation){
		this.validation = validation;
	}
	public Integer getValidation() {
		return validation;
	}
}
