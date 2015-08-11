package com.dta.bean;

import java.io.Serializable;
import java.sql.Blob;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class SysUser extends PageParam implements Serializable {
	private static final long serialVersionUID = 1L;
	@FormParam("user_id")
	private Integer user_id;
	@FormParam("user_name")
	private String user_name;
	@FormParam("user_pwd")
	private String user_pwd;
	@FormParam("role_ids")
	private String role_ids;
	@FormParam("user_photo")
	private byte[] user_photo;
	@FormParam("user_attribute")
	private Integer user_attribute;
	@FormParam("validation")
	private Integer validation;
	@FormParam("schoolmaster_name")
	private String schoolmaster_name;
	@FormParam("obligate_code")
	private String obligate_code;
	private Integer havePhoto;

	public String getSchoolmaster_name() {
		return schoolmaster_name;
	}

	public void setSchoolmaster_name(String schoolmaster_name) {
		this.schoolmaster_name = schoolmaster_name;
	}

	public String getObligate_code() {
		return obligate_code;
	}

	public void setObligate_code(String obligate_code) {
		this.obligate_code = obligate_code;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setRole_ids(String role_ids) {
		this.role_ids = role_ids;
	}

	public String getRole_ids() {
		return role_ids;
	}

	public void setUser_photo(byte[] user_photo) {
		this.user_photo = user_photo;
	}

	public byte[] getUser_photo() {
		return user_photo;
	}

	public void setUser_attribute(Integer user_attribute) {
		this.user_attribute = user_attribute;
	}

	public Integer getUser_attribute() {
		return user_attribute;
	}

	public void setValidation(Integer validation) {
		this.validation = validation;
	}

	public Integer getValidation() {
		return validation;
	}

	public Integer getHavePhoto() {
		return havePhoto;
	}

	public void setHavePhoto(Integer havePhoto) {
		this.havePhoto = havePhoto;
	}
}
