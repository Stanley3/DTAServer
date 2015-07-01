package com.dta.dao;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.CoachBasicInfoVo;
import com.dta.bean.CoachBasicInfo;
import com.dta.bean.CoachInfo;
public interface ICoachBasicInfoDao extends IBaseAllDao<CoachBasicInfo, CoachBasicInfoVo> {
	public CoachBasicInfo downloadPhoto(int id);
	
	/**
	 * 
	 * @param coach_id
	 * @return CoachInfo
	 * <p>App端获取教练个人信息
	 */
	public CoachInfo getCoachInfo(Integer coach_id);
	
	/**
	 * 
	 * @param loginName//暂定手机号为登录名
	 * @return coach_id
	 * <p>根据coach_
	 */
	public Integer getCoachInfoByName(String loginName);
}
