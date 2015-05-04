package com.dta.service.impl;

import java.io.Serializable;
import java.util.List;

import com.dta.service.IBaseAllService;

public class BaseAllServiceImpl<T, V> implements IBaseAllService<T, V>{

	public int addObject(T po) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateObjectById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteObjectById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteMultiData(List<Serializable> ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> getPage() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public T getObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}