package com.dta.dao.base;

import java.io.Serializable;
import java.util.List;

public interface IBaseAllDao<T, V> {
	/*
	 * 增添一个对象
	 */
	public int addObject(T po);

	/*
	 * 根据id更新一个对象
	 */
	public int updateObjectById(T po);

	/*
	 * 根据id删除一个对象
	 */
	public int deleteObjectById(Serializable id);

	/*
	 * 删除多个对象
	 */
	public int deleteMultiData(List<?> ids);

	/*
	 * 查询所有符合条件的数据
	 */
	public List<T> getAll(V vo);

	/*
	 * 分页查询所有符合条件的数据
	 */
	public List<T> getPage(V vo);

	/*
	 * 查询所有符合条件的数据的总数
	 */
	public int getSize(V vo);

	/*
	 * 根据id查询一个对象
	 */
	public T getObjectById(Serializable id);

	/*
	 * web页面全局搜索
	 */
	public List<T> globalSearch(V vo);

	/*
	 * web页面全局搜索到的数据总数
	 */
	public int globalSearchSize(V vo);
}