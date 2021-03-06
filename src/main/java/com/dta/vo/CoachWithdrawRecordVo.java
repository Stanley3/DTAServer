package com.dta.vo;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import com.dta.vo.PageParam;

public class CoachWithdrawRecordVo extends PageParam implements Serializable {
	private static final long serialVersionUID = 1L;
	@QueryParam("withdraw_reocrd_id")
	private Integer withdraw_reocrd_id;
	@QueryParam("coach_id")
	private Integer coach_id;
	@QueryParam("withdraw_time")
	private String withdraw_time;
	@QueryParam("withdraw_amount")
	private String withdraw_amount;
	@QueryParam("drawee")
	private Integer drawee;
	@QueryParam("withdraw_status")
	private Integer withdraw_status;
	@QueryParam("validation")
	private Integer validation;

	public void setWithdraw_reocrd_id(Integer withdraw_reocrd_id) {
		this.withdraw_reocrd_id = withdraw_reocrd_id;
	}

	public Integer getWithdraw_reocrd_id() {
		return withdraw_reocrd_id;
	}

	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}

	public Integer getCoach_id() {
		return coach_id;
	}

	public void setWithdraw_time(String withdraw_time) {
		this.withdraw_time = withdraw_time;
	}

	public String getWithdraw_time() {
		return withdraw_time;
	}

	public void setWithdraw_amount(String withdraw_amount) {
		this.withdraw_amount = withdraw_amount;
	}

	public String getWithdraw_amount() {
		return withdraw_amount;
	}

	public void setDrawee(Integer drawee) {
		this.drawee = drawee;
	}

	public Integer getDrawee() {
		return drawee;
	}

	public void setWithdraw_status(Integer withdraw_status) {
		this.withdraw_status = withdraw_status;
	}

	public Integer getWithdraw_status() {
		return withdraw_status;
	}

	public void setValidation(Integer validation) {
		this.validation = validation;
	}

	public Integer getValidation() {
		return validation;
	}
}
