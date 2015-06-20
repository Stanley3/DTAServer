package com.dta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.ScheduleInfo;
import com.dta.dao.IScheduleInfoDao;
import com.dta.service.IScheduleInfoService;
import com.dta.vo.ScheduleInfoVo;

@Service
public class ScheduleInfoServiceImpl extends BaseAllServiceImpl<ScheduleInfo, ScheduleInfoVo> implements IScheduleInfoService{
	@Autowired
	private IScheduleInfoDao dao;
	
	public void init(){
		super.setDao(dao);
	}
	
	@Override
	public List<ScheduleInfo> getAll(ScheduleInfoVo vo) {
		if(vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练排版信息时 coach_id 为null");
		if(vo.getStartScheduleDate() == null || vo.getStartScheduleDate().isEmpty())
			throw new IllegalArgumentException("获取教练排班信息时 startScheduleDate 为null");
		if(vo.getEndScheduleDate() == null || vo.getEndScheduleDate().isEmpty())
			throw new IllegalArgumentException("获取教练排班信息时 endScheduleDate 为null");
		return dao.getAll(vo);
	}
}