package com.dta.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dta.bean.NewsInfo;
import com.dta.dao.INewsInfoDao;
import com.dta.service.INewsInfoService;

@Service
public class NewsInfoServiceImpl extends BaseAllServiceImpl<NewsInfo, NewsInfo> implements INewsInfoService{
	@Resource
	private INewsInfoDao dao;
	
	//spring实例化NewsInfoServiceImple后回掉该方法
	//@PostConstruct
	public void init(){
		//System.out.println("\n\n\n in initMethod dao is null ?" + (dao == null));
		//System.out.println("*******初始化newsInfoServiceImpl********");
		super.setDao(dao);
	}
	
}