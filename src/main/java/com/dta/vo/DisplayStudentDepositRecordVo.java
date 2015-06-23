package com.dta.vo;

import javax.ws.rs.QueryParam;

public class DisplayStudentDepositRecordVo extends PageParam {
	@QueryParam("student_id")
	private Integer student_id;

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
}
