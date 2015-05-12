package com.dta.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dta.dao.INewsInfoDao;
import com.dta.dao.base.IBaseAllDao;
import com.dta.service.IBaseAllService;

public class BaseAllServiceImpl<T, V> implements IBaseAllService<T, V>{
	private IBaseAllDao<T, V> dao;

	public BaseAllServiceImpl(){
		
	}
	@Transactional
	public int addObject(T po)  {
		// TODO Auto-generated method stub
		return dao.addObject(po);
	}

	@Transactional
	public int updateObjectById(T po) {
		// TODO Auto-generated method stub
		return dao.updateObjectById(po);
	}

	@Transactional
	public int deleteObjectById(int id) {
		// TODO Auto-generated method stub
		return dao.deleteObjectById(id);
	}

	@Transactional
	public int deleteMultiData(List<?> ids) {
		// TODO Auto-generated method stub
		return dao.deleteMultiData(ids);
	}

	public List<T> getAll(V vo) {
		// TODO Auto-generated method stub
		return dao.getAll(vo);
	}

	public List<T> getPage(V vo) {
		// TODO Auto-generated method stub
		return dao.getPage(vo);
	}

	public int getSize(V vo) {
		// TODO Auto-generated method stub
		return dao.getSize(vo);
	}

	public T getObjectById(Serializable id) {
		// TODO Auto-generated method stub
		System.out.println("dao is a instance of newsInfoDao?" + (dao instanceof INewsInfoDao));
		T po = null;
		if(dao != null)
			 po = dao.getObjectById(id);
		else
			System.out.println("dao is null");
		return po;
	}

	
	
	public IBaseAllDao<T, V> getDao() {
		return dao;
	}

	public void setDao(IBaseAllDao<T, V> dao) {
		this.dao = dao;
	}
	
}