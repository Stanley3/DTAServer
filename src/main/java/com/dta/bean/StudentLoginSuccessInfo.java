package com.dta.bean;

public class StudentLoginSuccessInfo {
	private Integer student_id;
	private Integer login_id;
	private String student_name;
	private Integer subject; //科目 2表示科目二 3表示科目三
	private String student_phone;
	private String identity_card_no;
	private Integer student_level;//学员状态  0表示普通学员 其他表示vip
	private Integer code;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}
	public Integer getLogin_id() {
		return login_id;
	}
	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public Integer getSubject() {
		return subject;
	}
	public void setSubject(Integer subject) {
		this.subject = subject;
	}
	public String getStudent_phone() {
		return student_phone;
	}
	public void setStudent_phone(String student_phone) {
		this.student_phone = student_phone;
	}
	public String getIdentity_card_no() {
		return identity_card_no;
	}
	public void setIdentity_card_no(String identity_card_no) {
		this.identity_card_no = identity_card_no;
	}
	public Integer getStudent_level() {
		return student_level;
	}
	public void setStudent_level(Integer student_level) {
		this.student_level = student_level;
	}
	
}
