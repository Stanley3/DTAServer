package com.dta.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceProvider {
	
	public ServiceProvider(){
	}
	
	public static Object getBean(String beanName){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		Object object = null;
		if(context.containsBean(beanName)){
			System.out.println("´æÔÚbeanName£º " + beanName);
			object = context.getBean(beanName);
			
		}	
		else{
			System.out.println("beanName: " + beanName + "²»´æÔÚ¡£");
		}
		return object;
	}
}