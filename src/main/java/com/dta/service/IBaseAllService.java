package com.dta.service;

import java.io.Serializable;
import java.util.List;

public interface IBaseAllService<T, V>{
	public int addObject(T po);
	public int updateObjectById(T po);
	public int deleteObjectById(int id);
	public int deleteMultiData(List<?> ids);
	public List<T>getAll(T po);
	public List<T>getPage(T po);
	public int getSize(T po);
	public T getObjectById(Serializable id);
}