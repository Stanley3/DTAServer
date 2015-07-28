package com.dta.dao;

import java.util.List;
import java.util.Map;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.ScheduleInfoVo;
import com.dta.vo.SelectCoachVo;
import com.dta.bean.DisplayCoachScheduleInfo;
import com.dta.bean.ScheduleInfo;
import com.dta.bean.SelectCoach;
public interface IScheduleInfoDao extends IBaseAllDao<ScheduleInfo, ScheduleInfoVo> {
	
	/**
	 * 
	 * @param SelectCoachVo vo
	 * @return List<SelectCoach>
	 * <p>App学员端选择教练界面 获取教练的信息
	 */
	public List<SelectCoach> selectCoach(SelectCoachVo vo);
	
	/**
	 * 
	 * @param SelectCoachVo vo
	 * @return int
	 * <p>App学员端选择教练界面 获取教练的总数
	 */
	public int selectCoachSize(SelectCoachVo vo);
	
	/**
	 * 
	 * @param Map<String, Object> map
	 * @return List<DisplayCoachScheduleInfo>
	 * <p>App学员端获取教练某天的排班信息
	 */
	public List<DisplayCoachScheduleInfo> displayCoachScheduleInfo(Map<String, Object>map);
	
	/**
	 * 
	 * @param coach_id
	 * @return int
	 * <p>批量生成教练的4天的排班信息，科目按最近一天设置，无则设为科目二
	 */
	public int batchGenerateScheduleInfo(Integer coach_id);
	
	public ScheduleInfo getObjectByCoachIdAndScheduleDate(Map<String,Object>map);
}
