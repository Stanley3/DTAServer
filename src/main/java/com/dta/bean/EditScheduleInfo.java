package com.dta.bean;

import javax.ws.rs.FormParam;

public class EditScheduleInfo {
	@FormParam("schedule_id")
	private Integer schedule_id;
	@FormParam("content")
	private String content;
	@FormParam("student_attribute")
	private String student_attribute;
	@FormParam("student_toplimit")
	private String student_toplimit;
	@FormParam("subject")
	private Integer subject;
	@FormParam("device_attribute")
	private Integer device_attribute;
	@FormParam("device_type")
	private Integer device_type;
	private Integer remnant_device_numbers;
	private Integer isOnDuly;

	public Integer getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(Integer schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStudent_attribute() {
		return student_attribute;
	}

	public void setStudent_attribute(String student_attribute) {
		this.student_attribute = student_attribute;
	}

	public String getStudent_toplimit() {
		return student_toplimit;
	}

	public void setStudent_toplimit(String student_toplimit) {
		this.student_toplimit = student_toplimit;
	}

	public Integer getSubject() {
		return subject;
	}

	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	public Integer getDevice_attribute() {
		return device_attribute;
	}

	public void setDevice_attribute(Integer device_attribute) {
		this.device_attribute = device_attribute;
	}

	public Integer getDevice_type() {
		return device_type;
	}

	public void setDevice_type(Integer device_type) {
		this.device_type = device_type;
	}

	public Integer getRemnant_device_numbers() {
		return remnant_device_numbers;
	}

	public void setRemnant_device_numbers(Integer remnant_device_numbers) {
		this.remnant_device_numbers = remnant_device_numbers;
	}

	public Integer getIsOnDuly() {
		return isOnDuly;
	}

	public void setIsOnDuly(Integer isOnDuly) {
		this.isOnDuly = isOnDuly;
	}
}
