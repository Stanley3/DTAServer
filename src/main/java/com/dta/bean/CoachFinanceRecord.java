package com.dta.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class CoachFinanceRecord extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@FormParam("finance_record_id")
	private Integer finance_record_id;
	@FormParam("coach_id")
	private Integer coach_id;
	@FormParam("income_amount")
	private String income_amount;
	@FormParam("payed_amount")
	private String payed_amount;
	@FormParam("record_time")
	private Date record_time;
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
	public void setIncome_amount(String income_amount){
		this.income_amount = income_amount;
	}
	public String getIncome_amount() {
		return income_amount;
	}
	public void setPayed_amount(String payed_amount){
		this.payed_amount = payed_amount;
	}
	public String getPayed_amount() {
		return payed_amount;
	}
	public void setRecord_time(Date record_time){
		this.record_time = record_time;
	}
	public Date getRecord_time() {
		return record_time;
	}
}
