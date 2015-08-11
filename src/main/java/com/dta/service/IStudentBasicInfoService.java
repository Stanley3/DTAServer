package com.dta.service;

import java.util.List;
import java.util.Map;

import com.dta.bean.GatherStudentInfo;
import com.dta.bean.StudentBasicInfo;
import com.dta.vo.StudentBasicInfoVo;

public interface IStudentBasicInfoService extends
		IBaseAllService<StudentBasicInfo, StudentBasicInfoVo> {
	public StudentBasicInfo downloadPhoto(Integer student_id);

	public Integer getStuByIDCard(String identity_card_no);

	/**
	 * 
	 * @param Integer
	 *            student_id
	 * @return List<GatherStudentInfo>
	 *         <p>
	 *         App学员端我统计信息
	 */
	public List<GatherStudentInfo> gatherStudentInfo(Integer student_id);

	/**
	 * 
	 * @param map
	 * @return <p>
	 *         根据条件获取学员的总数
	 *         <p>
	 *         所有学员的总数 student_level = null, subject = null <br>
	 *         包科二学员的总数 student_level = 2, subject = 2 <br>
	 *         包科三学员的总数 student_level = 3, subject = 3 <br>
	 *         普通科二学员的总数student_level = 0, subject = 2 <br>
	 *         普通科三学员的总数student_level = 0, subject = 3 <br>
	 * 
	 */
	public Integer getStudentNumbers(Map<String, Integer> map);
}