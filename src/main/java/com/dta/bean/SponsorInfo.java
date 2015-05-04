package com.dta.bean;

import java.io.Serializable;

import javax.ws.rs.FormParam;

import com.dta.vo.PageParam;

public class SponsorInfo extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@FormParam("sponsor_id")
	private Integer sponsor_id;
	@FormParam("sponsor_name")
	private String sponsor_name;
	@FormParam("amount")
	private String amount;
	@FormParam("time")
	private String time;
	@FormParam("advertisement")
	private String advertisement;
	@FormParam("ratio")
	private String ratio;
	public void setSponsor_id(Integer sponsor_id){
		this.sponsor_id = sponsor_id;
	}
	public Integer getSponsor_id() {
		return sponsor_id;
	}
	public void setSponsor_name(String sponsor_name){
		this.sponsor_name = sponsor_name;
	}
	public String getSponsor_name() {
		return sponsor_name;
	}
	public void setAmount(String amount){
		this.amount = amount;
	}
	public String getAmount() {
		return amount;
	}
	public void setTime(String time){
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	public void setAdvertisement(String advertisement){
		this.advertisement = advertisement;
	}
	public String getAdvertisement() {
		return advertisement;
	}
	public void setRatio(String ratio){
		this.ratio = ratio;
	}
	public String getRatio() {
		return ratio;
	}
}
