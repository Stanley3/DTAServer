package com.dta.service;

import java.util.List;

import com.dta.bean.SchoolInfo;
import com.dta.bean.SchoolInfoBasedDistance;
import com.dta.vo.SchoolInfoBasedDistanceVo;
import com.dta.vo.SchoolInfoVo;

public interface ISchoolInfoService extends
		IBaseAllService<SchoolInfo, SchoolInfoVo> {
	public int getAvaiableCoachNumbers(int school_id);

	/**
	 * 
	 * @param SchoolInfoBasedDistanceVo
	 *            vo
	 * @return List<SchoolInfoBasedDistance>
	 *         <p>
	 *         App端获取驾校信息，以便计算和驾校的距离
	 */
	public List<SchoolInfoBasedDistance> getSchoolDistanceInfo(
			SchoolInfoBasedDistanceVo vo);

	/**
	 * 
	 * @param SchoolInfoBasedDistanceVo
	 *            vo
	 * @return int
	 *         <p>
	 *         App端获取驾校的总数
	 */
	public int getSchoolDistanceInfoSize(SchoolInfoBasedDistanceVo vo);
	
	/**
	 * 
	 * @param vo
	 * @return
	 * <p>根据学员id和学员科目获取学员驾校和所有和学员科目相符的考场
	 */
	public List<SchoolInfoBasedDistance> getSchoolInfo(SchoolInfoVo vo);
	
	public int getSchoolInfoSize(Integer subject);
}