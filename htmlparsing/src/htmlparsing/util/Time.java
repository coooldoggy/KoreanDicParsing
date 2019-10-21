package htmlparsing.util;

import java.util.Calendar;

public class Time {

	public static String currentYMD(Calendar calendar) //20050926 
	{
		String currentTime=null;
		if(calendar.get(Calendar.MONTH)+1>9)
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		else 
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}

		return currentTime;
	}
	//+calendar.get(Calendar.MINUTE)
	public static String currentYMD() //20050926 
	{
		String currentTime=null;
		Calendar calendar=Calendar.getInstance();
		if(calendar.get(Calendar.MONTH)+1>9)
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		else 
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}

		return currentTime;
	}
	public static String currentYMDH() //20050926
	{
		String currentTime=null;
		Calendar calendar=Calendar.getInstance();
		if(calendar.get(Calendar.MONTH)+1>9)
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		else 
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		if(calendar.get(Calendar.HOUR_OF_DAY)>9) currentTime+=calendar.get(Calendar.HOUR_OF_DAY);
		else currentTime+="0"+calendar.get(Calendar.HOUR_OF_DAY);
		
		return currentTime;
	}
	public static String currentYMDHM()
	{
		String currentTime=null;
		Calendar calendar=Calendar.getInstance();
		if(calendar.get(Calendar.MONTH)+1>9)
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		else 
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		if(calendar.get(Calendar.HOUR_OF_DAY)>9) currentTime+=calendar.get(Calendar.HOUR_OF_DAY);
		else currentTime+="0"+calendar.get(Calendar.HOUR_OF_DAY);
		if(calendar.get(Calendar.MINUTE)>9) currentTime+=calendar.get(Calendar.MINUTE);
		else currentTime+="0"+calendar.get(Calendar.MINUTE);
		return currentTime;
	}
	public static String currentYMDHMS()
	{
		String currentTime=null;
		Calendar calendar=Calendar.getInstance();
		if(calendar.get(Calendar.MONTH)+1>9)
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		else 
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		if(calendar.get(Calendar.HOUR_OF_DAY)>9) currentTime+=calendar.get(Calendar.HOUR_OF_DAY);
		else currentTime+="0"+calendar.get(Calendar.HOUR_OF_DAY);
		if(calendar.get(Calendar.MINUTE)>9) currentTime+=calendar.get(Calendar.MINUTE);
		else currentTime+="0"+calendar.get(Calendar.MINUTE);
		if(calendar.get(Calendar.SECOND)>9) currentTime+=calendar.get(Calendar.SECOND);
		else currentTime+="0"+calendar.get(Calendar.SECOND);
		return currentTime;
	}


	public static String currentYMDHMSNano()
	{
		String currentTime=null;
		Calendar calendar=Calendar.getInstance();
		if(calendar.get(Calendar.MONTH)+1>9)
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		else 
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		if(calendar.get(Calendar.HOUR_OF_DAY)>9) currentTime+=calendar.get(Calendar.HOUR_OF_DAY);
		else currentTime+="0"+calendar.get(Calendar.HOUR_OF_DAY);
		if(calendar.get(Calendar.MINUTE)>9) currentTime+=calendar.get(Calendar.MINUTE);
		else currentTime+="0"+calendar.get(Calendar.MINUTE);
		if(calendar.get(Calendar.SECOND)>9) currentTime+=calendar.get(Calendar.SECOND);
		else currentTime+="0"+calendar.get(Calendar.SECOND);
		
		if(calendar.get(Calendar.MILLISECOND)>99)
			currentTime+=calendar.get(Calendar.MILLISECOND);
		else if(calendar.get(Calendar.MILLISECOND)>9 && calendar.get(Calendar.MILLISECOND)<100)
			currentTime+="0"+calendar.get(Calendar.MILLISECOND);
		else
			currentTime+="00"+calendar.get(Calendar.MILLISECOND);
		return currentTime;
	}
	
	public static String currentHMSNano()
	{
		String currentTime="";
		Calendar calendar=Calendar.getInstance();
		if(calendar.get(Calendar.HOUR_OF_DAY)>9) currentTime+=calendar.get(Calendar.HOUR_OF_DAY);
		else currentTime+="0"+calendar.get(Calendar.HOUR_OF_DAY);
		if(calendar.get(Calendar.MINUTE)>9) currentTime+=calendar.get(Calendar.MINUTE);
		else currentTime+="0"+calendar.get(Calendar.MINUTE);
		if(calendar.get(Calendar.SECOND)>9) currentTime+=calendar.get(Calendar.SECOND);
		else currentTime+="0"+calendar.get(Calendar.SECOND);
		
		if(calendar.get(Calendar.MILLISECOND)>99)
			currentTime+=calendar.get(Calendar.MILLISECOND);
		else if(calendar.get(Calendar.MILLISECOND)>9 && calendar.get(Calendar.MILLISECOND)<100)
			currentTime+="0"+calendar.get(Calendar.MILLISECOND);
		else
			currentTime+="00"+calendar.get(Calendar.MILLISECOND);
		return currentTime;
	}

	public static String currentYMDHMSAfter(int second)
	{
		String currentTime=null;
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.SECOND,second);
		if(calendar.get(Calendar.MONTH)+1>9)
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		else 
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		if(calendar.get(Calendar.HOUR_OF_DAY)>9) currentTime+=calendar.get(Calendar.HOUR_OF_DAY);
		else currentTime+="0"+calendar.get(Calendar.HOUR_OF_DAY);
		if(calendar.get(Calendar.MINUTE)>9) currentTime+=calendar.get(Calendar.MINUTE);
		else currentTime+="0"+calendar.get(Calendar.MINUTE);
		if(calendar.get(Calendar.SECOND)>9) currentTime+=calendar.get(Calendar.SECOND);
		else currentTime+="0"+calendar.get(Calendar.SECOND);
		return currentTime;
	}
	
	public static String YMDHMSAfter(String time,int second)
	{
		String currentTime=null;
		Calendar calendar=Calendar.getInstance();
		// 20060205235500
		int t1=Integer.parseInt(time.substring(0,4));
		int t2=Integer.parseInt(time.substring(4,6));
		int t3=Integer.parseInt(time.substring(6,8));
		int t4=Integer.parseInt(time.substring(8,10));
		int t5=Integer.parseInt(time.substring(10,12));
		int t6=Integer.parseInt(time.substring(12,14));
		calendar.set(t1,t2-1,t3,t4,t5,t6);
		calendar.add(Calendar.SECOND,second);
		if(calendar.get(Calendar.MONTH)+1>9)
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		else 
		{
			if(calendar.get(Calendar.DATE)>9) currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+calendar.get(Calendar.DATE);
			else currentTime=""+calendar.get(Calendar.YEAR)+"0"+(calendar.get(Calendar.MONTH)+1)+"0"+calendar.get(Calendar.DATE);
		}
		if(calendar.get(Calendar.HOUR_OF_DAY)>9) currentTime+=calendar.get(Calendar.HOUR_OF_DAY);
		else currentTime+="0"+calendar.get(Calendar.HOUR_OF_DAY);
		if(calendar.get(Calendar.MINUTE)>9) currentTime+=calendar.get(Calendar.MINUTE);
		else currentTime+="0"+calendar.get(Calendar.MINUTE);
		if(calendar.get(Calendar.SECOND)>9) currentTime+=calendar.get(Calendar.SECOND);
		else currentTime+="0"+calendar.get(Calendar.SECOND);
		return currentTime;
	}
	
	// add By KWD - 2009.04.27 for HandiCall
	public static String getCurrentDate(){
		
		StringBuffer time = new StringBuffer();
		String YMDHMS = currentYMDHMS(); 
		for(int i=0; i<YMDHMS.length(); i++){

			if( i%2==0 ){
				if( (i==4) || (i==6) ){
					time.append("-");
				}else if(i==8){
					time.append(" ");
				}else if(i>8){
					time.append(":");
				}
			}
			time.append(YMDHMS.substring(i,i+1));
		}
		return time.toString();
	}

	// add By PJW - 2009.06.01 for HandiCall
	//	starttime = "2009-05-24 13:21:11";
	//	endtime = "2009-05-24 13:22:11";
	public static int calcTime(String startdate, String enddate) {
		if(startdate.equalsIgnoreCase("") || enddate.equalsIgnoreCase(""))
			return -1;
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		int year, month, day, hourOfDay, minute, second;
		int year2, month2, day2, hourOfDay2, minute2, second2;
		
		year = Integer.valueOf(startdate.substring(0, 4));
		month = Integer.valueOf(startdate.substring(5, 7));
		day = Integer.valueOf(startdate.substring(8, 10));
		hourOfDay = Integer.valueOf(startdate.substring(11, 13));
		minute = Integer.valueOf(startdate.substring(14, 16));
		second = Integer.valueOf(startdate.substring(17, 19));
		
		year2 = Integer.valueOf(enddate.substring(0, 4));
		month2 = Integer.valueOf(enddate.substring(5, 7));
		day2 = Integer.valueOf(enddate.substring(8, 10));
		hourOfDay2 = Integer.valueOf(enddate.substring(11, 13));
		minute2 = Integer.valueOf(enddate.substring(14, 16));
		second2 = Integer.valueOf(enddate.substring(17, 19));

		c1.set(year, month, day, hourOfDay, minute, second);
		c2.set(year2, month2, day2, hourOfDay2, minute2, second2);
		
		long millisDiff = c2.getTime().getTime() - c1.getTime().getTime();
		int remainder = (int) millisDiff / 1000;
		return remainder;
	}
	
	public static String calcPrevDate(String date, int prevmonth) {
		String result = "";
		
		Calendar c = Calendar.getInstance();
		
		int year, month, day;
		year = Integer.valueOf(date.substring(0, 4));
		month = Integer.valueOf(date.substring(4, 6));
		day = Integer.valueOf(date.substring(6, 8));
		
		c.set(year, month-1, day, 0, 0, 0);
		c.add(Calendar.MONTH, -prevmonth);
		
		if(c.get(Calendar.MONTH)+1 > 9) {
			if(c.get(Calendar.DATE) > 9) 
				result=""+c.get(Calendar.YEAR)+(c.get(Calendar.MONTH)+1)+c.get(Calendar.DATE);
			else
				result=""+c.get(Calendar.YEAR)+(c.get(Calendar.MONTH)+1)+"0"+c.get(Calendar.DATE);
		}
		else {
			if(c.get(Calendar.DATE) > 9) 
				result=""+c.get(Calendar.YEAR)+"0"+(c.get(Calendar.MONTH)+1)+c.get(Calendar.DATE);
			else 
				result=""+c.get(Calendar.YEAR)+"0"+(c.get(Calendar.MONTH)+1)+"0"+c.get(Calendar.DATE);
		}
		
		return result;
	}
	
	//	endtime = "20090524132211";
	public static long calcTime(String enddate) {
		if(enddate.equalsIgnoreCase(""))
			return -1;
		
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		int year, month, day, hourOfDay, minute, second;
		
		year = Integer.valueOf(enddate.substring(0, 4));
		month = Integer.valueOf(enddate.substring(4, 6));
		day = Integer.valueOf(enddate.substring(6, 8));
		hourOfDay = Integer.valueOf(enddate.substring(8, 10));
		minute = Integer.valueOf(enddate.substring(10, 12));
		second = Integer.valueOf(enddate.substring(12, 14));
		
		c1.set(c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DATE), 
				c1.get(Calendar.HOUR_OF_DAY), c1.get(Calendar.MINUTE), c1.get(Calendar.SECOND));
		c2.set(year, month-1, day, hourOfDay, minute, second);
		
		long millisDiff = c2.getTime().getTime() - c1.getTime().getTime();
		long result = millisDiff / 1000L;
		
		return result;
	}
	
//	endtime = "20090524132211";
	public static long calcTimeEx(String enddate) {
		if(enddate.equalsIgnoreCase(""))
			return -1;
		
		Calendar c1 = Calendar.getInstance();

		int year, month, day, hourOfDay, minute, second;
		
		year = Integer.valueOf(enddate.substring(0, 4));
		month = Integer.valueOf(enddate.substring(4, 6));
		day = Integer.valueOf(enddate.substring(6, 8));
		hourOfDay = Integer.valueOf(enddate.substring(8, 10));
		minute = Integer.valueOf(enddate.substring(10, 12));
		second = Integer.valueOf(enddate.substring(12, 14));
		
		c1.set(year, month-1, day, hourOfDay, minute, second);
		
		long millisDiff = System.currentTimeMillis() - c1.getTime().getTime();
		long result = millisDiff / 1000L;
		
		return result;
	}
	
	public static long getMillisecond(String datetime) {
		Calendar c1 = Calendar.getInstance();
		
		int year, month, day, hourOfDay, minute, second;
		
		year = Integer.valueOf(datetime.substring(0, 4));
		month = Integer.valueOf(datetime.substring(4, 6));
		day = Integer.valueOf(datetime.substring(6, 8));
		hourOfDay = Integer.valueOf(datetime.substring(8, 10));
		minute = Integer.valueOf(datetime.substring(10, 12));
		if(datetime.length() < 14)
			second = 0;
		else
			second = Integer.valueOf(datetime.substring(12, 14));
		
		c1.set(year, month-1, day, hourOfDay, minute, second);
		
//		return c1.getTime().getTime();
		return c1.getTimeInMillis();
	}
	
	public static int calcMinute(String hhmm) {
		if(hhmm.equalsIgnoreCase("00:00:00"))
			return 0;
		
		int hh = Integer.valueOf(hhmm.substring(0, 2));
		int mm = Integer.valueOf(hhmm.substring(3, 5));
		//int ss = Integer.valueOf(hhmmss.substring(6, 8));
		
		return ((hh * 60) + mm);
	}
	
	public static int getDayOfWeekInMonth() {
		Calendar c1 = Calendar.getInstance();
		return c1.get(Calendar.DAY_OF_WEEK_IN_MONTH);
	}
	
	public static int getDayOfWeekInMonth(String date) {
		Calendar c1 = Calendar.getInstance();
		int year, month, day, hourOfDay, minute, second;
		year = Integer.valueOf(date.substring(0, 4));
		month = Integer.valueOf(date.substring(4, 6));
		day = Integer.valueOf(date.substring(6, 8));
		hourOfDay = 0;
		minute = 0;
		second = 0;
		c1.set(year, month-1, day, hourOfDay, minute, second);
		return c1.get(Calendar.DAY_OF_WEEK_IN_MONTH);
	}
	
}
