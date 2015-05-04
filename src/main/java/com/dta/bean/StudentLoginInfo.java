package com.dta.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class StudentLoginInfo extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@FormParam("login_id")
	private Integer login_id;
	@FormParam("student_id")
	private Integer student_id;
	@FormParam("login_name")
	private String login_name;
	@FormParam("login_pwd")
	private String login_pwd;
	@FormParam("login_nickname")
	private String login_nickname;
	@FormParam("register_time")
	private Date register_time;
	@FormParam("validation")
	private Integer validation;
	public void setLogin_id(Integer login_id){
		this.login_id = login_id;
	}
	public Integer getLogin_id() {
		return login_id;
	}
	public void setStudent_id(Integer student_id){
		this.student_id = student_id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setLogin_name(String login_name){
		this.login_name = login_name;
	}
	public String getLogin_name() {
		return login_name;
	}
	public void setLogin_pwd(String login_pwd){
		this.login_pwd = login_pwd;
	}
	public String getLogin_pwd() {
		return login_pwd;
	}
	public void setLogin_nickname(String login_nickname){
		this.login_nickname = login_nickname;
	}
	public String getLogin_nickname() {
		return login_nickname;
	}
	public void setRegister_time(Date register_time){
		this.register_time = register_time;
	}
	public Date getRegister_time() {
		return register_time;
	}
	public void setValidation(Integer validation){
		this.validation = validation;
	}
	public Integer getValidation() {
		return validation;
	}
}
