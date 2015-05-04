package com.dta.service;

import java.io.Serializable;
import java.util.List;

public interface IBaseAllService<T, V>{
	public int addObject(T po);
	public int updateObjectById(int id);
	public int deleteObjectById(int id);
	public int deleteMultiData(List<Serializable> ids);
	public List<T>getAll();
	public List<T>getPage();
	public int getSize();
	public T getObjectById(Serializable id);
}