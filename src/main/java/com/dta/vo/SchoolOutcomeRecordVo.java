package com.dta.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class SchoolOutcomeRecordVo extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@FormParam("outcome_record_id")
	private Integer outcome_record_id;
	@FormParam("school_id")
	private Integer school_id;
	@FormParam("operator")
	private Integer operator;
	@FormParam("payee")
	private Integer payee;
	@FormParam("operate_time")
	private Date operate_time;
	@FormParam("amount")
	private String amount;
	@FormParam("arrival")
	private Integer arrival;
	@FormParam("account_type")
	private Integer account_type;
	@FormParam("account")
	private String account;
	@FormParam("validation")
	private Integer validation;
	public void setOutcome_record_id(Integer outcome_record_id){
		this.outcome_record_id = outcome_record_id;
	}
	public Integer getOutcome_record_id() {
		return outcome_record_id;
	}
	public void setSchool_id(Integer school_id){
		this.school_id = school_id;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setOperator(Integer operator){
		this.operator = operator;
	}
	public Integer getOperator() {
		return operator;
	}
	public void setPayee(Integer payee){
		this.payee = payee;
	}
	public Integer getPayee() {
		return payee;
	}
	public void setOperate_time(Date operate_time){
		this.operate_time = operate_time;
	}
	public Date getOperate_time() {
		return operate_time;
	}
	public void setAmount(String amount){
		this.amount = amount;
	}
	public String getAmount() {
		return amount;
	}
	public void setArrival(Integer arrival){
		this.arrival = arrival;
	}
	public Integer getArrival() {
		return arrival;
	}
	public void setAccount_type(Integer account_type){
		this.account_type = account_type;
	}
	public Integer getAccount_type() {
		return account_type;
	}
	public void setAccount(String account){
		this.account = account;
	}
	public String getAccount() {
		return account;
	}
	public void setValidation(Integer validation){
		this.validation = validation;
	}
	public Integer getValidation() {
		return validation;
	}
}
