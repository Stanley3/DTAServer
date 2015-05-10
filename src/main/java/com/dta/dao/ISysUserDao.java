package com.dta.dao;

import java.io.Serializable;

import com.dta.dao.base.IBaseAllDao;
import com.dta.bean.SysUser;
public interface ISysUserDao extends IBaseAllDao<SysUser, SysUser> {
	public SysUser downloadPhoto(Serializable id);
}
