package com.dta.bean;

import java.io.Serializable;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class SchoolDepositRecord  implements Serializable{
	private static final long serialVersionUID = 1L;
	@FormParam("school_deposit_id")
	private Integer school_deposit_id;
	@FormParam("deposit_amount")
	private String deposit_amount;
	@FormParam("deposit_type")
	private Integer deposit_type;
	@FormParam("deposit_way")
	private Integer deposit_way;
	@FormParam("remark")
	private String remark;
	@FormParam("school_id")
	private Integer school_id;
	@FormParam("operator")
	private Integer operator;
	@FormParam("deposit_date")
	private String deposit_date;
	//显示驾校充值记录界面需要的参数
	private String operator_name;
	private String school_name;
	private String school_phone;
	
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getSchool_phone() {
		return school_phone;
	}
	public void setSchool_phone(String school_phone) {
		this.school_phone = school_phone;
	}
	public String getOperator_name() {
		return operator_name;
	}
	public void setOperator_name(String operator_name) {
		this.operator_name = operator_name;
	}
	public void setSchool_deposit_id(Integer school_deposit_id){
		this.school_deposit_id = school_deposit_id;
	}
	public Integer getSchool_deposit_id() {
		return school_deposit_id;
	}
	public void setDeposit_amount(String deposit_amount){
		this.deposit_amount = deposit_amount;
	}
	public String getDeposit_amount() {
		return deposit_amount;
	}
	public void setDeposit_type(Integer deposit_type){
		this.deposit_type = deposit_type;
	}
	public Integer getDeposit_type() {
		return deposit_type;
	}
	public void setDeposit_way(Integer deposit_way){
		this.deposit_way = deposit_way;
	}
	public Integer getDeposit_way() {
		return deposit_way;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
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
	public void setDeposit_date(String deposit_date){
		this.deposit_date = deposit_date;
	}
	public String getDeposit_date() {
		return deposit_date;
	}
}
