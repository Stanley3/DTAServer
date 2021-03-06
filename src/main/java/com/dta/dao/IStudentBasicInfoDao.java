package com.dta.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.StudentBasicInfoVo;
import com.dta.bean.GatherStudentInfo;
import com.dta.bean.StudentBasicInfo;

public interface IStudentBasicInfoDao extends
		IBaseAllDao<StudentBasicInfo, StudentBasicInfoVo> {
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
	
	/**
	 * 
	 * @param student_id
	 * @return
	 * <p>根据学员id获取学员包车教练的信息
	 */
	public Map<String, Object> getCharteredCoachByStudentId(@Param(value="student_id")Integer student_id);
	
	/**
	 * 
	 * @param idcard_no
	 * @return
	 * <p>根据学员的身份证号获取学员的信息
	 */
	public Map<String, Object> getStudentInfoByID(@Param(value="idcard_no")String idcard_no);
}
