package com.dta.bean;

import java.io.Serializable;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class SchoolInfo extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@FormParam("school_id")
	private Integer school_id;
	@FormParam("school_name")
	private String school_name;
	@FormParam("contract_no")
	private String contract_no;
	@FormParam("leader")
	private String leader;
	@FormParam("leader_phone")
	private String leader_phone;
	@FormParam("school_address")
	private String school_address;
	@FormParam("school_phone")
	private String school_phone;
	@FormParam("longitude")
	private String longitude;
	@FormParam("latitude")
	private String latitude;
	@FormParam("coach_number")
	private Integer coach_number;
	@FormParam("subject_2_number")
	private Integer subject_2_number;
	@FormParam("subject_3_number")
	private Integer subject_3_number;
	@FormParam("validation")
	private Integer validation;
	public void setSchool_id(Integer school_id){
		this.school_id = school_id;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setSchool_name(String school_name){
		this.school_name = school_name;
	}
	public String getSchool_name() {
		return school_name;
	}
	public void setContract_no(String contract_no){
		this.contract_no = contract_no;
	}
	public String getContract_no() {
		return contract_no;
	}
	public void setLeader(String leader){
		this.leader = leader;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader_phone(String leader_phone){
		this.leader_phone = leader_phone;
	}
	public String getLeader_phone() {
		return leader_phone;
	}
	public void setSchool_address(String school_address){
		this.school_address = school_address;
	}
	public String getSchool_address() {
		return school_address;
	}
	public void setSchool_phone(String school_phone){
		this.school_phone = school_phone;
	}
	public String getSchool_phone() {
		return school_phone;
	}
	public void setLongitude(String longitude){
		this.longitude = longitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLatitude(String latitude){
		this.latitude = latitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setCoach_number(Integer coach_number){
		this.coach_number = coach_number;
	}
	public Integer getCoach_number() {
		return coach_number;
	}
	public void setSubject_2_number(Integer subject_2_number){
		this.subject_2_number = subject_2_number;
	}
	public Integer getSubject_2_number() {
		return subject_2_number;
	}
	public void setSubject_3_number(Integer subject_3_number){
		this.subject_3_number = subject_3_number;
	}
	public Integer getSubject_3_number() {
		return subject_3_number;
	}
	public void setValidation(Integer validation){
		this.validation = validation;
	}
	public Integer getValidation() {
		return validation;
	}
}
