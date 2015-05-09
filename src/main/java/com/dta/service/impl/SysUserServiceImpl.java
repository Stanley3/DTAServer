package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SysUser;
import com.dta.dao.ISysUserDao;
import com.dta.service.ISysUserService;

@Service
public class SysUserServiceImpl extends BaseAllServiceImpl<SysUser, SysUser> implements ISysUserService{
	@Autowired
	private ISysUserDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}