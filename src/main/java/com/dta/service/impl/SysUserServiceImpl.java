package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.bean.SysUser;
import com.dta.dao.ISysUserDao;
import com.dta.service.ISysUserService;
import com.dta.vo.SysUserVo;

@Service
public class SysUserServiceImpl extends BaseAllServiceImpl<SysUser, SysUserVo> implements ISysUserService{
	@Autowired
	private ISysUserDao dao;
	
	public void init(){
		super.setDao(dao);
	}
	
	public SysUser downloadPhoto(int id){
		return dao.downloadPhoto(id);
	}

	@Override
	public Integer getSchoolIdByUsername(String username) {
		if(username == null)
			throw new IllegalArgumentException("根据登录用户名获取用户id时 用户名为null");
		return dao.getSchoolIdByUsername(username);
	}
}