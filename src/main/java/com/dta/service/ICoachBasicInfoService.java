package com.dta.service;

import java.util.List;

import com.dta.bean.CoachBasicInfo;
import com.dta.vo.CoachBasicInfoVo;

public interface ICoachBasicInfoService extends IBaseAllService<CoachBasicInfo, CoachBasicInfoVo>{
	public CoachBasicInfo downloadPhoto(int id);
	public List<CoachBasicInfo> globalSearch(CoachBasicInfoVo vo);
	public int globalSearchSize(CoachBasicInfoVo vo);
}