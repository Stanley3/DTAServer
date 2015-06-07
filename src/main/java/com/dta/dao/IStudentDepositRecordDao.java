package com.dta.dao;

import java.util.List;

import com.dta.dao.base.IBaseAllDao;
import com.dta.vo.ShowDepositRecordVo;
import com.dta.vo.StudentDepositRecordVo;
import com.dta.bean.ShowDepositRecord;
import com.dta.bean.StudentDepositRecord;
public interface IStudentDepositRecordDao extends IBaseAllDao<StudentDepositRecord, StudentDepositRecordVo> {
	/**
	 * 
	 * @param ShowDepositRecordVo vo
	 * @return List<ShowDepositRecord>
	 * web充值记录界面 获取学员的充值信息
	 */
	public List<ShowDepositRecord> getStuDepInfo(ShowDepositRecordVo vo);
	
	public int getStuDepInfoSize(ShowDepositRecordVo vo);
	
	/**
	 * 
	 * @param ShowDepositRecordVo vo
	 * @return List<ShowDepositRecord>
	 * web充值记录界面 获取学员的充值信息 全局搜索
	 */
	public List<ShowDepositRecord> globalSerach(ShowDepositRecordVo vo);
	
	public int globalSerachSize(ShowDepositRecordVo vo);
}