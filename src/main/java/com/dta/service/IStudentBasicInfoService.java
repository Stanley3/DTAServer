package com.dta.service;

import java.util.List;

import com.dta.bean.GatherStudentInfo;
import com.dta.bean.StudentBasicInfo;
import com.dta.vo.StudentBasicInfoVo;

public interface IStudentBasicInfoService extends IBaseAllService<StudentBasicInfo, StudentBasicInfoVo>{
	public StudentBasicInfo downloadPhoto(Integer student_id);
	
	public Integer getStuByIDCard(String identity_card_no);
	
	/**
	 * 
	 * @param Integer student_id
	 * @return List<GatherStudentInfo>
	 * <p>App学员端我统计信息
	 */
	public List<GatherStudentInfo> gatherStudentInfo(Integer student_id);
}