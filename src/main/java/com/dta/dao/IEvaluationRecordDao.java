package com.dta.dao;

import java.util.List;
import java.util.Map;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.AllEvaluationRecordVo;
import com.dta.vo.EvaluationRecordVo;
import com.dta.bean.AllEvaluationRecord;
import com.dta.bean.EvaluationAndOrderInfo;
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
	
	/**
	 * 
	 * @param Integer evaluation_record_id
	 * @return EvaluationAndOrderInfo
	 * web查看评价详情界面用的bean 根据评价id获取订单和相关评价的内容
	 */
	public EvaluationAndOrderInfo getEvaAndOrdById(Integer evaluation_record_id);
}
