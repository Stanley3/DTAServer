package com.dta.vo;

import javax.ws.rs.FormParam;

public class PageParam{
	@FormParam("sort")
	public String sort;
	@FormParam("order")
	public String order;
	@FormParam("page")
	public int page;
	@FormParam("rows")
	public int rows;
	
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	
}