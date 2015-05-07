package com.dta.bean;

import java.io.Serializable;
import java.sql.Blob;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

import com.dta.vo.PageParam;

@XmlRootElement
public class SysUser extends PageParam implements Serializable{
	private static final long serialVersionUID = 1L;
	@FormParam("user_id")
	private Integer user_id;
	@FormParam("user_name")
	private String user_name;
	@FormParam("user_pwd")
	private String user_pwd;
	@FormParam("role_ids")
	private String role_ids;
	@FormParam("user_photo")
	private Blob user_photo;
	@FormParam("user_attribute")
	private Integer user_attribute;
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
	public void setUser_photo(Blob user_photo){
		this.user_photo = user_photo;
	}
	public Blob getUser_photo() {
		return user_photo;
	}
	public void setUser_attribute(Integer user_attribute){
		this.user_attribute = user_attribute;
	}
	public Integer getUser_attribute() {
		return user_attribute;
	}
}
