package com.dta.vo;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import com.dta.vo.PageParam;

public class SchoolFinanceVo extends PageParam implements Serializable {
	private static final long serialVersionUID = 1L;
	@QueryParam("school_income_id")
	private Integer school_income_id;
	@QueryParam("school_id")
	private Integer school_id;
	@QueryParam("imprest")
	private String imprest;
	@QueryParam("gross_charge")
	private String gross_charge;
	@QueryParam("frozen_amount")
	private String frozen_amount;
	@QueryParam("gross_income")
	private String gross_income;
	@QueryParam("validation")
	private Integer validation;

	public void setSchool_income_id(Integer school_income_id) {
		this.school_income_id = school_income_id;
	}

	public Integer getSchool_income_id() {
		return school_income_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public Integer getSchool_id() {
		return school_id;
	}

	public void setImprest(String imprest) {
		this.imprest = imprest;
	}

	public String getImprest() {
		return imprest;
	}

	public void setGross_charge(String gross_charge) {
		this.gross_charge = gross_charge;
	}

	public String getGross_charge() {
		return gross_charge;
	}

	public void setFrozen_amount(String frozen_amount) {
		this.frozen_amount = frozen_amount;
	}

	public String getFrozen_amount() {
		return frozen_amount;
	}

	public void setGross_income(String gross_income) {
		this.gross_income = gross_income;
	}

	public String getGross_income() {
		return gross_income;
	}

	public void setValidation(Integer validation) {
		this.validation = validation;
	}

	public Integer getValidation() {
		return validation;
	}
}
