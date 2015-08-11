package com.dta.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.SysTotalOutcome;
import com.dta.dao.ISysTotalOutcomeDao;
import com.dta.service.ISysTotalOutcomeService;
import com.dta.vo.SysTotalOutcomeVo;

@Service
public class SysTotalOutcomeServiceImple extends
		BaseAllServiceImpl<SysTotalOutcome, SysTotalOutcomeVo> implements
		ISysTotalOutcomeService {
	@Autowired
	private ISysTotalOutcomeDao dao;

	public void init() {
		super.setDao(dao);
	}
}