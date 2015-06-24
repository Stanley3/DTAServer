package com.dta.service;

import com.dta.bean.LatestNumber;
import com.dta.vo.LatestNumberVo;

public interface IGlobalService {
	/**
	 * 
	 * @param LatestNumberVo vo
	 * @return LatestNumber
	 * <p>App教练端循环查询最新的预约、取消预约、评价的个数
	 */
	public LatestNumber getLatestNumber(LatestNumberVo vo);
}
