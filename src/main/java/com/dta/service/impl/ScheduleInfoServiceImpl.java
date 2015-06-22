package com.dta.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.DisplayCoachScheduleInfo;
import com.dta.bean.ScheduleInfo;
import com.dta.bean.SelectCoach;
import com.dta.dao.IScheduleInfoDao;
import com.dta.service.IScheduleInfoService;
import com.dta.vo.ScheduleInfoVo;
import com.dta.vo.SelectCoachVo;

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

	@Override
	public List<SelectCoach> selectCoach(SelectCoachVo vo) {
		if(vo.getSchool_id() == null)
			throw new IllegalArgumentException("学员端选择教练界面 显示教练信息时未知school_id");
		if(vo.getSubject() == null)
			throw new IllegalArgumentException("学员端选择教练界面 显示教练信息时未知subject");
		return dao.selectCoach(vo);
	}

	@Override
	public int selectCoachSize(SelectCoachVo vo) {
		if(vo.getSchool_id() == null)
			throw new IllegalArgumentException("学员端选择教练界面 显示教练信息时未知school_id");
		if(vo.getSubject() == null)
			throw new IllegalArgumentException("学员端选择教练界面 显示教练信息时未知subject");
		return dao.selectCoachSize(vo);
	}

	@Override
	public List<DisplayCoachScheduleInfo> displayCoachScheduleInfo(
			Map<String, Object> map) {
		if(map.get("coach_id") == null)
			throw new IllegalArgumentException("学员端选择教练界面 显示教练排班信息时未知school_id");
		if(map.get("schedule_date") == null)
			throw new IllegalArgumentException("学员端选择教练界面 显示教练排班信息时未知schedule_date");
		if(map.get("subject") == null)
			throw new IllegalArgumentException("学员端选择教练界面 显示教练排班信息时未知subject");
		return dao.displayCoachScheduleInfo(map);
	}
}