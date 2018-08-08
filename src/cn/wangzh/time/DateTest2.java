package cn.wangzh.time;

import cn.wangzh.cmr114.DateTest.CompareDateFormate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class DateTest2
{
    private static final HashMap<CompareDateFormate, int[]> map = new HashMap<CompareDateFormate, int[]>();
    
    static
    {
        map.put(CompareDateFormate.year, new int[] {Calendar.YEAR});
        map.put(CompareDateFormate.month, new int[] {Calendar.MONTH});
        map.put(CompareDateFormate.day, new int[] {Calendar.DATE});
        map.put(CompareDateFormate.hour, new int[] {Calendar.HOUR_OF_DAY});
        map.put(CompareDateFormate.minute, new int[] {Calendar.MINUTE});
        map.put(CompareDateFormate.second, new int[] {Calendar.SECOND});
        
        map.put(CompareDateFormate.yyyyMMddhhmmss,
            new int[] {Calendar.YEAR, Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE,
                Calendar.SECOND});
        map.put(CompareDateFormate.yyyyMMddhhmm,
            new int[] {Calendar.YEAR, Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE});
        map.put(CompareDateFormate.yyyyMMddhh,
            new int[] {Calendar.YEAR, Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY});
        map.put(CompareDateFormate.yyyyMMdd, new int[] {Calendar.YEAR, Calendar.MONTH, Calendar.DATE});
        map.put(CompareDateFormate.yyyyMM, new int[] {Calendar.YEAR, Calendar.MONTH});
        
        map.put(CompareDateFormate.MMddhhmmss,
            new int[] {Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND});
        map.put(CompareDateFormate.MMddhhmm,
            new int[] {Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE});
        map.put(CompareDateFormate.MMddhh, new int[] {Calendar.MONTH, Calendar.DATE, Calendar.HOUR_OF_DAY});
        map.put(CompareDateFormate.MMdd, new int[] {Calendar.MONTH, Calendar.DATE});
        
        map.put(CompareDateFormate.ddhhmmss,
            new int[] {Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND});
        map.put(CompareDateFormate.ddhhmm, new int[] {Calendar.DATE, Calendar.HOUR_OF_DAY, Calendar.MINUTE});
        map.put(CompareDateFormate.ddhh, new int[] {Calendar.DATE, Calendar.HOUR_OF_DAY});
        
        map.put(CompareDateFormate.hhmmss, new int[] {Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND});
        map.put(CompareDateFormate.hhmm, new int[] {Calendar.HOUR_OF_DAY, Calendar.MINUTE});
        map.put(CompareDateFormate.mmss, new int[] {Calendar.MINUTE, Calendar.SECOND});
    }
    
    /**
     * 缺省的日期字符串格式
     */
    public static final String DEFAULT_FORMAT = "yyyyMMddHHmmss";
    
    public static int compare(Date date1, Date date2, CompareDateFormate cdf) {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(date1);
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);
        
        int[] form = map.get(cdf);
        for (int field : form)
        {
            int t1 = c1.get(field);
            int t2 = c2.get(field);
            if (t1 > t2)
            {
                return 1;
            }
            else if (t1 < t2)
            {
                return -1;
            }
        }
        
        return 0;
    }
    
    /**
     * 将指定的字符串按缺省格式转换为日期
     *
     * @param strDate 日期的字符串表示
     * @return 对应指定字符串的日期
     */
    public static Date strToDate(String strDate) {
        return strToDate(strDate, DEFAULT_FORMAT);
    }
    
    /**
     * 将指定的字符串按指定格式转换为日期
     *
     * @param strDate   日期的字符串表示
     * @param strFormat 指定的格式
     * @return 对应指定字符串的日期
     */
    public static Date strToDate(String strDate, String strFormat) {
        
        SimpleDateFormat df = null;
        Date date = null;
        try
        {
            // 使用指定的格式创建日期时间格式
            df = new SimpleDateFormat(strFormat);
        }
        catch (IllegalArgumentException e)
        {
            df = new SimpleDateFormat(DateTest2.DEFAULT_FORMAT);
        }
        
        try
        {
            // 解析指定的字符串
            date = df.parse(strDate);
        }
        catch (Exception e)
        {
            // 如果解析失败则使用当前日期
            date = new Date();
        }
        
        return date;
    }
    
    /**
     * TODO 添加方法注释
     *
     * @param dateStr1
     * @param dateStr2
     * @return true 第一个在第二个之后, false 第一个在第二个之前或者等于
     * @author wangzhuohui
     */
    public static boolean compareToDate(String dateStr1, String dateStr2) {
        boolean result = false;
        
        try
        {
            Date date1 = strToDate(dateStr1);
            System.out.println(date1);
            Date date2 = strToDate(dateStr2);
            System.out.println(date2);
            Calendar ca = Calendar.getInstance();
            ca.setTime(date2);
            ca.add(Calendar.HOUR_OF_DAY, 8);
            date2 = ca.getTime();
            System.out.println(date2);
            result = compare(date1, date2, CompareDateFormate.yyyyMMddhhmmss) > 0;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        String str1 = "20170910121212";
        String str2 = "201709021212";
        
        System.out.println(compareToDate(str1, str2));
    }
}
