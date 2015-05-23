package com.dta.service;

import com.dta.bean.SysUser;
import com.dta.vo.SysUserVo;

public interface ISysUserService extends IBaseAllService<SysUser, SysUserVo>{
	public SysUser downloadPhoto(int id);
}