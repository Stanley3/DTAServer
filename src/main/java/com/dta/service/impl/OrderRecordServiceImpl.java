package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.bean.CoachBasicInfo;
import com.dta.bean.OrderRecord;
import com.dta.dao.ICoachBasicInfoDao;
import com.dta.dao.IOrderRecordDao;
import com.dta.service.IOrderRecordService;
import com.dta.vo.OrderRecordVo;

@Service
public class OrderRecordServiceImpl extends BaseAllServiceImpl<OrderRecord, OrderRecordVo> implements IOrderRecordService{
	@Autowired
	private IOrderRecordDao dao;
	@Autowired
	private ICoachBasicInfoDao coachDao;
	
	public void init(){
		super.setDao(dao);
	}
	
	
	@Transactional
	public int updateObjectById(OrderRecord po) throws Exception {
		System.out.println("子类的更新方法得到执行");
		if(po.getOrder_status() == 3){
			int count = coachDao.getObjectById(po.getCoach_id()).getService_count();
			CoachBasicInfo coach = new CoachBasicInfo();
			coach.setService_count(count + 1);
			coach.setCoach_id(po.getCoach_id());
			int result = coachDao.updateObjectById(coach);
			if(result != 1)
				throw new Exception("订单完成后，更新教练服务次数失败。");
		}
		return super.updateObjectById(po);
	}
}