package com.dta.vo;

import javax.ws.rs.QueryParam;

public class CoachIncomeRecordVo extends PageParam {
	@QueryParam("coach_id")
	private Integer coach_id;
	@QueryParam("order_status")
	private Integer order_status;

	public Integer getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}

	public Integer getOrder_status() {
		return order_status;
	}

	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}

}
