package com.dta.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class StudentSignupInfo extends PageParam implements Serializable {
	private static final long serialVersionUID = 1L;
	@FormParam("signup_id")
	private Integer signup_id;
	@FormParam("student_id")
	private Integer student_id;
	@FormParam("singup_driving_school")
	private Integer singup_driving_school;
	@FormParam("chartered_driving_school")
	private Integer chartered_driving_school;
	@FormParam("chartered_coach_2")
	private Integer chartered_coach_2;
	@FormParam("chartered_coach_3")
	private Integer chartered_coach_3;
	@FormParam("course_status")
	private Integer course_status;
	@FormParam("signup_time")
	private Date signup_time;
	@FormParam("validation")
	private Integer validation;

	public void setSignup_id(Integer signup_id) {
		this.signup_id = signup_id;
	}

	public Integer getSignup_id() {
		return signup_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setSingup_driving_school(Integer singup_driving_school) {
		this.singup_driving_school = singup_driving_school;
	}

	public Integer getSingup_driving_school() {
		return singup_driving_school;
	}

	public void setChartered_driving_school(Integer chartered_driving_school) {
		this.chartered_driving_school = chartered_driving_school;
	}

	public Integer getChartered_driving_school() {
		return chartered_driving_school;
	}

	public void setChartered_coach_2(Integer chartered_coach_2) {
		this.chartered_coach_2 = chartered_coach_2;
	}

	public Integer getChartered_coach_2() {
		return chartered_coach_2;
	}

	public void setChartered_coach_3(Integer chartered_coach_3) {
		this.chartered_coach_3 = chartered_coach_3;
	}

	public Integer getChartered_coach_3() {
		return chartered_coach_3;
	}

	public void setCourse_status(Integer course_status) {
		this.course_status = course_status;
	}

	public Integer getCourse_status() {
		return course_status;
	}

	public void setSignup_time(Date signup_time) {
		this.signup_time = signup_time;
	}

	public Date getSignup_time() {
		return signup_time;
	}

	public void setValidation(Integer validation) {
		this.validation = validation;
	}

	public Integer getValidation() {
		return validation;
	}
}
