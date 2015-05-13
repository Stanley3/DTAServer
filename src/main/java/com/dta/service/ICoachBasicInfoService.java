package com.dta.service;

import com.dta.bean.CoachBasicInfo;
import com.dta.vo.CoachBasicInfoVo;

public interface ICoachBasicInfoService extends IBaseAllService<CoachBasicInfo, CoachBasicInfoVo>{
	public CoachBasicInfo downloadPhoto(int id);
}