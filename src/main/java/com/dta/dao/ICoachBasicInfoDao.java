package com.dta.dao;

import com.dta.dao.base.IBaseAllDao;
import com.dta.bean.CoachBasicInfo;
public interface ICoachBasicInfoDao extends IBaseAllDao<CoachBasicInfo, CoachBasicInfo> {
	public CoachBasicInfo downloadPhoto(int id);
}
