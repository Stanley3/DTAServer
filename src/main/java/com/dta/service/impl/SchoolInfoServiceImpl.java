package com.dta.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.bean.SchoolInfo;
import com.dta.bean.SysUser;
import com.dta.dao.ISchoolInfoDao;
import com.dta.dao.ISysUserDao;
import com.dta.service.ISchoolInfoService;
import com.dta.vo.SchoolInfoVo;

@Service
public class SchoolInfoServiceImpl extends BaseAllServiceImpl<SchoolInfo, SchoolInfoVo> implements ISchoolInfoService{
	@Autowired
	private ISchoolInfoDao dao;
	@Autowired
	private ISysUserDao userDao;
	
	public void init(){
		super.setDao(dao);
	}
	
	@Transactional
	public int addObject(SchoolInfo po){
		int result = dao.addObject(po);
		SysUser user = new SysUser();
		System.out.println("当输入的参数为空时，接受的参数是null还是空字符串：" + po.getObligate_code() == null ? "null" : "空字符串");
		user.setSchoolmaster_name(po.getSchoolmaster_name());
		user.setUser_name(po.getUser_name());
		user.setUser_pwd(po.getUser_pwd());
		user.setUser_attribute(po.getSchool_id());
		user.setObligate_code(po.getObligate_code());
		user.setRole_ids("1");
		result = userDao.addObject(user);
		return result;
	}
	
	public SchoolInfo getObjectById(Serializable id){
		SchoolInfo schoolInfo = new SchoolInfo();
		SysUser sysUser = new SysUser();
		schoolInfo = dao.getObjectById(id);
		sysUser = userDao.getUserByFK(schoolInfo.getSchool_id());
		schoolInfo.setSchoolmaster_name(sysUser.getSchoolmaster_name());
		schoolInfo.setUser_name(sysUser.getUser_name());
		schoolInfo.setUser_pwd(sysUser.getUser_pwd());
		schoolInfo.setObligate_code(sysUser.getObligate_code());
		return schoolInfo;
	}
}