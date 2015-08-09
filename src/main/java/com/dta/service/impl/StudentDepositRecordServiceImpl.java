package com.dta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.bean.DisplayStudentDepositReocrd;
import com.dta.bean.ShowDepositRecord;
import com.dta.bean.StudentBasicInfo;
import com.dta.bean.StudentDepositRecord;
import com.dta.bean.VIPStudentOfCoachInfo;
import com.dta.dao.IStudentBasicInfoDao;
import com.dta.dao.IStudentDepositRecordDao;
import com.dta.service.IStudentDepositRecordService;
import com.dta.service.IStudentFinanceInfoService;
import com.dta.vo.DisplayStudentDepositRecordVo;
import com.dta.vo.ShowDepositRecordVo;
import com.dta.vo.StudentDepositRecordVo;
import com.dta.vo.VIPStudentOfCoachInfoVo;

@Service
public class StudentDepositRecordServiceImpl extends BaseAllServiceImpl<StudentDepositRecord, StudentDepositRecordVo> implements IStudentDepositRecordService{
	@Autowired
	private IStudentDepositRecordDao dao;
	@Autowired
	private IStudentBasicInfoDao studentDao;
	@Autowired
	private IStudentFinanceInfoService studentFinanceInfoService;
	public void init(){
		super.setDao(dao);
	}

	@Override
	public List<ShowDepositRecord> getStuDepInfo(ShowDepositRecordVo vo) {
		// TODO Auto-generated method stub
		
		return dao.getStuDepInfo(vo);
	}

	@Override
	public int getStuDepInfoSize(ShowDepositRecordVo vo) {
		// TODO Auto-generated method stub
		return dao.getStuDepInfoSize(vo);
	}

	@Override
	public List<ShowDepositRecord> globalSerach(ShowDepositRecordVo vo) {
		// TODO Auto-generated method stub
		return dao.globalSerach(vo);
	}

	@Override
	public int globalSerachSize(ShowDepositRecordVo vo) {
		// TODO Auto-generated method stub
		return dao.globalSerachSize(vo);
	}
	
	@Override
	@Transactional
	public int addObject(StudentDepositRecord po) throws Exception{
		int result = 0;
		if(po.getDeposit_type() != null && po.getDeposit_type() != 0){ //更新学员的状态为vip
			StudentBasicInfo studentBasicInfo = new StudentBasicInfo();
			studentBasicInfo.setStudent_level(po.getDeposit_type() - 1);
			studentBasicInfo.setStudent_id(po.getStudent_id());
			result = studentDao.updateObjectById(studentBasicInfo);
		}
		result = super.addObject(po);
		result = studentFinanceInfoService.addOrUpdateStudentFinanceInfo(po.getStudent_id(), Double.valueOf(po.getDeposit_amount()));
		return result;
	}

	@Override
	public List<VIPStudentOfCoachInfo> getVIPStudentOfCoachInfo(
			VIPStudentOfCoachInfoVo vo) {
		if(vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练名下VIP学员列表时 coach_id 为null");
		return dao.getVIPStudentOfCoachInfo(vo);	
	}

	@Override
	public int getVIPStudentOfCoachInfoSize(VIPStudentOfCoachInfoVo vo) {
		if(vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练名下VIP学员列表时 coach_id 为null");
		return dao.getVIPStudentOfCoachInfoSize(vo);	
	}

	@Override
	public List<DisplayStudentDepositReocrd> displayStudentDepositRecord(
			DisplayStudentDepositRecordVo vo) {
		if(vo.getStudent_id() == null)
			throw new IllegalArgumentException("学员端获取学员充值记录时，学员id student_id 为null");
		return dao.displayStudentDepositRecord(vo);
	}

	@Override
	public int displayStudentDepositRecordSize(DisplayStudentDepositRecordVo vo) {
		if(vo.getStudent_id() == null)
			throw new IllegalArgumentException("学员端获取学员充值记录时，学员id student_id 为null");
		return dao.displayStudentDepositRecordSize(vo);
	}
}