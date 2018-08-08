package cn.wangzh.cmr114;

import java.util.Calendar;
import java.util.Date;

public class DateCompare {
	public static void main(String[] args) {
//		Timestamp begintime = new Timestamp(new Date().getTime() + (7 * 86400000));
//		System.out.println("begintime=" + begintime);
//		
//		long begin = new Date().getTime();
//		System.out.println("time1 =" + begin);
//		DateBean date = new DateBean("2016/7/9 15:31:52");
//		long end = new Date(date.getTime()).getTime();
//		
//		System.out.println("time2 =" + end);
//		long between = end - begin;
//		System.out.println("between =" + between);
//		System.out.println("秒：" + between/1000 + "." +between%1000 );
		
		DateBean date1 = new DateBean("2016/05/24 00:00:00");
		DateBean date2 = new DateBean("2016/05/17 00:00:01");
		Calendar c1 = Calendar.getInstance();
		//c1.setTime(new Date());
		c1.setTime(new Date(date1.getTime()));
		long n1 = c1.getTimeInMillis();
		Calendar c2 = Calendar.getInstance();
		//c2.setTime(new Date());
		c2.setTime(new Date(date2.getTime()));
		System.out.println("####" + new Date(date2.getTime()).getTime());
		System.out.println("####" + c2.getTimeInMillis());
		long n2 = c2.getTimeInMillis() + 7*86400000;
		
		System.out.println("n1=" + n1 + "  n2=" + n2);
		
		long between = n2 - n1;
		if(between <= 0)
		{
			System.out.println("*********相差天数：" + 0 + "天");
		}
		else
		{
			long days = (n2 - n1)/(24*3600000);
			long mills = (n2 - n1)%(24*3600000);
			System.out.println("    相差天数为:" + (mills!=0 ? days + 1 : days) + "天");
		}
		
	}

}
//class MyDate{
//	 int day;
//	 int month;
//	 int year;
//	 public MyDate(){}
//	 public MyDate(int day,int month,int year){
//	  this.day = day;
//	  this.month = month;
//	  this.year = year;
//	 }
//	 public void funtion(MyDate d){
//	  int newDay = d.day;
//	  int newMonth = d.month;
//	  int newYear = d.year;
//	  Calendar c1 = Calendar.getInstance();
//	  c1.set(newYear,newMonth,newDay);
//	  long n1 = c1.getTimeInMillis();
//	  Calendar c2 = Calendar.getInstance();
//	  c2.set(year,month,day);
//	  long n2 = c2.getTimeInMillis();
//	  System.out.println( "相差天数为:" + Math.abs((n1 - n2)/24/3600000)); }
//	 public static void main(String[] args){
//	  MyDate d1 = new MyDate(1,1,2008);
//	  MyDate d2 = new MyDate(2,1,2001);
//	  d1.funtion(d2);
//	 }
//	}