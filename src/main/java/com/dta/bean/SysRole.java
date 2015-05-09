package com.dta.bean;

import java.io.Serializable;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class SysRole extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@FormParam("role_id")
	private Integer role_id;
	@FormParam("role_name")
	private String role_name;
	@FormParam("role_permission")
	private Integer role_permission;
	@FormParam("validation")
	private Integer validation;
	public void setRole_id(Integer role_id){
		this.role_id = role_id;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_name(String role_name){
		this.role_name = role_name;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_permission(Integer role_permission){
		this.role_permission = role_permission;
	}
	public Integer getRole_permission() {
		return role_permission;
	}
	public void setValidation(Integer validation){
		this.validation = validation;
	}
	public Integer getValidation() {
		return validation;
	}
}
