package com.dta.service;

import java.util.Map;

import com.dta.bean.SysUser;
import com.dta.vo.SysUserVo;

public interface ISysUserService extends IBaseAllService<SysUser, SysUserVo>{
	public SysUser downloadPhoto(int id);
	
	/**
	 * 
	 * @param username
	 * @return 
	 * <p>用户的驾校id，总后台用户的驾校id为0
	 */
	public Map<String,Object> getSchoolIdByUsername(String username);
}