package com.dta.vo;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import com.dta.vo.PageParam;

public class SchoolOutcomeRecordVo extends PageParam implements Serializable {
	private static final long serialVersionUID = 1L;
	@QueryParam("outcome_record_id")
	private Integer outcome_record_id;
	@QueryParam("school_id")
	private Integer school_id;
	@QueryParam("operator")
	private Integer operator;
	@QueryParam("payee")
	private Integer payee;
	@QueryParam("operate_time")
	private String operate_time;
	@QueryParam("amount")
	private String amount;
	@QueryParam("arrival")
	private Integer arrival;
	@QueryParam("account_type")
	private Integer account_type;
	@QueryParam("account")
	private String account;
	@QueryParam("validation")
	private Integer validation;

	public void setOutcome_record_id(Integer outcome_record_id) {
		this.outcome_record_id = outcome_record_id;
	}

	public Integer getOutcome_record_id() {
		return outcome_record_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public Integer getSchool_id() {
		return school_id;
	}

	public void setOperator(Integer operator) {
		this.operator = operator;
	}

	public Integer getOperator() {
		return operator;
	}

	public void setPayee(Integer payee) {
		this.payee = payee;
	}

	public Integer getPayee() {
		return payee;
	}

	public void setOperate_time(String operate_time) {
		this.operate_time = operate_time;
	}

	public String getOperate_time() {
		return operate_time;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmount() {
		return amount;
	}

	public void setArrival(Integer arrival) {
		this.arrival = arrival;
	}

	public Integer getArrival() {
		return arrival;
	}

	public void setAccount_type(Integer account_type) {
		this.account_type = account_type;
	}

	public Integer getAccount_type() {
		return account_type;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccount() {
		return account;
	}

	public void setValidation(Integer validation) {
		this.validation = validation;
	}

	public Integer getValidation() {
		return validation;
	}
}
