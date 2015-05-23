package com.dta.vo;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import com.dta.vo.PageParam;

public class CoachFinanceRecordVo extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@QueryParam("finance_record_id")
	private Integer finance_record_id;
	@QueryParam("coach_id")
	private Integer coach_id;
	@QueryParam("income_amount")
	private String income_amount;
	@QueryParam("payed_amount")
	private String payed_amount;
	@QueryParam("record_time")
	private String record_time;
	@QueryParam("validation")
	private Integer validation;
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
	public void setRecord_time(String record_time){
		this.record_time = record_time;
	}
	public String getRecord_time() {
		return record_time;
	}
	public void setValidation(Integer validation){
		this.validation = validation;
	}
	public Integer getValidation() {
		return validation;
	}
}
