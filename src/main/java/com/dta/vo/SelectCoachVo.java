package com.dta.vo;

import javax.ws.rs.QueryParam;

public class SelectCoachVo extends PageParam {
	@QueryParam("school_id")
	private Integer school_id;
	@QueryParam("subject")
	private Integer subject;//科目
	
	public Integer getSchool_id() {
		return school_id;
	}
	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}
	public Integer getSubject() {
		return subject;
	}
	public void setSubject(Integer subject) {
		this.subject = subject;
	}
}
