package com.dta.service;

import com.dta.bean.StudentBasicInfo;
import com.dta.vo.StudentBasicInfoVo;

public interface IStudentBasicInfoService extends IBaseAllService<StudentBasicInfo, StudentBasicInfoVo>{
	public StudentBasicInfo downloadPhoto(Integer student_id);
	
	public Integer getStuByIDCard(String identity_card_no);
}