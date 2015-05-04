package com.dta.dao.base;

import java.io.Serializable;
import java.util.List;

public interface IBaseAllDao<T, V>{
	/*
	 * 增添一条数据
	 */
	public int addObject(T po);
	
	/*
	 * 根据id更新一条数据
	 */
	public int updateObjectById(T po);
	
	/*
	 * 根据id删除一条数据
	 */
	public int deleteObjectById(Serializable id);
	
	/*
	 * 删除多条数据
	 */
	public int deleteMultiData(List<Serializable> ids);
	
	/*
	 * 查询所有的数据
	 */
	public List<T>getAll();
	
	/*
	 *分页查询 
	 */
	public List<T>getPage();
	
	/*
	 * 得到总数
	 */
	public int getSize();
	
	/*
	 * 根据id查询一条数据
	 */
	public T getObjectById(Serializable id);
	
}