package com.dta.bean;

import java.io.Serializable;
import java.sql.Date;



import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class OrderRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	@FormParam("order_id")
	private Integer order_id;
	@FormParam("student_id")
	private Integer student_id;
	@FormParam("coach_id")
	private Integer coach_id;
	@FormParam("school_id")
	private Integer school_id;
	@FormParam("order_time")
	private Date order_time;
	@FormParam("order_amount")
	private String order_amount;
	@FormParam("order_status")
	private Integer order_status;
	@FormParam("training_start_time")
	private String training_start_time;
	@FormParam("training_end_time")
	private String training_end_time;
	@FormParam("order_dead_time")
	private String order_dead_time;
	@FormParam("order_memo")
	private String order_memo;
	@FormParam("validation")
	private Integer validation;
	@FormParam("course_status")
	private Integer course_status;
	private String coach_name;
	private String phone;
	private String training_place;
	private Integer havePhoto;
	public void setOrder_id(Integer order_id){
		this.order_id = order_id;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setStudent_id(Integer student_id){
		this.student_id = student_id;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setCoach_id(Integer coach_id){
		this.coach_id = coach_id;
	}
	public Integer getCoach_id() {
		return coach_id;
	}
	public void setSchool_id(Integer school_id){
		this.school_id = school_id;
	}
	public Integer getSchool_id() {
		return school_id;
	}
	public void setOrder_time(Date order_time){
		this.order_time = order_time;
	}
	public Date getOrder_time() {
		return order_time;
	}
	public void setOrder_amount(String order_amount){
		this.order_amount = order_amount;
	}
	public String getOrder_amount() {
		return order_amount;
	}
	public void setOrder_status(Integer order_status){
		this.order_status = order_status;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public String getTraining_start_time() {
		if(training_start_time != null)
			return training_start_time.substring(0, training_start_time.lastIndexOf('.'));
		return null;
	}
	public void setTraining_start_time(String training_start_time) {
		this.training_start_time = training_start_time;
	}
	public String getTraining_end_time() {
		if(training_end_time != null)
			return training_end_time.substring(0, training_end_time.lastIndexOf('.'));
		return null;
	}
	public void setTraining_end_time(String training_end_time) {
		this.training_end_time = training_end_time;
	}
	public String getOrder_dead_time() {
		if(order_dead_time != null)
			return order_dead_time.substring(0, order_dead_time.lastIndexOf('.'));
		return null;
	}
	public void setOrder_dead_time(String order_dead_time) {
		this.order_dead_time = order_dead_time;
	}
	public void setOrder_memo(String order_memo){
		this.order_memo = order_memo;
	}
	public String getOrder_memo() {
		return order_memo;
	}
	public void setValidation(Integer validation){
		this.validation = validation;
	}
	public Integer getValidation() {
		return validation;
	}
	public void setCourse_status(Integer course_status){
		this.course_status = course_status;
	}
	public Integer getCourse_status() {
		return course_status;
	}
	public String getCoach_name() {
		return coach_name;
	}
	public void setCoach_name(String coach_name) {
		this.coach_name = coach_name;
	}
	public String getPhone() {
		return phone;
	}
	public Integer getHavePhoto() {
		return havePhoto;
	}
	public void setHavePhoto(Integer havePhoto) {
		this.havePhoto = havePhoto;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTraining_place() {
		return training_place;
	}
	public void setTraining_place(String training_place) {
		this.training_place = training_place;
	}
}
