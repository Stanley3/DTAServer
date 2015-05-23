package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.bean.CoachWithdrawRecord;
import com.dta.bean.SchoolOutcomeRecord;
import com.dta.dao.ICoachWithdrawRecordDao;
import com.dta.dao.ISchoolOutcomeRecordDao;
import com.dta.service.ISchoolOutcomeRecordService;
import com.dta.vo.SchoolOutcomeRecordVo;

@Service
public class SchoolOutcomeRecordServiceImpl extends BaseAllServiceImpl<SchoolOutcomeRecord, SchoolOutcomeRecordVo> implements ISchoolOutcomeRecordService{
	@Autowired
	private ISchoolOutcomeRecordDao dao;
	@Autowired
	private ICoachWithdrawRecordDao withdrawRecordDao;
	
	public void init(){
		super.setDao(dao);
	}
	
	@Transactional
	public int addObject(SchoolOutcomeRecord po){
		int superResult = super.addObject(po);
		CoachWithdrawRecord withdrawBean = new CoachWithdrawRecord();
		withdrawBean.setWithdraw_amount(po.getAmount());
		withdrawBean.setDrawee(po.getOperator());
		withdrawBean.setWithdraw_status(1);
		withdrawBean.setCoach_id(po.getPayee());
		if(superResult == 1 && withdrawRecordDao.addObject(withdrawBean) == 1){
			return 1;
		}else
			return 0;
	}
}