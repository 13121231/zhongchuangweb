package cn.edu.njupt.bigdata.service;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CurrentTimeService {
	
	public String CurrentTime() {
		Calendar ca = Calendar.getInstance();
		
		GregorianCalendar cal = new GregorianCalendar();
		
		int afternoon = cal.get(GregorianCalendar.AM_PM);
		
		String Current = null;

		int year = ca.get(Calendar.YEAR);//获取年份

		int month=ca.get(Calendar.MONTH);//获取月份
		
		month= month+1;

		int day=ca.get(Calendar.DATE);//获取日

		int minute=ca.get(Calendar.MINUTE);//分
		
		int hour=ca.get(Calendar.HOUR);//小时
		
		if(afternoon==1&& hour>=0) {
			hour= hour+12;
		}
		
		int second=ca.get(Calendar.SECOND);//秒 
		
		if((minute<10) && (second<10)) {
			 Current =  year +"/"+ month +"/"+ day + " " + hour +":0"+ minute +":0"+ second ;
		} else {
			if((minute<10)&& (second>=10)) {
	         Current =  year +"/"+ month +"/"+ day + " " + hour +":0"+ minute +":"+ second ;
			} else {
				if((minute>=10)&& (second<10)) {
					 Current =  year +"/"+ month +"/"+ day + " " + hour +":"+ minute +":0"+ second ;
				} else{
					Current =  year +"/"+ month +"/"+ day + " " + hour +":"+ minute +":"+ second ;
				}
			}
		}
		
		return Current;
	}

}
