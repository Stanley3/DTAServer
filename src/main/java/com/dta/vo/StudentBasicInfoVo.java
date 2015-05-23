package com.dta.vo;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import com.dta.vo.PageParam;

public class StudentBasicInfoVo extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@QueryParam("student_id")
	private Integer student_id;
	@QueryParam("student_name")
	private String student_name;
	@QueryParam("identity_card_no")
	private String identity_card_no;
	@QueryParam("student_gender")
	private String student_gender;
	@QueryParam("student_phone")
	private String student_phone;
	@QueryParam("status")
	private Integer status;
	@QueryParam("validation")
	private Integer validation;
	public void setStudent_id(Integer student_id){
		this.student_id = student_id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_name(String student_name){
		this.student_name = student_name;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setIdentity_card_no(String identity_card_no){
		this.identity_card_no = identity_card_no;
	}
	public String getIdentity_card_no() {
		return identity_card_no;
	}
	public void setStudent_gender(String student_gender){
		this.student_gender = student_gender;
	}
	public String getStudent_gender() {
		return student_gender;
	}
	public void setStudent_phone(String student_phone){
		this.student_phone = student_phone;
	}
	public String getStudent_phone() {
		return student_phone;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus() {
		return status;
	}
	public void setValidation(Integer validation){
		this.validation = validation;
	}
	public Integer getValidation() {
		return validation;
	}
}
