package com.dta.bean;

import java.io.Serializable;
import java.sql.Blob;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class StudentBasicInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	@FormParam("student_id")
	private Integer student_id;
	@FormParam("student_name")
	private String student_name;
	@FormParam("student_photo")
	private byte[] student_photo;
	@FormParam("identity_card_no")
	private String identity_card_no;
	@FormParam("student_gender")
	private Integer student_gender;
	@FormParam("student_phone")
	private String student_phone;
	@FormParam("validation")
	private Integer validation;
	@FormParam("subject")
	private Integer subject;
	@FormParam("driving_license_type")
	private Integer driving_license_type;
	@FormParam("obligate_code")
	private String obligate_code;
	@FormParam("school_id")
	private Integer school_id;
	@FormParam("login_pwd")
	private String login_pwd;
	@FormParam("student_level")
	private Integer student_level;

	private String register_date;
	private String school_name;
	private Integer havePhoto;
	private String chartered_coach_name;
	private Integer chartered_coach_id;
	// 学员列表页面使用的字段
	private Integer subject_2_number;
	private Integer subject_3_number;
	private Double amount;
	private Integer source;
	private Integer vip_number;
	private Integer login_id;
	
	
	public String getChartered_coach_name() {
		return chartered_coach_name;
	}

	public void setChartered_coach_name(String chartered_coach_name) {
		this.chartered_coach_name = chartered_coach_name;
	}

	public Integer getChartered_coach_id() {
		return chartered_coach_id;
	}

	public void setChartered_coach_id(Integer chartered_coach_id) {
		this.chartered_coach_id = chartered_coach_id;
	}

	public Integer getStudent_level() {
		return student_level;
	}

	public void setStudent_level(Integer student_level) {
		this.student_level = student_level;
	}

	public Integer getLogin_id() {
		return login_id;
	}

	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}

	public Integer getHavePhoto() {
		return havePhoto;
	}

	public void setHavePhoto(Integer havePhoto) {
		this.havePhoto = havePhoto;
	}

	public Integer getSubject_2_number() {
		return subject_2_number;
	}

	public void setSubject_2_number(Integer subject_2_number) {
		this.subject_2_number = subject_2_number;
	}

	public Integer getSubject_3_number() {
		return subject_3_number;
	}

	public void setSubject_3_number(Integer subject_3_number) {
		this.subject_3_number = subject_3_number;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getVip_number() {
		return vip_number;
	}

	public void setVip_number(Integer vip_number) {
		this.vip_number = vip_number;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public String getRegister_date() {
		return register_date;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	public String getLogin_pwd() {
		return login_pwd;
	}

	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}

	public Integer getSchool_id() {
		return school_id;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public String getObligate_code() {
		return obligate_code;
	}

	public void setObligate_code(String obligate_code) {
		this.obligate_code = obligate_code;
	}

	public Integer getStudent_gender() {
		return student_gender;
	}

	public void setStudent_gender(Integer student_gender) {
		this.student_gender = student_gender;
	}

	public Integer getSubject() {
		return subject;
	}

	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	public Integer getDriving_license_type() {
		return driving_license_type;
	}

	public void setDriving_license_type(Integer driving_license_type) {
		this.driving_license_type = driving_license_type;
	}

	public byte[] getStudent_photo() {
		return student_photo;
	}

	public void setStudent_photo(byte[] student_photo) {
		this.student_photo = student_photo;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setIdentity_card_no(String identity_card_no) {
		this.identity_card_no = identity_card_no;
	}

	public String getIdentity_card_no() {
		return identity_card_no;
	}

	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}

	public String getStudent_phone() {
		return student_phone;
	}

	public void setValidation(Integer validation) {
		this.validation = validation;
	}

	public Integer getValidation() {
		return validation;
	}
}
