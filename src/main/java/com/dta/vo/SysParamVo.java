package com.dta.vo;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import com.dta.vo.PageParam;

public class SysParamVo extends PageParam implements Serializable {
	private static final long serialVersionUID = 1L;
	@QueryParam("param_id")
	private Integer param_id;
	@QueryParam("evalution_weight")
	private String evalution_weight;
	@QueryParam("signup_fee")
	private String signup_fee;
	@QueryParam("upgrade_fee")
	private String upgrade_fee;
	@QueryParam("validation")
	private Integer validation;

	public void setParam_id(Integer param_id) {
		this.param_id = param_id;
	}

	public Integer getParam_id() {
		return param_id;
	}

	public void setEvalution_weight(String evalution_weight) {
		this.evalution_weight = evalution_weight;
	}

	public String getEvalution_weight() {
		return evalution_weight;
	}

	public void setSignup_fee(String signup_fee) {
		this.signup_fee = signup_fee;
	}

	public String getSignup_fee() {
		return signup_fee;
	}

	public void setUpgrade_fee(String upgrade_fee) {
		this.upgrade_fee = upgrade_fee;
	}

	public String getUpgrade_fee() {
		return upgrade_fee;
	}

	public void setValidation(Integer validation) {
		this.validation = validation;
	}

	public Integer getValidation() {
		return validation;
	}
}
