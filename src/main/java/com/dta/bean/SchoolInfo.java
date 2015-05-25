package com.dta.bean;

import java.io.Serializable;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

/**
 * 
 * @author gujh
 * <p>添加驾校web界面对应的javabean文件</p>
 *
 */
public class SchoolInfo extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	//此为联盟驾校信息表(school_info)对应的字段
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
	private String prepaid;
	@FormParam("bank_account")
	private String bank_account;
	@FormParam("account_holder")
	private String account_holder;
	@FormParam("subject_2_fee")
	private String subject_2_fee;
	@FormParam("subject_3_fee")
	private String subject_3_fee;
	@FormParam("charter_2_fee")
	private String charter_2_fee;
	@FormParam("charter_3_fee")
	private String charter_3_fee;
	@FormParam("device_2_status")
	private Integer device_2_status;
	@FormParam("device_3_status")
	private Integer device_3_status;
	@FormParam("vehicle_number")
	private Integer vehicle_number;
	
	public Integer getVehicle_number() {
		return vehicle_number;
	}
	public void setVehicle_number(Integer vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
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
	public void setPrepaid(String prepaid){
		this.prepaid = prepaid;
	}
	public String getPrepaid() {
		return prepaid;
	}
	public void setBank_account(String bank_account){
		this.bank_account = bank_account;
	}
	public String getBank_account() {
		return bank_account;
	}
	public String getAccount_holder() {
		return account_holder;
	}
	public void setAccount_holder(String account_holder) {
		this.account_holder = account_holder;
	}
	public void setSubject_2_fee(String subject_2_fee){
		this.subject_2_fee = subject_2_fee;
	}
	public String getSubject_2_fee() {
		return subject_2_fee;
	}
	public void setSubject_3_fee(String subject_3_fee){
		this.subject_3_fee = subject_3_fee;
	}
	public String getSubject_3_fee() {
		return subject_3_fee;
	}
	public void setCharter_2_fee(String charter_2_fee){
		this.charter_2_fee = charter_2_fee;
	}
	public String getCharter_2_fee() {
		return charter_2_fee;
	}
	public void setCharter_3_fee(String charter_3_fee){
		this.charter_3_fee = charter_3_fee;
	}
	public String getCharter_3_fee() {
		return charter_3_fee;
	}
	public void setDevice_2_status(Integer device_2_status){
		this.device_2_status = device_2_status;
	}
	public Integer getDevice_2_status() {
		return device_2_status;
	}
	public void setDevice_3_status(Integer device_3_status){
		this.device_3_status = device_3_status;
	}
	public Integer getDevice_3_status() {
		return device_3_status;
	}
	
	//此为后台用户表(sys_user)对应的字段
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
	public void setUser_id(Integer user_id){
		this.user_id = user_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_name(String user_name){
		this.user_name = user_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_pwd(String user_pwd){
		this.user_pwd = user_pwd;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setRole_ids(String role_ids){
		this.role_ids = role_ids;
	}
	public String getRole_ids() {
		return role_ids;
	}
	public void setUser_photo(byte[] user_photo){
		this.user_photo = user_photo;
	}
	public byte[] getUser_photo() {
		return user_photo;
	}
	public void setUser_attribute(Integer user_attribute){
		this.user_attribute = user_attribute;
	}
	public Integer getUser_attribute() {
		return user_attribute;
	}
	public Integer getHavePhoto() {
		return havePhoto;
	}
	public void setHavePhoto(Integer havePhoto) {
		this.havePhoto = havePhoto;
	}
}
