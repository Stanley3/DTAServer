package com.dta.dao;

import java.io.Serializable;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.SysUserVo;
import com.dta.bean.SysUser;
public interface ISysUserDao extends IBaseAllDao<SysUser, SysUserVo> {
	public SysUser downloadPhoto(Serializable id);
	
	public SysUser getUserByFK(Serializable fk);
}
