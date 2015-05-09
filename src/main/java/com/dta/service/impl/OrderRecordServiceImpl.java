package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.OrderRecord;
import com.dta.dao.IOrderRecordDao;
import com.dta.service.IOrderRecordService;

@Service
public class OrderRecordServiceImpl extends BaseAllServiceImpl<OrderRecord, OrderRecord> implements IOrderRecordService{
	@Autowired
	private IOrderRecordDao dao;
	
	public void init(){
		super.setDao(dao);
	}
}