package com.dta.vo;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import com.dta.vo.PageParam;

public class StudentLoginInfoVo extends PageParam implements Serializable {
	private static final long serialVersionUID = 1L;
	@QueryParam("login_id")
	private Integer login_id;
	@QueryParam("student_id")
	private Integer student_id;
	@QueryParam("login_name")
	private String login_name;
	@QueryParam("login_pwd")
	private String login_pwd;
	@QueryParam("login_nickname")
	private String login_nickname;
	@QueryParam("register_time")
	private String register_time;
	@QueryParam("validation")
	private Integer validation;

	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}

	public Integer getLogin_id() {
		return login_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}

	public String getLogin_pwd() {
		return login_pwd;
	}

	public void setLogin_nickname(String login_nickname) {
		this.login_nickname = login_nickname;
	}

	public String getLogin_nickname() {
		return login_nickname;
	}

	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}

	public String getRegister_time() {
		return register_time;
	}

	public void setValidation(Integer validation) {
		this.validation = validation;
	}

	public Integer getValidation() {
		return validation;
	}
}
