package com.dta.bean;

import java.io.Serializable;

import javax.ws.rs.FormParam;

public class CoachBasicInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@FormParam("coach_id")
	private Integer coach_id;
	@FormParam("coach_name")
	private String coach_name;
	@FormParam("identity_card_no")
	private String identity_card_no;
	@FormParam("phone")
	private String phone;
	@FormParam("photo")
	private byte[] photo;
	@FormParam("school_id")
	private Integer school_id;
	@FormParam("register_date")
	private String register_date;
	@FormParam("training_place")
	private String training_place;
	@FormParam("contract_no")
	private String contract_no;
	@FormParam("login_pwd")
	private String login_pwd;
	@FormParam("validation")
	private Integer validation;
	@FormParam("service_count")
	private Integer service_count;
	@FormParam("teaching_age")
	private Integer teaching_age;
	@FormParam("online")
	private Integer online;
	@FormParam("available_times")
	private Integer available_times;// 今天还可预约的次数
	@FormParam("star")
	private Integer star;
	@FormParam("subject")
	private Integer subject;
	@FormParam("gender")
	private Integer gender;
	@FormParam("obligate_code")
	private String obligate_code;
	private Integer device_type;
	private Integer havePhoto;
	private String school_name;
	private Integer vip;

	public Integer getDevice_type() {
		return device_type;
	}

	public void setDevice_type(Integer device_type) {
		this.device_type = device_type;
	}

	public Integer getVip() {
		return vip;
	}

	public void setVip(Integer vip) {
		this.vip = vip;
	}

	public String getObligate_code() {
		return obligate_code;
	}

	public void setObligate_code(String obligate_code) {
		this.obligate_code = obligate_code;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getSubject() {
		return subject;
	}

	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	public String getSchool_name() {
		return school_name;
	}

	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}

	public Integer getService_count() {
		return service_count;
	}

	public void setService_count(Integer service_count) {
		this.service_count = service_count;
	}

	public Integer getTeaching_age() {
		return teaching_age;
	}

	public void setTeaching_age(Integer teaching_age) {
		this.teaching_age = teaching_age;
	}

	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	public Integer getAvailable_times() {
		return available_times;
	}

	public void setAvailable_times(Integer available_times) {
		this.available_times = available_times;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}

	public Integer getCoach_id() {
		return coach_id;
	}

	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}

	public String getCoach_name() {
		return coach_name;
	}

	public void setIdentity_card_no(String identity_card_no) {
		this.identity_card_no = identity_card_no;
	}

	public String getIdentity_card_no() {
		return identity_card_no;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setSchool_id(Integer school_id) {
		this.school_id = school_id;
	}

	public Integer getSchool_id() {
		return school_id;
	}

	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	public String getRegister_date() {
		return register_date;
	}

	public void setTraining_place(String training_place) {
		this.training_place = training_place;
	}

	public String getTraining_place() {
		return training_place;
	}

	public void setContract_no(String contract_no) {
		this.contract_no = contract_no;
	}

	public String getContract_no() {
		return contract_no;
	}

	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}

	public String getLogin_pwd() {
		return login_pwd;
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
