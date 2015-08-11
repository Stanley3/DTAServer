package com.dta.bean;

public class DisplayCoachScheduleInfo {
	private Integer coach_id;
	private Integer subject;
	private String content;
	private String student_toplimit;
	private String student_attribute;
	private String schedule_date;
	private String precontract_info; // 教练该天的预约信息
	private Integer isOnDuty;// 0 表示该天休息，不上班；1表示上班
	private String scheduleInfo;// 学员该天的预约信息,24个字符串，每个字符串的值代表该时间段已经被预约了多少次
	private Integer schedule_id;

	public Integer getSchedule_id() {
		return schedule_id;
	}

	public void setSchedule_id(Integer schedule_id) {
		this.schedule_id = schedule_id;
	}

	public String getPrecontract_info() {
		return precontract_info;
	}

	public void setPrecontract_info(String precontract_info) {
		this.precontract_info = precontract_info;
	}

	public Integer getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}

	public Integer getSubject() {
		return subject;
	}

	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStudent_toplimit() {
		return student_toplimit;
	}

	public void setStudent_toplimit(String student_toplimit) {
		this.student_toplimit = student_toplimit;
	}

	public String getStudent_attribute() {
		return student_attribute;
	}

	public void setStudent_attribute(String student_attribute) {
		this.student_attribute = student_attribute;
	}

	public String getSchedule_date() {
		return schedule_date;
	}

	public void setSchedule_date(String schedule_date) {
		this.schedule_date = schedule_date;
	}

	public Integer getIsOnDuty() {
		return isOnDuty;
	}

	public void setIsOnDuty(Integer isOnDuty) {
		this.isOnDuty = isOnDuty;
	}

	public String getScheduleInfo() {
		return scheduleInfo;
	}

	public void setScheduleInfo(String scheduleInfo) {
		this.scheduleInfo = scheduleInfo;
	}
}
