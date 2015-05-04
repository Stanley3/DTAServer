package com.dta.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class OrderRecord extends PageParam implements Serializable{
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
	private Date training_start_time;
	@FormParam("training_end_time")
	private Date training_end_time;
	@FormParam("order_dead_time")
	private Date order_dead_time;
	@FormParam("order_memo")
	private String order_memo;
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
	public void setTraining_start_time(Date training_start_time){
		this.training_start_time = training_start_time;
	}
	public Date getTraining_start_time() {
		return training_start_time;
	}
	public void setTraining_end_time(Date training_end_time){
		this.training_end_time = training_end_time;
	}
	public Date getTraining_end_time() {
		return training_end_time;
	}
	public void setOrder_dead_time(Date order_dead_time){
		this.order_dead_time = order_dead_time;
	}
	public Date getOrder_dead_time() {
		return order_dead_time;
	}
	public void setOrder_memo(String order_memo){
		this.order_memo = order_memo;
	}
	public String getOrder_memo() {
		return order_memo;
	}
}
