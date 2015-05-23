package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.bean.StudentBasicInfo;
import com.dta.bean.StudentLoginInfo;
import com.dta.dao.IStudentBasicInfoDao;
import com.dta.dao.IStudentLoginInfoDao;
import com.dta.service.IStudentBasicInfoService;
import com.dta.vo.StudentBasicInfoVo;

@Service
public class StudentBasicInfoServiceImpl extends BaseAllServiceImpl<StudentBasicInfo, StudentBasicInfoVo> implements IStudentBasicInfoService{
	@Autowired
	private IStudentBasicInfoDao dao;
	@Autowired
	private IStudentLoginInfoDao loginInfoDao;
	
	public void init(){
		super.setDao(dao);
	}
	
	@Transactional
	public int addObject(StudentBasicInfo po){
		int superResult = super.addObject(po);
		StudentLoginInfo loginInfo = new StudentLoginInfo();
		loginInfo.setStudent_id(po.getStudent_id());
		loginInfo.setLogin_name(po.getStudent_phone());
		loginInfo.setLogin_pwd(po.getIdentity_card_no().substring(12));
		if(superResult == 1 && loginInfoDao.addObject(loginInfo) == 1)
			return 1;
		else 
			return 0;
		
	}
}