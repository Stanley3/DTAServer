package com.dta.vo;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import com.dta.vo.PageParam;

public class NewsInfoVo extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@QueryParam("news_info_id")
	private Integer news_info_id;
	@QueryParam("sender")
	private Integer sender;
	@QueryParam("send_time")
	private String send_time;
	@QueryParam("content")
	private String content;
	@QueryParam("receiver_type")
	private Integer receiver_type;
	@QueryParam("attribute")
	private Integer attribute;
	@QueryParam("validation")
	private Integer validation;
	public void setNews_info_id(Integer news_info_id){
		this.news_info_id = news_info_id;
	}
	public Integer getNews_info_id() {
		return news_info_id;
	}
	public void setSender(Integer sender){
		this.sender = sender;
	}
	public Integer getSender() {
		return sender;
	}
	public void setSend_time(String send_time){
		this.send_time = send_time;
	}
	public String getSend_time() {
		return send_time;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setReceiver_type(Integer receiver_type){
		this.receiver_type = receiver_type;
	}
	public Integer getReceiver_type() {
		return receiver_type;
	}
	public void setAttribute(Integer attribute){
		this.attribute = attribute;
	}
	public Integer getAttribute() {
		return attribute;
	}
	public void setValidation(Integer validation){
		this.validation = validation;
	}
	public Integer getValidation() {
		return validation;
	}
}
