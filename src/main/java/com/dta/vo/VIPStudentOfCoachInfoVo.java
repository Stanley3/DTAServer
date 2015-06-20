package com.dta.vo;

import javax.ws.rs.QueryParam;

public class VIPStudentOfCoachInfoVo extends PageParam {
	@QueryParam("coach_id")
	private Integer coach_id;

	public Integer getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}
}
