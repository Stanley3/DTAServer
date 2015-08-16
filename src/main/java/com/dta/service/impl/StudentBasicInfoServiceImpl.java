package com.dta.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.bean.GatherStudentInfo;
import com.dta.bean.StudentBasicInfo;
import com.dta.bean.StudentLoginInfo;
import com.dta.dao.IStudentBasicInfoDao;
import com.dta.dao.IStudentLoginInfoDao;
import com.dta.service.IStudentBasicInfoService;
import com.dta.vo.StudentBasicInfoVo;

@Service
public class StudentBasicInfoServiceImpl extends
		BaseAllServiceImpl<StudentBasicInfo, StudentBasicInfoVo> implements
		IStudentBasicInfoService {
	@Autowired
	private IStudentBasicInfoDao dao;
	@Autowired
	private IStudentLoginInfoDao loginInfoDao;

	public void init() {
		super.setDao(dao);
	}

	@Transactional
	public int addObject(StudentBasicInfo po) throws Exception {
		if (po.getSchool_id() == 0)
			po.setSchool_id(null);
		int superResult = super.addObject(po);
		StudentLoginInfo loginInfo = new StudentLoginInfo();
		loginInfo.setStudent_id(po.getStudent_id());
		loginInfo.setLogin_name(po.getStudent_phone());
		// loginInfo.setLogin_pwd(po.getIdentity_card_no().substring(12));
		loginInfo.setLogin_pwd(po.getLogin_pwd());
		loginInfo.setObligate_code(po.getObligate_code());
		if (superResult == 1 && loginInfoDao.addObject(loginInfo) == 1)
			return 1;
		else
			return 0;

	}

	@Transactional
	public int updateObjectById(StudentBasicInfo po) throws Exception {
		if (po.getSchool_id() == 0)
			po.setSchool_id(null);
		int result = super.updateObjectById(po);
		StudentLoginInfo loginInfo = new StudentLoginInfo();
		loginInfo.setLogin_id(po.getLogin_id());
		loginInfo.setStudent_id(po.getStudent_id());
		loginInfo.setLogin_name(po.getStudent_phone());
		loginInfo.setLogin_pwd(po.getLogin_pwd());
		loginInfo.setObligate_code(po.getObligate_code());
		result = loginInfoDao.updateObjectById(loginInfo);
		return result;
	}

	@Override
	public StudentBasicInfo downloadPhoto(Integer student_id) {
		return dao.downloadPhoto(student_id);
	}

	@Override
	public Integer getStuByIDCard(String identity_card_no) {
		// TODO Auto-generated method stub
		return dao.getStuByIDCard(identity_card_no);
	}

	@Override
	public List<GatherStudentInfo> gatherStudentInfo(Integer student_id) {
		if (student_id == null)
			throw new IllegalArgumentException("学员端显示统计信息时 student_id 为null");
		return dao.gatherStudentInfo(student_id);
	}

	@Override
	public Integer getStudentNumbers(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return dao.getStudentNumbers(map);
	}
	
	@Override
	public StudentBasicInfo getObjectById(Serializable student_id){
		StudentBasicInfo studentBasicInfo = super.getObjectById(student_id);
		if(studentBasicInfo.getStudent_level() > 0){
			Map<String, Object> map = dao.getCharteredCoachByStudentId((Integer)student_id);
			if(map != null){
				studentBasicInfo.setChartered_coach_id((Integer)map.get("chartered_coach_id"));
				studentBasicInfo.setChartered_coach_name((String)map.get("chartered_coach_name"));
			}else
				throw new RuntimeException("根据学员id获取学员包车教练信息时，学员信息不符");
		}
		return studentBasicInfo;
	}

	@Override
	public Map<String, Object> getStudentInfoByID(String idcard_no) {
		if(idcard_no == null)
			throw new IllegalArgumentException("根据学员身份证号获取学员信息时，身份证号为null");
		return dao.getStudentInfoByID(idcard_no);
	}
}