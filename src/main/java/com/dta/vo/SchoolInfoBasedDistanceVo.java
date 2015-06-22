package com.dta.vo;

import javax.ws.rs.QueryParam;

public class SchoolInfoBasedDistanceVo extends PageParam {
	@QueryParam("longitude")
	private  Double longitude; //经度
	@QueryParam("latitude")
	private Double latitude; //纬度
	
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}
