package com.dta.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.dta.dao.IWebMainPageDao;
import com.dta.service.IWebMainPageService;

@Service
public class WebMainPageServiceImpl implements IWebMainPageService {
	@Autowired
	private IWebMainPageDao dao;

	@Override
	public Map<String, Integer> getStaticInfo(String username) {
		// TODO Auto-generated method stub
		if (!StringUtils.hasText(username))
			throw new IllegalArgumentException("统计web端主页面信息时 username为空");
		return dao.getStaticInfo(username);
	}

}
