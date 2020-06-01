package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NowTimeUtil {
	
	public Date getNowTime(){
		 Date date = new Date();//获得系统时间.
	     return date;   
	}
	
	
	public static void  main(String[] args){
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd" );
		String nowTime = sdf.format(date);
		System.out.println(date);
	}
}
