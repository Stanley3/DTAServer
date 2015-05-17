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
	@FormParam("register_time")
	private String register_time;
	@FormParam("register_number")
	private Integer register_number;
	@FormParam("student_number")
	private Integer student_number;
	@FormParam("school_type")
	private Integer school_type;
	@FormParam("status")
	private Integer status;
	@FormParam("prepaid")
	private double prepaid;
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
	public void setRegister_time(String register_time){
		this.register_time = register_time;
	}
	public String getRegister_time() {
		return register_time;
	}
	public void setRegister_number(Integer register_number){
		this.register_number = register_number;
	}
	public Integer getRegister_number() {
		return register_number;
	}
	public void setStudent_number(Integer student_number){
		this.student_number = student_number;
	}
	public Integer getStudent_number() {
		return student_number;
	}
	public void setSchool_type(Integer school_type){
		this.school_type = school_type;
	}
	public Integer getSchool_type() {
		return school_type;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getStatus() {
		return status;
	}
	public double getPrepaid() {
		return prepaid;
	}
	public void setPrepaid(double prepaid) {
		this.prepaid = prepaid;
	}
	
}
