package com.dta.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.bean.SchoolInfo;
import com.dta.bean.SchoolInfoBasedDistance;
import com.dta.bean.SysUser;
import com.dta.dao.ISchoolInfoDao;
import com.dta.dao.ISysUserDao;
import com.dta.service.ISchoolInfoService;
import com.dta.vo.SchoolInfoBasedDistanceVo;
import com.dta.vo.SchoolInfoVo;

@Service
public class SchoolInfoServiceImpl extends
		BaseAllServiceImpl<SchoolInfo, SchoolInfoVo> implements
		ISchoolInfoService {
	@Autowired
	private ISchoolInfoDao dao;
	@Autowired
	private ISysUserDao userDao;

	public void init() {
		super.setDao(dao);
	}

	@Transactional
	public int addObject(SchoolInfo po) {
		po.setLeader(po.getSchoolmaster_name());
		po.setLeader_phone(po.getUser_name());
		int result = dao.addObject(po);
		System.out.println("输出添加是设备2的值："
				+ String.valueOf(po.getDevice_2_status()));

		SysUser user = new SysUser();
		System.out.println("当输入的参数为空时，接受的参数是null还是空字符串："
				+ po.getObligate_code() == null ? "null" : "空字符串");
		user.setSchoolmaster_name(po.getSchoolmaster_name());
		user.setUser_name(po.getUser_name());
		user.setUser_pwd(po.getUser_pwd());
		user.setUser_attribute(po.getSchool_id());
		user.setObligate_code(po.getObligate_code());
		user.setRole_ids("1");
		result = userDao.addObject(user);
		Map<String, Integer> userRoleMap = new HashMap<String, Integer>(5);
		userRoleMap.put("role_id", 1);
		userRoleMap.put("user_id",user.getUser_id());
		userRoleMap.put("flag", 0);
		result = userDao.addSchoolAdmin(userRoleMap);
		return result;
	}

	public SchoolInfo getObjectById(Serializable id) {
		SchoolInfo schoolInfo = new SchoolInfo();
		SysUser sysUser = new SysUser();
		schoolInfo = dao.getObjectById(id);
		sysUser = userDao.getUserByFK(schoolInfo.getLeader_phone());
		schoolInfo.setSchoolmaster_name(sysUser.getSchoolmaster_name());
		schoolInfo.setUser_name(sysUser.getUser_name());
		schoolInfo.setUser_pwd(sysUser.getUser_pwd());
		schoolInfo.setObligate_code(sysUser.getObligate_code());
		return schoolInfo;
	}

	/*@Transactional
	public int updateObjectById(SchoolInfo po) throws Exception {
		if (po.getSchool_id() == null)
			throw new Exception("未知驾校id(school_id)");
		if (po.getUser_id() == null)
			throw new Exception("未知系统用户id(user_id)");
		int result = dao.updateObjectById(po);
		SysUser user = new SysUser();
		System.out.println("取得的系统用户Id是：" + po.getUser_id());
		user.setUser_id(po.getUser_id());
		user.setSchoolmaster_name(po.getSchoolmaster_name());
		user.setUser_name(po.getUser_name());
		user.setUser_pwd(po.getUser_pwd());
		user.setUser_attribute(po.getSchool_id());
		user.setObligate_code(po.getObligate_code());
		user.setRole_ids("1");
		result = userDao.updateObjectById(user);
		return result;
	}
*/
	public int getAvaiableCoachNumbers(int school_id) {
		return dao.getAvaiableCoachNumbers(school_id);
	}

	@Override
	public List<SchoolInfoBasedDistance> getSchoolDistanceInfo(
			SchoolInfoBasedDistanceVo vo) {
		// TODO Auto-generated method stub
		return dao.getSchoolDistanceInfo(vo);
	}

	@Override
	public int getSchoolDistanceInfoSize(SchoolInfoBasedDistanceVo vo) {
		// TODO Auto-generated method stub
		return dao.getSchoolDistanceInfoSize(vo);
	}

	@Override
	public List<SchoolInfoBasedDistance> getSchoolInfo(SchoolInfoVo vo) {
		if(vo.getStudent_id() == null)
			throw new IllegalArgumentException("根据学员信息获取驾校信息时，学员id为null");
		if(vo.getSubject() == null)
			throw new IllegalArgumentException("根据学员信息获取驾校信息时，学员科目为null");
		return dao.getSchoolInfo(vo);
	}

	@Override
	public int getSchoolInfoSize(Integer subject) {
		if(subject == null)
			throw new IllegalArgumentException("根据学员信息获取驾校信息时，学员科目为null");
		return dao.getSchoolInfoSize(subject);
	}

	@Override
	public List<Map<String, String>> webSelectSchool() {
		// TODO Auto-generated method stub
		return dao.webSelectSchool();
	}
}