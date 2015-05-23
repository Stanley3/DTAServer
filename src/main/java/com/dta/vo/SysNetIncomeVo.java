package com.dta.vo;

import java.io.Serializable;
import java.sql.Date;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class SysNetIncomeVo extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@FormParam("net_income_id")
	private Integer net_income_id;
	@FormParam("net_income_source")
	private Integer net_income_source;
	@FormParam("amount")
	private String amount;
	@FormParam("time")
	private Date time;
	@FormParam("validation")
	private Integer validation;
	public void setNet_income_id(Integer net_income_id){
		this.net_income_id = net_income_id;
	}
	public Integer getNet_income_id() {
		return net_income_id;
	}
	public void setNet_income_source(Integer net_income_source){
		this.net_income_source = net_income_source;
	}
	public Integer getNet_income_source() {
		return net_income_source;
	}
	public void setAmount(String amount){
		this.amount = amount;
	}
	public String getAmount() {
		return amount;
	}
	public void setTime(Date time){
		this.time = time;
	}
	public Date getTime() {
		return time;
	}
	public void setValidation(Integer validation){
		this.validation = validation;
	}
	public Integer getValidation() {
		return validation;
	}
}
