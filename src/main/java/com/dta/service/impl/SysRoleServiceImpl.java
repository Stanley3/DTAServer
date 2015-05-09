package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SysRole;
import com.dta.dao.ISysRoleDao;
import com.dta.service.ISysRoleService;

@Service
public class SysRoleServiceImpl extends BaseAllServiceImpl<SysRole, SysRole> implements ISysRoleService{
	@Autowired
	private ISysRoleDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}