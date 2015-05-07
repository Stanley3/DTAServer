package com.dta.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class SysTotalIncome extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@FormParam("total_income_id")
	private Integer total_income_id;
	@FormParam("deposit_source")
	private Integer deposit_source;
	@FormParam("depositor")
	private Integer depositor;
	@FormParam("deposit_time")
	private Date deposit_time;
	@FormParam("amount")
	private String amount;
	@FormParam("operator_id")
	private Integer operator_id;
	public void setTotal_income_id(Integer total_income_id){
		this.total_income_id = total_income_id;
	}
	public Integer getTotal_income_id() {
		return total_income_id;
	}
	public void setDeposit_source(Integer deposit_source){
		this.deposit_source = deposit_source;
	}
	public Integer getDeposit_source() {
		return deposit_source;
	}
	public void setDepositor(Integer depositor){
		this.depositor = depositor;
	}
	public Integer getDepositor() {
		return depositor;
	}
	public void setDeposit_time(Date deposit_time){
		this.deposit_time = deposit_time;
	}
	public Date getDeposit_time() {
		return deposit_time;
	}
	public void setAmount(String amount){
		this.amount = amount;
	}
	public String getAmount() {
		return amount;
	}
	public void setOperator_id(Integer operator_id){
		this.operator_id = operator_id;
	}
	public Integer getOperator_id() {
		return operator_id;
	}
}