package com.dta.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class CoachFinanceRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	@FormParam("finance_record_id")
	private Integer finance_record_id;
	@FormParam("coach_id")
	private Integer coach_id;
	@FormParam("income_amount")
	private Double income_amount;
	@FormParam("payed_amount")
	private Double payed_amount;
	@FormParam("record_time")
	private Date record_time;
	@FormParam("validation")
	private Integer validation;
	private Double order_amount;
	
	public Double getOrder_amount() {
		return order_amount;
	}
	public void setOrder_amount(Double order_amount) {
		this.order_amount = order_amount;
	}
	public void setFinance_record_id(Integer finance_record_id){
		this.finance_record_id = finance_record_id;
	}
	public Integer getFinance_record_id() {
		return finance_record_id;
	}
	public void setCoach_id(Integer coach_id){
		this.coach_id = coach_id;
	}
	public Integer getCoach_id() {
		return coach_id;
	}
	
	public Double getIncome_amount() {
		return income_amount;
	}
	public void setIncome_amount(Double income_amount) {
		this.income_amount = income_amount;
	}

	public Double getPayed_amount() {
		return payed_amount;
	}
	public void setPayed_amount(Double payed_amount) {
		this.payed_amount = payed_amount;
	}
	public void setRecord_time(Date record_time){
		this.record_time = record_time;
	}
	public Date getRecord_time() {
		return record_time;
	}
	public void setValidation(Integer validation){
		this.validation = validation;
	}
	public Integer getValidation() {
		return validation;
	}
}
