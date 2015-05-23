package com.dta.vo;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import com.dta.vo.PageParam;

public class SysTotalOutcomeVo extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@QueryParam("total_outcome_id")
	private Integer total_outcome_id;
	@QueryParam("payee_id")
	private Integer payee_id;
	@QueryParam("payee_type")
	private Integer payee_type;
	@QueryParam("amount")
	private String amount;
	@QueryParam("time")
	private String time;
	@QueryParam("validation")
	private Integer validation;
	public void setTotal_outcome_id(Integer total_outcome_id){
		this.total_outcome_id = total_outcome_id;
	}
	public Integer getTotal_outcome_id() {
		return total_outcome_id;
	}
	public void setPayee_id(Integer payee_id){
		this.payee_id = payee_id;
	}
	public Integer getPayee_id() {
		return payee_id;
	}
	public void setPayee_type(Integer payee_type){
		this.payee_type = payee_type;
	}
	public Integer getPayee_type() {
		return payee_type;
	}
	public void setAmount(String amount){
		this.amount = amount;
	}
	public String getAmount() {
		return amount;
	}
	public void setTime(String time){
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	public void setValidation(Integer validation){
		this.validation = validation;
	}
	public Integer getValidation() {
		return validation;
	}
}
