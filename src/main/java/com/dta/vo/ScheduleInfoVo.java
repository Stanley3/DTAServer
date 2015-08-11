package com.dta.vo;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import com.dta.vo.PageParam;

public class ScheduleInfoVo extends PageParam implements Serializable {
	private static final long serialVersionUID = 1L;
	@QueryParam("schedule_id")
	private Integer schedule_id;
	@QueryParam("coach_id")
	private Integer coach_id;
	@QueryParam("operator_id")
	private Integer operator_id;
	@QueryParam("operate_time")
	private String operate_time;
	@QueryParam("subject")
	private Integer subject;
	@QueryParam("content")
	private String content;
	@QueryParam("student_toplimit")
	private String student_toplimit;
	@QueryParam("student_attribute")
	private String student_attribute;
	@QueryParam("start_schedule_date")
	private String startScheduleDate;
	@QueryParam("end_schedule_date")
	private String endScheduleDate;
	@QueryParam("device_attribude")
	private Integer device_attribude;
	@QueryParam("validation")
	private Integer validation;

	public void setSchedule_id(Integer schedule_id) {
		this.schedule_id = schedule_id;
	}

	public Integer getSchedule_id() {
		return schedule_id;
	}

	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}

	public Integer getCoach_id() {
		return coach_id;
	}

	public void setOperator_id(Integer operator_id) {
		this.operator_id = operator_id;
	}

	public Integer getOperator_id() {
		return operator_id;
	}

	public void setOperate_time(String operate_time) {
		this.operate_time = operate_time;
	}

	public String getOperate_time() {
		return operate_time;
	}

	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	public Integer getSubject() {
		return subject;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setStudent_toplimit(String student_toplimit) {
		this.student_toplimit = student_toplimit;
	}

	public String getStudent_toplimit() {
		return student_toplimit;
	}

	public void setStudent_attribute(String student_attribute) {
		this.student_attribute = student_attribute;
	}

	public String getStudent_attribute() {
		return student_attribute;
	}

	public String getStartScheduleDate() {
		return startScheduleDate;
	}

	public void setStartScheduleDate(String startScheduleDate) {
		this.startScheduleDate = startScheduleDate;
	}

	public String getEndScheduleDate() {
		return endScheduleDate;
	}

	public void setEndScheduleDate(String endScheduleDate) {
		this.endScheduleDate = endScheduleDate;
	}

	public void setDevice_attribude(Integer device_attribude) {
		this.device_attribude = device_attribude;
	}

	public Integer getDevice_attribude() {
		return device_attribude;
	}

	public void setValidation(Integer validation) {
		this.validation = validation;
	}

	public Integer getValidation() {
		return validation;
	}
}
