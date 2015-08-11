package com.dta.vo;

import java.sql.Date;

import javax.ws.rs.QueryParam;

/*
 * 学员训练记录
 */
public class TrainingRecordVo extends PageParam {
	private Integer order_id;
	@QueryParam("student_id")
	private Integer student_id;
	private Integer coach_id;
	private Integer school_id;
	@QueryParam("order_time")
	private Date order_time;
	@QueryParam("order_amount")
	private String order_amount;
	private Integer order_status;
	@QueryParam("training_date")
	private String training_date;
	private String order_dead_time;
	private String order_memo;
	private Integer validation;
	private Integer course_status;
	@QueryParam("coach_name")
	private String coach_name;
	private String phone;
	private String school_address;

	public String getTraining_date() {
		return training_date;
	}

	public void setTraining_date(String training_date) {
		this.training_date = training_date;
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

	public void setOrder_time(Date order_time) {
		this.order_time = order_time;
	}

	public Date getOrder_time() {
		return order_time;
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

	public String getOrder_dead_time() {
		if (order_dead_time != null)
			return order_dead_time.substring(0,
					order_dead_time.lastIndexOf('.'));
		return null;
	}

	public void setOrder_dead_time(String order_dead_time) {
		this.order_dead_time = order_dead_time;
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

	public String getCoach_name() {
		return coach_name;
	}

	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSchool_address() {
		return school_address;
	}

	public void setSchool_address(String school_address) {
		this.school_address = school_address;
	}
}
