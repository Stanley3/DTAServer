package com.dta.vo;

import javax.ws.rs.QueryParam;

public class OrderInfoVo extends PageParam {
	private Integer order_id;
	private Integer student_id;
	private Integer coach_id;
	private String training_start_time;
	private String training_end_time;
	private String tainingTime;
	@QueryParam("order_status")
	private Integer order_status;
	
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
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
	public String getTainingTime() {
		return tainingTime;
	}
	public void setTainingTime(String tainingTime) {
		this.tainingTime = tainingTime;
	}
}
