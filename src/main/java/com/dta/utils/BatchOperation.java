package com.dta.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

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
	
	public BatchOperation(){
		System.err.println("**********执行************");
		scheduleInfoService = (IScheduleInfoService)ServiceProvider.getBean("scheduleInfoServiceImpl");
		coachBasicInfoServiceImpl = (ICoachBasicInfoService)ServiceProvider.getBean("coachBasicInfoServiceImpl");
	}
	public void run(){
		Timer timer = new Timer();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		Date beginTime ;
		Calendar calendar = dateFormat.getCalendar();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 1);
		beginTime = calendar.getTime();
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//System.out.println("一秒执行一次" + System.currentTimeMillis());
				List<Integer> coachIDList = coachBasicInfoServiceImpl.getAllCoachID();
				if(coachIDList != null){
					for(int i=0; i<coachIDList.size(); ++i){
						scheduleInfoService.batchGenerateScheduleInfo(coachIDList.get(i));
					}
				}
			}
			
		}, beginTime, 24 * 60 * 60 * 1000);
	}
}
