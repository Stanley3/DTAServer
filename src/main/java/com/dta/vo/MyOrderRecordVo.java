package com.dta.vo;

import javax.ws.rs.QueryParam;

public class MyOrderRecordVo extends PageParam {
	@QueryParam("student_id")
	private Integer student_id;
	@QueryParam("option")
	private Integer option;// 1 表示已经预约 2 表示练习记录

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public Integer getOption() {
		return option;
	}

	public void setOption(Integer option) {
		this.option = option;
	}
}
