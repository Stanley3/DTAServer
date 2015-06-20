package com.dta.vo;

import javax.ws.rs.QueryParam;

public class CoachPrecontractRecordVo extends PageParam {
	@QueryParam("student_name")
	private String student_name;
	@QueryParam("student_phone")
	private String student_phone;
	@QueryParam("student_id")
	private Integer student_id;
	@QueryParam("status")
	private Integer status;
	@QueryParam("coach_id")
	private Integer coach_id;
	@QueryParam("order_id")
	private Integer order_id;
	@QueryParam("school_id")
	private Integer school_id;
	@QueryParam("course_status")
	private Integer course_status;
	@QueryParam("order_time")
	private String order_time;
	@QueryParam("training_start_time")
	private String training_start_time;
	@QueryParam("training_end_time")
	private String training_end_time;
	@QueryParam("order_status")
	private String order_status;
	@QueryParam("lastQueryTime")
	private String lastQueryTime; //记录上次查询记录的时间
	
	
	public String getLastQueryTime() {
		return lastQueryTime;
	}
	public void setLastQueryTime(String lastQueryTime) {
		this.lastQueryTime = lastQueryTime;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCoach_id() {
		return coach_id;
	}
	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}
	public Integer getCourse_status() {
		return course_status;
	}
	public void setCourse_status(Integer course_status) {
		this.course_status = course_status;
	}
	public String getOrder_time() {
		return order_time;
	}
	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}
	public String getTraining_start_time() {
		return training_start_time;
	}
	public void setTraining_start_time(String training_start_time) {
		this.training_start_time = training_start_time;
	}
	public String getTraining_end_time() {
		return training_end_time;
	}
	public void setTraining_end_time(String training_end_time) {
		this.training_end_time = training_end_time;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getStudent_phone() {
		return student_phone;
	}
	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}
	
}
