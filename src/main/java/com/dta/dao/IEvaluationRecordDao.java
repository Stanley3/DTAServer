package com.dta.dao;

import java.util.List;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.AllEvaluationRecordVo;
import com.dta.vo.EvaluationRecordVo;
import com.dta.bean.AllEvaluationRecord;
import com.dta.bean.EvaluationRecord;
public interface IEvaluationRecordDao extends IBaseAllDao<EvaluationRecord, EvaluationRecordVo> {
	
	/**
	 * 
	 * @param AllEvaluationRecordVo vo
	 * @return List<AllEvaluationRecord> 
	 * 查询所有的评价
	 */
	public List<AllEvaluationRecord> getAllEvaRec(AllEvaluationRecordVo vo);
	
	/**
	 * 
	 * @param AllEvaluationRecordVo vo
	 * @return int
	 * 得到所有评价的总数
	 */
	public int getAllEvaRecSize(AllEvaluationRecordVo vo);
	
	/**
	 * 
	 * @param AllEvaluationRecordVo vo
	 * @return List<AllEvaluationRecord>
	 * 全局搜索评价
	 */
	public List<AllEvaluationRecord> globalSearch(AllEvaluationRecordVo vo);
	
	/**
	 * 
	 * @param AllEvaluationRecordVo vo
	 * @return List<AllEvaluationRecord>
	 * 全局搜索评价总数
	 */
	public int globalSearchSize(AllEvaluationRecordVo vo);
	
	
}
