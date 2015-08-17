package com.dta.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.bean.EvaluationRecord;
import com.dta.bean.OrderRecord;
import com.dta.service.ICoachBasicInfoService;
import com.dta.service.ICoachFinanceRecordService;
import com.dta.service.IEvaluationRecordService;
import com.dta.service.IOrderRecordService;
import com.dta.service.IScheduleInfoService;
import com.dta.service.IStudentFinanceInfoService;
import com.dta.vo.OrderRecordVo;

@Service
public class BatchOperation {
	@Autowired
	private IScheduleInfoService scheduleInfoService;
	@Autowired
	private ICoachBasicInfoService coachBasicInfoServiceImpl;
	private IOrderRecordService orderRecordService;
	private IStudentFinanceInfoService studentFinanceService;
	private ICoachFinanceRecordService coachFinanceRecordService;
	private IEvaluationRecordService evaluationRecordService;
	Logger logger = LoggerFactory.getLogger("com.dta.utils.BatchOperation");

	public BatchOperation() {
		System.err.println("**********执行************");
		logger.info("定时器执行");
		scheduleInfoService = (IScheduleInfoService) ServiceProvider
				.getBean("scheduleInfoServiceImpl");
		coachBasicInfoServiceImpl = (ICoachBasicInfoService) ServiceProvider
				.getBean("coachBasicInfoServiceImpl");
		orderRecordService = (IOrderRecordService)ServiceProvider.getBean("orderRecordServiceImpl");
		studentFinanceService = (IStudentFinanceInfoService)ServiceProvider.getBean("studentFinanceInfoServiceImpl");
		coachFinanceRecordService = (ICoachFinanceRecordService)ServiceProvider.getBean("coachFinanceRecordServiceImpl");
		evaluationRecordService =  (IEvaluationRecordService)ServiceProvider.getBean("evaluationRecordServiceImpl");
	}

	public void run() {
		Timer timer = new Timer();

		final SimpleDateFormat dateFormat = new SimpleDateFormat(
				"YYYY-MM-dd HH:mm:ss");
		final Date beginTime;
		Calendar calendar = dateFormat.getCalendar();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 1);
		// calendar.add(Calendar.MINUTE, 1);
		beginTime = calendar.getTime();
		logger.debug("在" + dateFormat.format(beginTime) + "开启定时器");
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				// System.out.println("一秒执行一次" + System.currentTimeMillis());
				List<Integer> coachIDList = coachBasicInfoServiceImpl
						.getAllCoachID();
				if (coachIDList != null) {
					logger.info(dateFormat.format(beginTime) + " 开始批量添加排班");
					for (int i = 0; i < coachIDList.size(); ++i) {
						scheduleInfoService
								.batchGenerateScheduleInfo(coachIDList.get(i));
					}
				}
				SimpleDateFormat currentDateFormat = new SimpleDateFormat("YYYY-MM-dd");
				Calendar currentCalendar = currentDateFormat.getCalendar();
				currentCalendar.setTime(new Date());
				currentCalendar.add(Calendar.DAY_OF_MONTH, -1);
				currentCalendar.set(Calendar.HOUR_OF_DAY, 0);
				currentCalendar.set(Calendar.SECOND, 0);
				String date = currentDateFormat.format(currentCalendar.getTime());
				Map<String, Object> map = new HashMap<String, Object>(5);
				map.put("order_status", 0);
				map.put("trainingTime", date);
				List<OrderRecord> resultList = orderRecordService.scanOrderRecord(map);
				if(resultList != null)
					for(OrderRecord orderRecord : resultList){
						if(orderRecord.getScanned() == 0){
							//学员缺勤
							try{
								if(studentFinanceService.updateBalanceByStudentId(orderRecord.getStudent_id(), orderRecord.getOrder_amount() / 2, 1) != 1)
									logger.error("学员【" + orderRecord.getStudent_id() + "】缺勤，给其返款时失败");
							}catch(Exception e){
								logger.error("学员【" + orderRecord.getStudent_id() + "】缺勤，给其返款时出现异常，异常信息如下：", e);
							}
							try{
								if(coachFinanceRecordService.addOrUpdateCoachIncomeAmount(orderRecord.getCoach_id(), orderRecord.getOrder_amount() / 2) != 1)
									logger.error("教练【" + orderRecord.getCoach_id() + "】接受学员【" + orderRecord.getStudent_id()+ "】缺勤的返款时失败");
							}catch(Exception e){
								logger.error("教练【" + orderRecord.getCoach_id() + "】接受学员【" + orderRecord.getStudent_id()+ "】缺勤的返款时出现异常，异常信息如下：", e);
							}
						}else if(orderRecord.getScanned() == 1){
							//学员未评价，冻结订单
							OrderRecord po = new OrderRecord();
							po.setOrder_id(orderRecord.getOrder_id());
							po.setOrder_status(2);
							po.setOrder_freeze_time(currentDateFormat.format(System.currentTimeMillis()));
							try{
								if(orderRecordService.updateObjectById(po) != 1)
									logger.error("订单【" + orderRecord.getOrder_id() + "】冻结失败");
							}catch(Exception e){
								logger.error("订单【" + orderRecord.getOrder_id() + "】冻结出现异常，异常信息如下：", e);
							}
						}
					}
				resultList.clear();
				map.clear();
				currentCalendar.clear();
				currentCalendar.setTime(new Date());
				currentCalendar.add(Calendar.DAY_OF_MONTH, -2);
				currentCalendar.set(Calendar.HOUR_OF_DAY, 0);
				currentCalendar.set(Calendar.MINUTE, 0);
				currentCalendar.set(Calendar.SECOND, 0);
				
				map.put("scanned", 1);
				map.put("order_status", 2);
				map.put("trainingTime", currentDateFormat.format(currentCalendar.getTime()));
				
				//学员未评价的订单默认中评
				resultList = orderRecordService.scanOrderRecord(map);
				if(resultList != null){
					EvaluationRecord po = new EvaluationRecord();
					po.setEvaluation(1);
					po.setEvaluation_type(1);
					po.setSkill(4);
					po.setService_attitude(4);
					po.setHygiene(4);
					for(OrderRecord orderRecord : resultList){
						 po.setOrder_id(orderRecord.getOrder_id());
						 try{
							 if(evaluationRecordService.addObject(po) != 1)
								 logger.error("给订单【" + orderRecord.getOrder_id() + "】默认中评时失败");
						 }catch(Exception e){
							 logger.error("给订单【" + orderRecord.getOrder_id() + "】默认中评时异常, 异常信息如下：", e);
						 }
					}
				}
			}

		}, beginTime, 24 * 60 * 60 * 1000);
	}
}
