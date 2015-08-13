package com.dta.vo;

import javax.ws.rs.QueryParam;

public class ShowDepositRecordVo extends PageParam {
	private String deposit_date;
	@QueryParam("school_id")
	private Integer school_id;
	
	public Integer getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public String getDeposit_date() {
		return deposit_date;
	}

	public void setDeposit_date(String deposit_date) {
		this.deposit_date = deposit_date;
	}

}
