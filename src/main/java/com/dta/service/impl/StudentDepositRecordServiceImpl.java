package com.dta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.ShowDepositRecord;
import com.dta.bean.StudentDepositRecord;
import com.dta.dao.IStudentDepositRecordDao;
import com.dta.service.IStudentDepositRecordService;
import com.dta.vo.ShowDepositRecordVo;
import com.dta.vo.StudentDepositRecordVo;

@Service
public class StudentDepositRecordServiceImpl extends BaseAllServiceImpl<StudentDepositRecord, StudentDepositRecordVo> implements IStudentDepositRecordService{
	@Autowired
	private IStudentDepositRecordDao dao;
	
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
}