package com.dta.bean;

import java.io.Serializable;
import java.sql.Blob;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class CoachBasicInfo extends PageParam implements Serializable{
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
	private Blob photo;
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
	public void setCoach_id(Integer coach_id){
		this.coach_id = coach_id;
	}
	public Integer getCoach_id() {
		return coach_id;
	}
	public void setCoach_name(String coach_name){
		this.coach_name = coach_name;
	}
	public String getCoach_name() {
		return coach_name;
	}
	public void setIdentity_card_no(String identity_card_no){
		this.identity_card_no = identity_card_no;
	}
	public String getIdentity_card_no() {
		return identity_card_no;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhoto(Blob photo){
		this.photo = photo;
	}
	public Blob getPhoto() {
		return photo;
	}
	public void setSchool_id(Integer school_id){
		this.school_id = school_id;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setRegister_date(String register_date){
		this.register_date = register_date;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setTraining_place(String training_place){
		this.training_place = training_place;
	}
	public String getTraining_place() {
		return training_place;
	}
	public void setContract_no(String contract_no){
		this.contract_no = contract_no;
	}
	public String getContract_no() {
		return contract_no;
	}
	public void setLogin_pwd(String login_pwd){
		this.login_pwd = login_pwd;
	}
	public String getLogin_pwd() {
		return login_pwd;
	}
	public void setValidation(Integer validation){
		this.validation = validation;
	}
	public Integer getValidation() {
		return validation;
	}
}
