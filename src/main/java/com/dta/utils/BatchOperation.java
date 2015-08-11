package com.dta.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dta.service.ICoachBasicInfoService;
import com.dta.service.IScheduleInfoService;

@Service
public class BatchOperation {
	@Autowired
	private IScheduleInfoService scheduleInfoService;
	@Autowired
	private ICoachBasicInfoService coachBasicInfoServiceImpl;
	Logger logger = LoggerFactory.getLogger("com.dta.utils.BatchOperation");

	public BatchOperation() {
		System.err.println("**********执行************");
		logger.info("定时器执行");
		scheduleInfoService = (IScheduleInfoService) ServiceProvider
				.getBean("scheduleInfoServiceImpl");
		coachBasicInfoServiceImpl = (ICoachBasicInfoService) ServiceProvider
				.getBean("coachBasicInfoServiceImpl");
	}

	public void run() {
		Timer timer = new Timer();

		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"YYYY-MM-dd HH:mm:ss");
		Date beginTime;
		Calendar calendar = dateFormat.getCalendar();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 1);
		// calendar.add(Calendar.MINUTE, 1);
		beginTime = calendar.getTime();
		logger.debug("开启定时器");
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				// System.out.println("一秒执行一次" + System.currentTimeMillis());
				List<Integer> coachIDList = coachBasicInfoServiceImpl
						.getAllCoachID();
				if (coachIDList != null) {
					for (int i = 0; i < coachIDList.size(); ++i) {
						scheduleInfoService
								.batchGenerateScheduleInfo(coachIDList.get(i));
					}
				}
				logger.debug("定时器得到执行");
			}

		}, beginTime, 24 * 60 * 60 * 1000);
	}
}
