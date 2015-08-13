package com.dta.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.SchoolInfoBasedDistanceVo;
import com.dta.vo.SchoolInfoVo;
import com.dta.bean.SchoolInfo;
import com.dta.bean.SchoolInfoBasedDistance;

public interface ISchoolInfoDao extends IBaseAllDao<SchoolInfo, SchoolInfoVo> {
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
	
	public int getSchoolInfoSize(@Param(value="subject")Integer subject);
}
