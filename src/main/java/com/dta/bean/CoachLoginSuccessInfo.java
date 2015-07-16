package com.dta.bean;

public class CoachLoginSuccessInfo {
	private Integer coach_id;
	private Integer code;
	private Integer validation;
	private String coach_name;
	private Integer star;
	private String school_name;
	private String phone;
	private Integer tecahing_age;
	private Integer service_count;
	
	public Integer getService_count() {
		return service_count;
	}
	public void setService_count(Integer service_count) {
		this.service_count = service_count;
	}
	public Integer getValidation() {
		return validation;
	}
	public void setValidation(Integer validation) {
		this.validation = validation;
	}
	public String getCoach_name() {
		return coach_name;
	}
	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}
	public Integer getStar() {
		return star;
	}
	public void setStar(Integer star) {
		this.star = star;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getTecahing_age() {
		return tecahing_age;
	}
	public void setTecahing_age(Integer tecahing_age) {
		this.tecahing_age = tecahing_age;
	}
	public Integer getCoach_id() {
		return coach_id;
	}
	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
}
