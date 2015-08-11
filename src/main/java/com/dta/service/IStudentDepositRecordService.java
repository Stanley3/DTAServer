package com.dta.service;

import java.util.List;

import com.dta.bean.DisplayStudentDepositReocrd;
import com.dta.bean.ShowDepositRecord;
import com.dta.bean.StudentDepositRecord;
import com.dta.bean.VIPStudentOfCoachInfo;
import com.dta.vo.DisplayStudentDepositRecordVo;
import com.dta.vo.ShowDepositRecordVo;
import com.dta.vo.StudentDepositRecordVo;
import com.dta.vo.VIPStudentOfCoachInfoVo;

public interface IStudentDepositRecordService extends
		IBaseAllService<StudentDepositRecord, StudentDepositRecordVo> {
	/**
	 * 
	 * @param ShowDepositRecordVo
	 *            vo
	 * @return List<ShowDepositRecord> web充值记录界面 获取学员的充值信息
	 */
	public List<ShowDepositRecord> getStuDepInfo(ShowDepositRecordVo vo);

	public int getStuDepInfoSize(ShowDepositRecordVo vo);

	/**
	 * 
	 * @param ShowDepositRecordVo
	 *            vo
	 * @return List<ShowDepositRecord> web充值记录界面 获取学员的充值信息 全局搜索
	 */
	public List<ShowDepositRecord> globalSerach(ShowDepositRecordVo vo);

	public int globalSerachSize(ShowDepositRecordVo vo);

	/**
	 * 
	 * @param VIPStudentOfCoachInfoVo
	 *            vo
	 * @return List<VIPStudentOfCoachInfo>
	 *         <p>
	 *         App端获取教练名下VIP学员列表
	 */
	public List<VIPStudentOfCoachInfo> getVIPStudentOfCoachInfo(
			VIPStudentOfCoachInfoVo vo);

	/**
	 * 
	 * @param VIPStudentOfCoachInfoVo
	 *            vo
	 * @return List<VIPStudentOfCoachInfo>
	 *         <p>
	 *         App端获取教练名下VIP学员的总数
	 */
	public int getVIPStudentOfCoachInfoSize(VIPStudentOfCoachInfoVo vo);

	/**
	 * 
	 * @param DisplayStudentDepositRecordVo
	 *            vo
	 * @return List<DisplayStudentDepositReocrd>
	 *         <p>
	 *         App学员端 获取学员的充值记录
	 */
	public List<DisplayStudentDepositReocrd> displayStudentDepositRecord(
			DisplayStudentDepositRecordVo vo);

	/**
	 * 
	 * @param DisplayStudentDepositRecordVo
	 *            vo
	 * @return List<DisplayStudentDepositReocrd>
	 *         <p>
	 *         App学员端 获取学员充值记录的总数
	 */
	public int displayStudentDepositRecordSize(DisplayStudentDepositRecordVo vo);

	/**
	 * 
	 * @param school_id
	 * @return <p>
	 *         获取已充值的学员总额
	 */
	public Integer getDepositedStudentNumbers(Integer school_id);
}