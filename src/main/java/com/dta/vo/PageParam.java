package com.dta.vo;

import javax.ws.rs.QueryParam;


public class PageParam{
	@QueryParam("sort")
	public String sort;
	@QueryParam("dir")
	public String order;
	@QueryParam("start")
	public int page;
	@QueryParam("length")
	public int rows;
	@QueryParam("draw")
	private Integer draw;
	@QueryParam("search")
	private String search;
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
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