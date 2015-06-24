package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.LatestNumber;
import com.dta.dao.IGlobalDao;
import com.dta.service.IGlobalService;
import com.dta.vo.LatestNumberVo;

@Service
public class GlobalServiceImpl implements IGlobalService {
	@Autowired
	public IGlobalDao dao;
	@Override
	public LatestNumber getLatestNumber(LatestNumberVo vo) {
		if(vo.getCoach_id() == null)
			throw new IllegalArgumentException("循环获取最新的预约、取消预约和评价个数时，coach_id为null");
		if(vo.getLastQueryCancelTime() == null)
			throw new IllegalArgumentException("循环获取最新的预约、取消预约和评价个数时，lastQueryCancelTime为null");
		if(vo.getLastQueryEvaluationTime() == null)
			throw new IllegalArgumentException("循环获取最新的预约、取消预约和评价个数时，lastQueryEvaluationTime为null");
		if(vo.getLastQueryPrecontractTime() == null)
			throw new IllegalArgumentException("循环获取最新的预约、取消预约和评价个数时，lastQueryPrecontractTime为null");
		return dao.getLatestNumber(vo);
	}

}
