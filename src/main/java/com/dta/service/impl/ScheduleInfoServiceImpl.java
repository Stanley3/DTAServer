package com.dta.service.impl;

import java.util.HashMap;
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

	@Override
	public int batchGenerateScheduleInfo(Integer coach_id) {
		if(coach_id == null)
			throw new IllegalArgumentException("自动生成教练排班信息时，教练coach_id为nul");
		return dao.batchGenerateScheduleInfo(coach_id);
	}

	@Override
	public boolean isScheduled(Integer schedule_id, int index) {
		// TODO Auto-generated method stub
		if(schedule_id == null)
			throw new IllegalArgumentException("提交预约信息时，排班id(schedule_id)为null");
		boolean result = false;
		ScheduleInfo scheduleInfo = dao.getObjectById(schedule_id);
		String content = scheduleInfo.getContent();
		String student_toplimit = scheduleInfo.getStudent_toplimit();
		String precontract_info = scheduleInfo.getPrecontranct_info();
		int toplimit = Integer.valueOf(student_toplimit.substring(index, index+1));
		int hasPrecontractNumbers = Integer.valueOf(precontract_info.substring(index, index+1));
		int hasScheduled = Integer.valueOf(content.substring(index, index+1));
		if(hasScheduled != 0 && toplimit - hasPrecontractNumbers > 0){
			++hasPrecontractNumbers;
			String new_precontract_info = precontract_info.substring(0, index) + hasPrecontractNumbers + precontract_info.substring(index+1, 24);
			ScheduleInfo po = new ScheduleInfo();
			po.setPrecontranct_info(new_precontract_info);
			po.setSchedule_id(schedule_id);
			if(dao.updateObjectById(po) == 1)
				result = true;
		}
		return result;
	}
	
	public Integer getScheduleIdByCoachIdAndDate(Integer coach_id, String date){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("coach_id", coach_id);
		map.put("schedule_date", date);
		return dao.getScheduleIdByCoachIdAndDate(map);
	}
}