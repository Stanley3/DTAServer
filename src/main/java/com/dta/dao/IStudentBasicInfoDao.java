package com.dta.dao;

import java.util.List;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.StudentBasicInfoVo;
import com.dta.bean.GatherStudentInfo;
import com.dta.bean.StudentBasicInfo;
public interface IStudentBasicInfoDao extends IBaseAllDao<StudentBasicInfo, StudentBasicInfoVo> {
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
