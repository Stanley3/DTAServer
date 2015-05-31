package com.dta.service;

import com.dta.bean.SchoolInfo;
import com.dta.vo.SchoolInfoVo;

public interface ISchoolInfoService extends IBaseAllService<SchoolInfo, SchoolInfoVo>{
	public int getAvaiableCoachNumbers(int school_id);
}