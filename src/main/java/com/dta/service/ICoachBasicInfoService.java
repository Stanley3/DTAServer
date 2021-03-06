package com.dta.service;

import java.util.List;

import com.dta.bean.CoachBasicInfo;
import com.dta.bean.CoachInfo;
import com.dta.bean.CoachLoginSuccessInfo;
import com.dta.vo.CoachBasicInfoVo;

public interface ICoachBasicInfoService extends
		IBaseAllService<CoachBasicInfo, CoachBasicInfoVo> {
	public CoachBasicInfo downloadPhoto(int id);

	public List<CoachBasicInfo> globalSearch(CoachBasicInfoVo vo);

	public int globalSearchSize(CoachBasicInfoVo vo);

	/**
	 * 
	 * @param coach_id
	 * @return CoachInfo
	 *         <p>
	 *         App端获取教练个人信息
	 */
	public CoachInfo getCoachInfo(Integer coach_id);

	/**
	 * 
	 * @param loginName
	 *            //暂定手机号为登录名
	 * @return coach_id
	 *         <p>
	 *         根据coach_
	 */
	public CoachLoginSuccessInfo getCoachInfoByName(String loginName);

	/**
	 * 
	 * @return List<Integer>
	 *         <p>
	 *         返回所有的教练id
	 */
	public List<Integer> getAllCoachID();
}