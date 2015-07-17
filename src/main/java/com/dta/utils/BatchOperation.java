package com.dta.utils;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class BatchOperation {
	public void run(){
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				//System.out.println("一秒执行一次" + System.currentTimeMillis());
				
			}
			
		}, new Date(), 1000);
	}
}
