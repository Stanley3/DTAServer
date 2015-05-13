package com.dta.dao;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.CoachBasicInfoVo;
import com.dta.bean.CoachBasicInfo;
public interface ICoachBasicInfoDao extends IBaseAllDao<CoachBasicInfo, CoachBasicInfoVo> {
	public CoachBasicInfo downloadPhoto(int id);
}
