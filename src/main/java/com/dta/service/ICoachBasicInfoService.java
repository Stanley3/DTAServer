package com.dta.service;

import com.dta.bean.CoachBasicInfo;

public interface ICoachBasicInfoService extends IBaseAllService<CoachBasicInfo, CoachBasicInfo>{
	public CoachBasicInfo downloadPhoto(int id);
}