package cn.wangzh.cmr119;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class test003 {
    public static void main(String[] args) {
	day();
	week();
	month();
	test();
	System.out.println();
	System.out.println();
	Date now =trunc(new Date(1477929600045l));
        System.out.println(getBeginOfCurrentMonth(now).getTime());
        Date end = trunc(getBeginOfCurrentMonth(now));
        System.out.println("now equals end = " + now.equals(end));
    }
    
    
    public static void day()
    {
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH, 1);
	
	
	cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	System.out.println("time=" + cal.getTime());
	System.out.println("timeinmillis=" + cal.getTimeInMillis());
	System.out.println("Systemtimeinmillis=" + System.currentTimeMillis());
	long expire = (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000 ;
	System.out.println("expire=" + expire);
	System.out.println();
	System.out.println();
    }
    
    public static void week()
    {
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.WEEK_OF_MONTH, 1);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        
        cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	System.out.println("time=" + cal.getTime());
	System.out.println("timeinmillis=" + cal.getTimeInMillis());
	long expire = (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000 ;
	System.out.println("expire=" + expire);
	System.out.println();
	System.out.println();
    }
    
    public static void month()
    {
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        
        cal.set(Calendar.HOUR_OF_DAY, 0);
	cal.set(Calendar.MINUTE, 0);
	cal.set(Calendar.SECOND, 0);
	System.out.println("time=" + cal.getTime());
	System.out.println("timeinmillis=" + cal.getTimeInMillis());
	long expire = (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000 ;
	System.out.println("expire=" + expire);
    }
    
    public static void test()
    {
	Calendar cal = Calendar.getInstance();
	cal.setTime(new Date());
	System.out.println("day:" + cal.get(Calendar.DAY_OF_MONTH));
	System.out.println("dayweek:" + cal.get(Calendar.DAY_OF_WEEK));
	System.out.println("week:" + cal.get(Calendar.WEEK_OF_MONTH));
    }
    
    
    /**
     * 截断给出的日期到天
     * 
     * @param d Date
     * @return Date
     */
    public static Date trunc(Date d)
    {
        Calendar ca = Calendar.getInstance();
        ca.setTime(d);
        
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);
        
        return ca.getTime();
    }
    
    /**
     * 获取当月开始时间
     * 
     * @param date Date
     * @return Timestamp
     */
    public static Timestamp getBeginOfCurrentMonth(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        
        return new Timestamp(c.getTimeInMillis());
    }
}
