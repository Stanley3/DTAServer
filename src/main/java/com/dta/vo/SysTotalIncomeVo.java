package com.dta.vo;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import com.dta.vo.PageParam;

public class SysTotalIncomeVo extends PageParam implements Serializable {
	private static final long serialVersionUID = 1L;
	@QueryParam("total_income_id")
	private Integer total_income_id;
	@QueryParam("deposit_source")
	private Integer deposit_source;
	@QueryParam("depositor")
	private Integer depositor;
	@QueryParam("deposit_time")
	private String deposit_time;
	@QueryParam("amount")
	private String amount;
	@QueryParam("operator_id")
	private Integer operator_id;
	@QueryParam("validation")
	private Integer validation;

	public void setTotal_income_id(Integer total_income_id) {
		this.total_income_id = total_income_id;
	}

	public Integer getTotal_income_id() {
		return total_income_id;
	}

	public void setDeposit_source(Integer deposit_source) {
		this.deposit_source = deposit_source;
	}

	public Integer getDeposit_source() {
		return deposit_source;
	}

	public void setDepositor(Integer depositor) {
		this.depositor = depositor;
	}

	public Integer getDepositor() {
		return depositor;
	}

	public void setDeposit_time(String deposit_time) {
		this.deposit_time = deposit_time;
	}

	public String getDeposit_time() {
		return deposit_time;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getAmount() {
		return amount;
	}

	public void setOperator_id(Integer operator_id) {
		this.operator_id = operator_id;
	}

	public Integer getOperator_id() {
		return operator_id;
	}

	public void setValidation(Integer validation) {
		this.validation = validation;
	}

	public Integer getValidation() {
		return validation;
	}
}
