package com.dta.service;

import java.io.Serializable;
import java.util.List;

public interface IBaseAllService<T, V> {
	public int addObject(T po) throws Exception;

	public int updateObjectById(T po) throws Exception;

	public int deleteObjectById(int id);

	public int deleteMultiData(List<?> ids);

	public List<T> getAll(V vo);

	public List<T> getPage(V vo);

	public int getSize(V vo);

	public T getObjectById(Serializable id);
}