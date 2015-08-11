package com.dta.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.CoachBasicInfo;
import com.dta.bean.CoachInfo;
import com.dta.bean.CoachLoginSuccessInfo;
import com.dta.dao.ICoachBasicInfoDao;
import com.dta.service.ICoachBasicInfoService;
import com.dta.vo.CoachBasicInfoVo;

@Service
public class CoachBasicInfoServiceImpl extends
		BaseAllServiceImpl<CoachBasicInfo, CoachBasicInfoVo> implements
		ICoachBasicInfoService {
	@Autowired
	private ICoachBasicInfoDao dao;

	public void init() {
		super.setDao(dao);
	}

	public CoachBasicInfo downloadPhoto(int id) {
		return dao.downloadPhoto(id);
	}

	@Override
	public List<CoachBasicInfo> globalSearch(CoachBasicInfoVo vo) {
		String search = vo.getSearch();
		Pattern pattern = Pattern.compile("^\\d+$");
		Matcher matcher = pattern.matcher(search);
		if (matcher.matches()) {
			vo.setRegister_date(search);
			vo.setPhone(search);
		}
		vo.setCoach_name(search);
		vo.setSchool_name(search);
		if (vo.getRows() == -1)
			vo.setRows(0);
		return dao.globalSearch(vo);
	}

	@Override
	public int globalSearchSize(CoachBasicInfoVo vo) {
		return dao.globalSearchSize(vo);
	}

	@Override
	public CoachInfo getCoachInfo(Integer coach_id) {
		if (coach_id == null)
			throw new IllegalArgumentException("获取教练个人信息时 coach_id为null");
		return dao.getCoachInfo(coach_id);
	}

	@Override
	public CoachLoginSuccessInfo getCoachInfoByName(String loginName) {
		// TODO Auto-generated method stub
		return dao.getCoachInfoByName(loginName);
	}

	@Override
	public List<Integer> getAllCoachID() {
		return dao.getAllCoachID();
	}
}