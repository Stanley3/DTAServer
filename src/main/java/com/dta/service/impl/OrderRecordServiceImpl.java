package com.dta.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.dta.bean.AllEvaluationRecord;
import com.dta.bean.CoachBasicInfo;
import com.dta.bean.CoachFianceSummarizing;
import com.dta.bean.CoachFinanceRecord;
import com.dta.bean.CoachIncomeRecord;
import com.dta.bean.CoachOrderById;
import com.dta.bean.CoachPrecontractRecord;
import com.dta.bean.CoachTeachRecord;
import com.dta.bean.MyOrderRecord;
import com.dta.bean.OrderInfo;
import com.dta.bean.OrderRecord;
import com.dta.bean.ScheduleInfo;
import com.dta.bean.SchoolInfo;
import com.dta.bean.StudentBasicInfo;
import com.dta.bean.TrainingRecord;
import com.dta.dao.ICoachBasicInfoDao;
import com.dta.dao.IOrderRecordDao;
import com.dta.dao.IScheduleInfoDao;
import com.dta.dao.ISchoolInfoDao;
import com.dta.dao.IStudentBasicInfoDao;
import com.dta.dao.IStudentDepositRecordDao;
import com.dta.dao.IStudentFinanceInfoDao;
import com.dta.service.ICoachFinanceRecordService;
import com.dta.service.IOrderRecordService;
import com.dta.service.IScheduleInfoService;
import com.dta.service.IStudentFinanceInfoService;
import com.dta.vo.CoachIncomeRecordVo;
import com.dta.vo.CoachOrderByIdVo;
import com.dta.vo.CoachPrecontractRecordVo;
import com.dta.vo.CoachTeachRecordVo;
import com.dta.vo.MyOrderRecordVo;
import com.dta.vo.OrderInfoVo;
import com.dta.vo.OrderRecordVo;
import com.dta.vo.TrainingRecordVo;

@Service
public class OrderRecordServiceImpl extends
		BaseAllServiceImpl<OrderRecord, OrderRecordVo> implements
		IOrderRecordService {
	@Autowired
	private IOrderRecordDao dao;
	@Autowired
	private ICoachBasicInfoDao coachDao;
	@Autowired
	private ISchoolInfoDao schoolDao;
	@Autowired
	private IStudentDepositRecordDao depositDao;
	@Autowired
	private IStudentFinanceInfoService studentFinanceService;
	@Autowired
	private IScheduleInfoService scheduleInfoService;
	@Autowired
	private ICoachFinanceRecordService coachFinaceRecordService;
	@Autowired
	private IScheduleInfoDao scheduleInfoDao;
	@Autowired
	private IStudentBasicInfoDao studentBasicInfoDao;

	public void init() {
		super.setDao(dao);
	}

	@Override
	@Transactional
	public int addObject(OrderRecord po) {
		String[] scheduleDateArray = po.getScheduleDateStr().split("\\|");
		String[] precontractContentArray = po.getPrecontractContentStr().split(
				"\\|");
		// String[] scheduleIDArray = po.getScheduleIDStr().split("|");
		int orderNumber = 0;
		for (int i = 0; i < po.getPrecontractContentStr().length(); ++i)
			if (po.getPrecontractContentStr().charAt(i) == '1')
				++orderNumber;
		SchoolInfo schoolInfo = schoolDao.getObjectById(po.getSchool_id());
		double orderTotalAmount = 0;
		double subject_2_fee = 0;
		double subject_3_fee = 0;
		if (po.getCourse_status() == 2) {
			subject_2_fee = schoolInfo.getSubject_2_fee();
			orderTotalAmount = orderNumber * subject_2_fee;
		} else if (po.getCourse_status() == 3) {
			subject_3_fee = schoolInfo.getSubject_3_fee();
			orderTotalAmount = orderNumber * subject_3_fee;
		}
		/*
		 * Double studentDepositAmount =
		 * depositDao.getStudentDepositAmount(po.getStudent_id());
		 * if(studentDepositAmount == null) studentDepositAmount = 0.00; Double
		 * studentConsumeAmount =
		 * dao.getStudentConsumeAmount(po.getSchool_id());
		 * if(studentConsumeAmount == null) studentConsumeAmount = 0.00;
		 * if(orderTotalAmount > (studentDepositAmount - studentConsumeAmount))
		 * return -1;//余额不足
		 */
		Double studentAccountBalance = studentFinanceService
				.getStudentBalanceById(po.getStudent_id());
		if (studentAccountBalance == null)
			studentAccountBalance = 0.0;
		if (studentAccountBalance < orderTotalAmount)
			return -1; // 余额不足
		int result = 0;
		for (int i = 0; i < scheduleDateArray.length
				&& !scheduleDateArray[i].isEmpty(); ++i) {
			for (int j = 0; j < precontractContentArray[i].length(); ++j) {
				if (precontractContentArray[i].charAt(j) == '0')
					continue; // 0 表示该时间段没有被预约
				StudentBasicInfo studentBasicInfo = studentBasicInfoDao
						.getObjectById(po.getStudent_id());
				if (studentBasicInfo == null)
					throw new RuntimeException("学员预约订单时，获取学员信息失败");
				CoachBasicInfo coachBasicInfo = coachDao.getObjectById(po
						.getCoach_id());
				if (coachBasicInfo == null)
					throw new RuntimeException("学员预约订单时，获取教练信息失败");
				String startTime = scheduleDateArray[i] + " "
						+ (j < 10 ? "0" + j : j) + ":00";
				String endTime = scheduleDateArray[i] + " "
						+ (j + 1 < 10 ? "0" + (j + 1) : j + 1) + ":00";
				po.setTraining_end_time(endTime);
				po.setTraining_start_time(startTime);
				po.setOrder_status(0);
				po.setStudent_level(studentBasicInfo.getStudent_level());
				po.setDevice_type(coachBasicInfo.getDevice_type());
				if (po.getCourse_status() == 2)
					po.setOrder_amount(subject_2_fee);
				else if (po.getCourse_status() == 3)
					po.setOrder_amount(subject_3_fee);
				//修改排班表和学员财务表成功之后才增添一条订单
				if (scheduleInfoService.isScheduled(po.getCoach_id(),
						scheduleDateArray[i], j) &&
						studentFinanceService.updateBalanceByStudentId(studentBasicInfo.getStudent_id(), 
								po.getOrder_amount(), -1)==1){
					result += dao.addObject(po);
				}
			}
		}
		return result;
	}

	@Transactional
	public int updateObjectById(OrderRecord po) throws Exception {
		System.out.println("子类的更新方法得到执行");
		Integer status = po.getOrder_status();
		if (status != null && status == 3) {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			po.setOrder_dead_time(format.format(new Date()));
			int count = coachDao.getObjectById(po.getCoach_id())
					.getService_count();
			CoachBasicInfo coach = new CoachBasicInfo();
			coach.setService_count(count + 1);
			coach.setCoach_id(po.getCoach_id());
			int result = coachDao.updateObjectById(coach);
			if (result != 1)
				throw new Exception("订单完成后，更新教练服务次数失败。");
		} else if (status != null && status == 1) { // 表示取消一个订单，要释放该订单占由的排班信息;若取消时间距训练时间大于2h，则全额返现，在2h之内，一半给学员，一半教练。
			boolean updateScheduleInfoSuccess = false;
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			OrderRecord orderRecord = dao.getObjectById(po.getOrder_id());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("coach_id", orderRecord.getCoach_id());
			map.put("schedule_date", orderRecord.getTraining_start_time()
					.split(" ")[0]);
			ScheduleInfo scheduleInfo = scheduleInfoDao
					.getObjectByCoachIdAndScheduleDate(map);
			String precontract_info = scheduleInfo.getPrecontract_info();
			if (StringUtils.hasText(precontract_info)) {
				Calendar calendar = format.getCalendar();
				Date trainingDate = format.parse(orderRecord
						.getTraining_start_time());
				calendar.setTime(trainingDate);
				int hour = calendar.get(Calendar.HOUR_OF_DAY);
				precontract_info = precontract_info.substring(0, hour) + "0"
						+ precontract_info.substring(hour + 1);
				scheduleInfo.setPrecontract_info(precontract_info);
				// if(scheduleInfoDao.updateObjectById(scheduleInfo) == 1)

				if (scheduleInfoService
						.synchronizedUpdateObjectById(scheduleInfo) == 1)
					updateScheduleInfoSuccess = true;
				if ((trainingDate.getTime() - System.currentTimeMillis()) < 2 * 60 * 60 * 1000) {
					// 返回一半钱给教练，一半给学员
					if (coachFinaceRecordService.addOrUpdateCoachIncomeAmount(
							orderRecord.getCoach_id(),
							orderRecord.getOrder_amount() / 2) != 1)
						throw new IllegalArgumentException(
								"学员在两个小时内取消订单时，将一半钱打给教练失败。");
					if (studentFinanceService.updateBalanceByStudentId(
							orderRecord.getStudent_id(),
							orderRecord.getOrder_amount() / 2, 1) != 1)
						throw new IllegalArgumentException(
								"学员在两个小时内取消订单时，将一半钱返回学员失败。");
				} else {
					if (studentFinanceService.updateBalanceByStudentId(
							orderRecord.getStudent_id(),
							orderRecord.getOrder_amount(), 1) != 1)
						throw new IllegalArgumentException(
								"学员在两个小时外取消订单时，将钱给用户钱失败。");
				}
			}
			if (!updateScheduleInfoSuccess)
				return 0;
		}
		String operation = po.getOperation();
		if (operation != null && operation.length() > 50)
			po.setOperation(operation.substring(0, 50));
		return super.updateObjectById(po);
	}

	@Override
	public List<CoachPrecontractRecord> getCoPreRecord(
			CoachPrecontractRecordVo vo) throws Exception {
		if (vo.getCoach_id() == null)
			throw new Exception("coach_id的值为null");
		return dao.getCoPreRecord(vo);
	}

	@Override
	public List<TrainingRecord> getStuTranRecord(TrainingRecordVo vo)
			throws Exception {
		if (vo.getStudent_id() == null && vo.getStudent_id() == 0) {
			throw new Exception("未知的student_id");
		}
		return dao.getStuTranRecord(vo);
	}

	@Override
	public int getStuTranRecordSize(TrainingRecordVo vo) throws Exception {
		if (vo.getStudent_id() == null && vo.getStudent_id() == 0) {
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
		if (vo.getCoach_id() == null)
			throw new IllegalArgumentException("查询最新预约记录的总数时 coach_id 不能为null");
		if (vo.getLastQueryTime() == null || vo.getLastQueryTime().isEmpty())
			throw new IllegalArgumentException(
					"查询最新预约记录的总数时  lastQueryTime 不能为nulll 或 空字符串");
		return dao.getLatestRrecontractRecordSize(vo);
	}

	@Override
	public int getLastestCancelRecordSize(CoachPrecontractRecordVo vo) {
		// TODO Auto-generated method stub
		if (vo.getCoach_id() == null)
			throw new IllegalArgumentException("查询最新取消预约的总数时 coach_id 不能为null");
		System.out.println("*******in OrderRecordServiceImple"
				+ vo.getLastQueryTime());
		if (vo.getLastQueryTime() == null || vo.getLastQueryTime().isEmpty())
			throw new IllegalArgumentException(
					"查询最新取消预约的总数时  lastQueryTime 不能为nulll 或 空字符串");
		return dao.getLastestCancelRecordSize(vo);
	}

	@Override
	public List<CoachFianceSummarizing> getCoachFinanceSumInfo(Integer coach_id) {
		if (coach_id == null)
			throw new IllegalArgumentException("获取教练财务信息时 coach_id 不能为null");
		return dao.getCoachFinanceSumInfo(coach_id);
	}

	@Override
	public List<CoachTeachRecord> getCoachTeachRecord(CoachTeachRecordVo vo) {
		if (vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练授课记录时 coach_id 不能为null");
		return dao.getCoachTeachRecord(vo);
	}

	@Override
	public int getCoachTeachRecordSize(CoachTeachRecordVo vo) {
		if (vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练授课记录时 coach_id 不能为null");
		return dao.getCoachTeachRecordSize(vo);
	}

	@Override
	public List<String> getStudentSomedayPrecontractInfo(Map<String, Object> map) {
		if (map.get("student_id") == null)
			throw new IllegalArgumentException(
					"学员端请求教练的排班信息时，学员idstudent_id为null");
		return dao.getStudentSomedayPrecontractInfo(map);
	}

	@Override
	public List<MyOrderRecord> getStudentOrderRecord(MyOrderRecordVo vo) {
		if (vo.getStudent_id() == null)
			throw new IllegalArgumentException(
					"获取学员预约记录或练习记录时，学员id student_id 为null");
		if (vo.getOption() == null)
			throw new IllegalArgumentException("获取学员预约记录或练习记录时，选项 option 为null");
		return dao.getStudentOrderRecord(vo);
	}

	@Override
	public int getStudentOrderRecordSize(MyOrderRecordVo vo) {
		if (vo.getStudent_id() == null)
			throw new IllegalArgumentException(
					"获取学员预约记录或练习记录时，学员id student_id 为null");
		if (vo.getOption() == null)
			throw new IllegalArgumentException("获取学员预约记录或练习记录时，选项 option 为null");
		return dao.getStudentOrderRecordSize(vo);
	}

	@Override
	public List<CoachIncomeRecord> getCoachIncomeRecord(CoachIncomeRecordVo vo) {
		if (vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练收入列表时，教练id coach_id 为null");
		if (vo.getOrder_status() == null)
			throw new IllegalArgumentException(
					"获取教练收入列表时， 科目状态 order_status 为null");
		return dao.getCoachIncomeRecord(vo);
	}

	@Override
	public int getCoachIncomeRecordSize(CoachIncomeRecordVo vo) {
		if (vo.getCoach_id() == null)
			throw new IllegalArgumentException("获取教练收入列表时，教练id coach_id 为null");
		if (vo.getOrder_status() == null)
			throw new IllegalArgumentException(
					"获取教练收入列表时， 科目状态 order_status 为null");
		return dao.getCoachIncomeRecordSize(vo);
	}

	@Override
	public List<CoachOrderById> getCoachOrderById(CoachOrderByIdVo vo) {
		if (vo.getCoach_id() == null)
			throw new IllegalArgumentException(
					"web界面通过教练id获取教练的订单信息时，coach_id为null");
		return dao.getCoachOrderById(vo);
	}

	@Override
	public int getCoachOrderByIdSize(CoachOrderByIdVo vo) {
		if (vo.getCoach_id() == null)
			throw new IllegalArgumentException(
					"web界面通过教练id获取教练的订单信息时，coach_id为null");
		return dao.getCoachOrderByIdSize(vo);
	}

	@Override
	@Transactional
	public boolean completeOrder(Integer order_id) throws Exception {
		if (order_id == null)
			throw new IllegalArgumentException("完成一个订单时，订单order_id为null");
		boolean result = false;
		OrderRecord orderRecord = dao.getObjectById(order_id);
		orderRecord.setOrder_status(3);
		if (updateObjectById(orderRecord) == 1) {
			CoachFinanceRecord coachFinanceRecord = new CoachFinanceRecord();
			coachFinanceRecord.setOrder_amount(orderRecord.getOrder_amount());
			coachFinanceRecord.setCoach_id(orderRecord.getCoach_id());
			result = coachFinaceRecordService.addOrUpdateCoachIncomeAmount(
					orderRecord.getCoach_id(), orderRecord.getOrder_amount()) != 0 ? true
					: false;
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getAmountGroupByOrderStatus(
			Integer school_id) {
		if (school_id == null)
			throw new IllegalArgumentException("汇总驾校名下学员的消费总额，冻结总额时驾校id为null");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("school_id", school_id);
		return dao.getAmountGroupByOrderStatus(map);
	}

	@Override
	public int getConsumedStudentNumbers(Integer school_id) {
		if(school_id == null)
			throw new IllegalArgumentException("获取已消费学员的总数时，学员的驾校id为null");
		
		return dao.getConsumedStudentNumbers(school_id);
	}

	@Override
	public List<OrderRecord> scanOrderRecord(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.scanOrderRecord(map);
	}
}