package com.dta.dao;

import java.io.Serializable;
import java.util.Map;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.SysUserVo;
import com.dta.bean.SysUser;

public interface ISysUserDao extends IBaseAllDao<SysUser, SysUserVo> {
	public SysUser downloadPhoto(Serializable id);

	public SysUser getUserByFK(Serializable fk);

	/**
	 * 
	 * @param username
	 * @return <p>
	 *         用户的驾校id，总后台用户的驾校id为0
	 */
	public Map<String, Object> getSchoolIdByUsername(String username);

}
