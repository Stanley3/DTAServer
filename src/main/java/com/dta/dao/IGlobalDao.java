package com.dta.dao;

import com.dta.bean.LatestNumber;
import com.dta.vo.LatestNumberVo;

public interface IGlobalDao {
	/**
	 * 
	 * @param LatestNumberVo
	 *            vo
	 * @return LatestNumber
	 *         <p>
	 *         App教练端循环查询最新的预约、取消预约、评价的个数
	 */
	public LatestNumber getLatestNumber(LatestNumberVo vo);
}
