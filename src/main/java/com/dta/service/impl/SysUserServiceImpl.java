package com.dta.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SysUser;
import com.dta.dao.ISysUserDao;
import com.dta.service.ISysUserService;

@Service
public class SysUserServiceImpl implements ISysUserService{
	@Autowired
	private ISysUserDao dao;
	
	public int addObject(SysUser po) {
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

	public List<SysUser> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<SysUser> getPage() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public SysUser getObjectById(Serializable id) {
		// TODO Auto-generated method stub
		System.out.println("in SysUserServiceImpl: " + id);
		return dao.getObjectById(id);
	}
	
}