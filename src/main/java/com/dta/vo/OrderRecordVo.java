package com.dta.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.ws.rs.QueryParam;

public class OrderRecordVo extends PageParam implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@QueryParam("order_id")
	private Integer order_id;
	@QueryParam("student_id")
	private Integer student_id;
	@QueryParam("coach_id")
	private Integer coach_id;
	@QueryParam("school_id")
	private Integer school_id;
	@QueryParam("order_time")
	private String order_time;
	@QueryParam("order_amount")
	private String order_amount;
	@QueryParam("order_status")
	private Integer order_status;
	@QueryParam("training_start_time")
	private Date training_start_time;
	@QueryParam("training_end_time")
	private Date training_end_time;
	@QueryParam("order_dead_time")
	private Date order_dead_time;
	@QueryParam("order_memo")
	private String order_memo;
	@QueryParam("validation")
	private Integer validation;
	@QueryParam("course_status")
	private Integer course_status;

	public String getOrder_time() {
		if (order_time != null && order_time != "")
			return order_time.substring(0, order_time.lastIndexOf('.'));
		return this.order_time;
	}

	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public Integer getOrder_id() {
		return order_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}

	public Integer getCoach_id() {
		return coach_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public Integer getSchool_id() {
		return school_id;
	}

	public void setOrder_amount(String order_amount) {
		this.order_amount = order_amount;
	}

	public String getOrder_amount() {
		return order_amount;
	}

	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}

	public Integer getOrder_status() {
		return order_status;
	}

	public void setTraining_start_time(Date training_start_time) {
		this.training_start_time = training_start_time;
	}

	public Date getTraining_start_time() {
		return training_start_time;
	}

	public void setTraining_end_time(Date training_end_time) {
		this.training_end_time = training_end_time;
	}

	public Date getTraining_end_time() {
		return training_end_time;
	}

	public void setOrder_dead_time(Date order_dead_time) {
		this.order_dead_time = order_dead_time;
	}

	public Date getOrder_dead_time() {
		return order_dead_time;
	}

	public void setOrder_memo(String order_memo) {
		this.order_memo = order_memo;
	}

	public String getOrder_memo() {
		return order_memo;
	}

	public void setValidation(Integer validation) {
		this.validation = validation;
	}

	public Integer getValidation() {
		return validation;
	}

	public void setCourse_status(Integer course_status) {
		this.course_status = course_status;
	}

	public Integer getCourse_status() {
		return course_status;
	}
}