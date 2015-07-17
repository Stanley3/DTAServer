package com.dta.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dta.bean.AllEvaluationRecord;
import com.dta.bean.CoachBasicInfo;
import com.dta.bean.CoachFianceSummarizing;
import com.dta.bean.CoachIncomeRecord;
import com.dta.bean.CoachPrecontractRecord;
import com.dta.bean.CoachTeachRecord;
import com.dta.bean.MyOrderRecord;
import com.dta.bean.OrderInfo;
import com.dta.bean.OrderRecord;
import com.dta.bean.SchoolInfo;
import com.dta.bean.TrainingRecord;
import com.dta.dao.ICoachBasicInfoDao;
import com.dta.dao.IOrderRecordDao;
import com.dta.dao.ISchoolInfoDao;
import com.dta.dao.IStudentDepositRecordDao;
import com.dta.service.IOrderRecordService;
import com.dta.vo.CoachIncomeRecordVo;
import com.dta.vo.CoachPrecontractRecordVo;
import com.dta.vo.CoachTeachRecordVo;
import com.dta.vo.MyOrderRecordVo;
import com.dta.vo.OrderInfoVo;
import com.dta.vo.OrderRecordVo;
import com.dta.vo.TrainingRecordVo;

@Service
public class OrderRecordServiceImpl extends BaseAllServiceImpl<OrderRecord, OrderRecordVo> implements IOrderRecordService{
	@Autowired
	private IOrderRecordDao dao;
	@Autowired
	private ICoachBasicInfoDao coachDao;
	@Autowired
	private ISchoolInfoDao schoolDao;
	@Autowired
	private IStudentDepositRecordDao depositDao;
	public void init(){
		super.setDao(dao);
	}
	
	@Override
	@Transactional
	public int addObject(OrderRecord po){
		String[] scheduleDateArray = po.getScheduleDateStr().split("|");
		String[] precontractContentArray = po.getPrecontractContentStr().split("|");
		int orderNumber = 0;
		for(int i=0; i<po.getPrecontractContentStr().length(); ++i)
			if(po.getPrecontractContentStr().charAt(i) == '1')
				++orderNumber;
		SchoolInfo schoolInfo = schoolDao.getObjectById(po.getSchool_id());
		double orderTotalAmount = 0;
		if(po.getCourse_status() == 2)
			orderTotalAmount = orderNumber * schoolInfo.getSubject_2_fee();
		else if(po.getCourse_status() == 3)
			orderTotalAmount = orderNumber * schoolInfo.getSubject_3_fee();
		Double studentDepositAmount = depositDao.getStudentDepositAmount(po.getStudent_id());
		if(studentDepositAmount == null)
			studentDepositAmount = 0.00;
		Double studentConsumeAmount = dao.getStudentConsumeAmount(po.getSchool_id());
		if(studentConsumeAmount == null)
			studentConsumeAmount = 0.00;
		if(orderTotalAmount > (studentDepositAmount - studentConsumeAmount))
			return -1;//余额不足
		int result = 0;
		for(int i=0; i<scheduleDateArray.length && !scheduleDateArray[i].isEmpty(); ++i){
			for(int j=0; j<precontractContentArray[i].length(); ++j){
				if(precontractContentArray[i].charAt(j) == '0')
					continue; // 0 表示该时间段没有被预约
				String startTime = scheduleDateArray[i] + " " + (j < 10 ? "0" + j : j) + "00:00";
				String endTime = scheduleDateArray[i] + " " + (j + 1 < 10 ? "0" + (j+1) : j+1) + "00:00";
				po.setTraining_end_time(endTime);
				po.setTraining_start_time(startTime);
				result += dao.addObject(po);
			}
		}
		return result;
	}
	
	@Transactional
	public int updateObjectById(OrderRecord po) throws Exception {
		System.out.println("子类的更新方法得到执行");
		Integer status = po.getOrder_status();
		if(status != null && status == 3){
			int count = coachDao.getObjectById(po.getCoach_id()).getService_count();
			CoachBasicInfo coach = new CoachBasicInfo();
			coach.setService_count(count + 1);
			coach.setCoach_id(po.getCoach_id());
			int result = coachDao.updateObjectById(coach);
			if(result != 1)
				throw new Exception("订单完成后，更新教练服务次数失败。");
		}
		String operation = po.getOperation();
		if(operation != null && operation.length() > 50)
			po.setOperation(operation.substring(0, 50));
		return super.updateObjectById(po);
	}


	@Override
	public List<CoachPrecontractRecord> getCoPreRecord(
			CoachPrecontractRecordVo vo) throws Exception {
		if(vo.getCoach_id() == null)
			throw new Exception("coach_id的值为null");
		return dao.getCoPreRecord(vo);
	}


	@Override
	public List<TrainingRecord> getStuTranRecord(TrainingRecordVo vo)
			throws Exception {
		if(vo.getStudent_id() == null && vo.getStudent_id() == 0){
			throw new Exception("未知的student_id");
		}
		return dao.getStuTranRecord(vo);
	}


	@Override
	public int getStuTranRecordSize(TrainingRecordVo vo) throws Exception {
		if(vo.getStudent_id() == null && vo.getStudent_id() == 0){
			throw new Exception("未知的student_id");
		}
		return dao.getStuTranRecordSize(vo);
	}


	@Override
	public List<OrderInfo> getOrderInfo(OrderInfoVo vo) {
		// TODO Auto-generated method stub
		return dao.getOrderInfo(vo);
	}


	@Override
	public int getOrderInfoSize(OrderInfoVo vo) {
		// TODO Auto-generated method stub
		return dao.getOrderInfoSize(vo);
	}


	@Override
	public AllEvaluationRecord getEvaluationInfoByOrderId(Integer order_id) {
		// TODO Auto-generated method stub
		return dao.getEvaluationInfoByOrderId(order_id);
	}


	@Override
	public int getLatestRrecontractRecordSize(CoachPrecontractRecordVo vo) {
		// TODO Auto-generated method stub
		if(vo.getCoach_id() == null)
			throw new IllegalArgumentException("查询最新预约记录的总数时 coach_id 不能为null");
		if(vo.getLastQueryTime() == null || vo.getLastQueryTime().isEmpty())
			throw new IllegalArgumentException("查询最新预约记录的总数时  lastQueryTime 不能为nulll 或 空字符串");
		return dao.getLatestRrecontractRecordSize(vo);
	}
	
	@Override
	public int getLastestCancelRecordSize(CoachPrecontractRecordVo vo) {
		// TODO Auto-generated method stub
		if(vo.getCoach_id() == null)
			throw new IllegalArgumentException("查询最新取消预约的总数时 coach_id 不能为null");
		System.out.println("*******in OrderRecordServiceImple" + vo.getLastQueryTime());
		if(vo.getLastQueryTime() == null || vo.getLastQueryTime().isEmpty())
			throw new IllegalArgumentException("查询最新取消预约的总数时  lastQueryTime 不能为nulll 或 空字符串");
		return dao.getLastestCancelRecordSize(vo);
	}


	@Override
	public List<CoachFianceSummarizing> getCoachFinanceSumInfo(Integer coach_id) {
		if(coach_id == null)
			throw new IllegalArgumentException("获取教练财务信息时 coach_id 不能为null");
		return dao.getCoachFinanceSumInfo(coach_id);
	}


	@Override
	public List<CoachTeachRecord> getCoachTeachRecord(CoachTeachRecordVo vo) {
		if(vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练授课记录时 coach_id 不能为null");
		return dao.getCoachTeachRecord(vo);
	}


	@Override
	public int getCoachTeachRecordSize(CoachTeachRecordVo vo) {
		if(vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练授课记录时 coach_id 不能为null");
		return dao.getCoachTeachRecordSize(vo);	
	}


	@Override
	public List<String> getCoachSomedayPrecontractInfo(Map<String, Object> map) {
		return dao.getCoachSomedayPrecontractInfo(map);
	}

	@Override
	public List<MyOrderRecord> getStudentOrderRecord(MyOrderRecordVo vo) {
		if(vo.getStudent_id() == null)
			throw new IllegalArgumentException("获取学员预约记录或练习记录时，学员id student_id 为null");
		if(vo.getOption() == null)
			throw new IllegalArgumentException("获取学员预约记录或练习记录时，选项 option 为null");
		return dao.getStudentOrderRecord(vo);
	}

	@Override
	public int getStudentOrderRecordSize(MyOrderRecordVo vo) {
		if(vo.getStudent_id() == null)
			throw new IllegalArgumentException("获取学员预约记录或练习记录时，学员id student_id 为null");
		if(vo.getOption() == null)
			throw new IllegalArgumentException("获取学员预约记录或练习记录时，选项 option 为null");
		return dao.getStudentOrderRecordSize(vo);
	}

	@Override
	public List<CoachIncomeRecord> getCoachIncomeRecord(CoachIncomeRecordVo vo) {
		if(vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练收入列表时，教练id coach_id 为null");
		if(vo.getOrder_status() == null)
			throw new IllegalArgumentException("获取教练收入列表时， 科目状态 order_status 为null");
		return dao.getCoachIncomeRecord(vo);
	}

	@Override
	public int getCoachIncomeRecordSize(CoachIncomeRecordVo vo) {
		if(vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练收入列表时，教练id coach_id 为null");
		if(vo.getOrder_status() == null)
			throw new IllegalArgumentException("获取教练收入列表时， 科目状态 order_status 为null");
		return dao.getCoachIncomeRecordSize(vo);
	}
}