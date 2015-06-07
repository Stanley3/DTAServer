package com.dta.dao;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.StudentBasicInfoVo;
import com.dta.bean.StudentBasicInfo;
public interface IStudentBasicInfoDao extends IBaseAllDao<StudentBasicInfo, StudentBasicInfoVo> {
	public StudentBasicInfo downloadPhoto(Integer student_id);
	
	public Integer getStuByIDCard(String identity_card_no); 
}
