package com.dta.vo;

import javax.ws.rs.QueryParam;


public class PageParam{
	@QueryParam("sort")
	public String sort; //排序字段
	@QueryParam("dir")
	public String order; //排序方式 desc asc 
	@QueryParam("start")
	public int page; //起始页（0，1，2 。。。） 或 起始行（0， 10， 20， 。。。）具体用哪一个 根据url定
	@QueryParam("length")
	public int rows; //一次请求多少数据
	@QueryParam("draw")
	private Integer draw;
	@QueryParam("search")
	private String search; //搜索值
	
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