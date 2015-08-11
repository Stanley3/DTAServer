package com.dta.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class CoachWithdrawRecord extends PageParam implements Serializable {
	private static final long serialVersionUID = 1L;
	@FormParam("withdraw_reocrd_id")
	private Integer withdraw_reocrd_id;
	@FormParam("coach_id")
	private Integer coach_id;
	@FormParam("withdraw_time")
	private Date withdraw_time;
	@FormParam("withdraw_amount")
	private String withdraw_amount;
	@FormParam("drawee")
	private Integer drawee;
	@FormParam("withdraw_status")
	private Integer withdraw_status;
	@FormParam("validation")
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

	public void setWithdraw_time(Date withdraw_time) {
		this.withdraw_time = withdraw_time;
	}

	public Date getWithdraw_time() {
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
