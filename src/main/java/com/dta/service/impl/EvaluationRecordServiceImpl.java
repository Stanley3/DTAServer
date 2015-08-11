package com.dta.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.bean.AllEvaluationRecord;
import com.dta.bean.CoachEvaluationInfo;
import com.dta.bean.EvaluationAndOrderInfo;
import com.dta.bean.EvaluationRecord;
import com.dta.bean.MapBean;
import com.dta.dao.IEvaluationRecordDao;
import com.dta.service.IEvaluationRecordService;
import com.dta.service.IOrderRecordService;
import com.dta.vo.AllEvaluationRecordVo;
import com.dta.vo.CoachEvaluationInfoVo;
import com.dta.vo.EvaluationRecordVo;

@Service
public class EvaluationRecordServiceImpl extends
		BaseAllServiceImpl<EvaluationRecord, EvaluationRecordVo> implements
		IEvaluationRecordService {
	@Autowired
	private IEvaluationRecordDao dao;
	@Autowired
	private IOrderRecordService orderRecordService;

	public void init() {
		super.setDao(dao);
	}

	@Override
	public List<AllEvaluationRecord> getAllEvaRec(AllEvaluationRecordVo vo) {
		// TODO Auto-generated method stub
		return dao.getAllEvaRec(vo);
	}

	@Override
	public int getAllEvaRecSize(AllEvaluationRecordVo vo) {
		// TODO Auto-generated method stub
		System.out.println(vo.getEvaluation());
		return dao.getAllEvaRecSize(vo);
	}

	@Override
	public List<AllEvaluationRecord> globalSearch(AllEvaluationRecordVo vo) {
		// TODO Auto-generated method stub
		return dao.globalSearch(vo);
	}

	@Override
	public int globalSearchSize(AllEvaluationRecordVo vo) {
		// TODO Auto-generated method stub
		return dao.globalSearchSize(vo);
	}

	@Override
	public EvaluationAndOrderInfo getEvaAndOrdById(Integer evaluation_record_id)
			throws Exception {
		// TODO Auto-generated method stub
		if (evaluation_record_id == null)
			throw new Exception("未知的评价id(evaluation_record_id)");
		return dao.getEvaAndOrdById(evaluation_record_id);
	}

	@Override
	public List<CoachEvaluationInfo> getCoachEvaluationInfo(
			CoachEvaluationInfoVo vo) {
		if (vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练的评价信息时coach_id为null");
		return dao.getCoachEvaluationInfo(vo);
	}

	@Override
	public int getCoachEvaluationInfoSize(CoachEvaluationInfoVo vo) {
		if (vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练的评价信息时coach_id为null");
		return dao.getCoachEvaluationInfoSize(vo);
	}

	@Override
	public List<MapBean> getEvaluationSize(CoachEvaluationInfoVo vo) {
		if (vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练的评价个数时coach_id为null");
		return dao.getEvaluationSize(vo);
	}

	/**
	 * @param EvaluationRecord
	 *            po
	 * @return 0 或 1
	 *         <p>
	 *         0表示添加评价失败，1表示添加评价成功
	 *         <p>
	 *         添加一条评价记录，暂默认为增添评价时表明订单已完成，应修改订单的状态为3；
	 *         修改订单的状态为3时，应修改财务信息记录表的收入总额字段
	 * @throws Exception
	 */
	@Override
	@Transactional
	public int addObject(EvaluationRecord po) throws Exception {
		int skill, service_attitude, hygiene;
		skill = po.getSkill() != null ? po.getSkill() : 0;
		service_attitude = po.getService_attitude() != null ? po
				.getService_attitude() : 0;
		hygiene = po.getHygiene() != null ? po.getHygiene() : 0;
		int sum = skill + service_attitude + hygiene;
		if (sum <= 10)
			po.setEvaluation(0);
		else if (sum <= 20)
			po.setEvaluation(1);
		else
			po.setEvaluation(2);
		// 以上是根据评分计算好中差评，计算公式未知，暂如上计算。
		if (po.getEvaluation_record_id() == null) {// 新增评价
			if (orderRecordService.completeOrder(po.getOrder_id()))
				return super.addObject(po);
			else
				return 0;
		} else
			// 修改评价
			return super.updateObjectById(po);
	}
}