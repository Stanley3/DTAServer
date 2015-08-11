package com.dta.bean;

import javax.ws.rs.FormParam;

public class StudentFinanceInfo {
	@FormParam("student_finance_id")
	private Integer student_finance_id;
	@FormParam("student_id")
	private Integer student_id;
	@FormParam("student_finance_amount")
	private Double student_finance_amount;
	@FormParam("student_account_balance")
	private Double student_account_balance;

	public Integer getStudent_finance_id() {
		return student_finance_id;
	}

	public void setStudent_finance_id(Integer student_finance_id) {
		this.student_finance_id = student_finance_id;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public Double getStudent_finance_amount() {
		return student_finance_amount;
	}

	public void setStudent_finance_amount(Double student_finance_amount) {
		this.student_finance_amount = student_finance_amount;
	}

	public Double getStudent_account_balance() {
		return student_account_balance;
	}

	public void setStudent_account_balance(Double student_account_balance) {
		this.student_account_balance = student_account_balance;
	}
}
