package cn.wangzh.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @author wangzhuohui
 * @description date
 * @create 2018-06-20 12:49
 */
public class DateUtils
{

    public static void main(String[] args)
    {
        Date begin = DateUtils.strToDate("20160627113000", "yyyyMMddhhmmss");
        Date end = DateUtils.strToDate("20170627112959", "yyyyMMddhhmmss");
        Date now = DateUtils.getCurrentDate("yyyyMMddhhmmss");
        System.out.println(isBetweenDate(begin, end, now));
    }
    
    public static boolean isBetweenDate(Date beginDate, Date endDate, Date compareDate)
    {
        if (compareDate.compareTo(beginDate) != -1 && compareDate.compareTo(endDate) != 1)
        {
            return true;

        }
        return false;
    }
    
    public static Date strToDate(String strDate, String strFormat)
    {
        SimpleDateFormat df = null;
        Date date = null;
        try
        {
            // 使用指定的格式创建日期时间格式
            df = new SimpleDateFormat(strFormat);
        }
        catch (IllegalArgumentException e)
        {
            df = new SimpleDateFormat("yyyyMMddhhmmss");
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
    
    public static Date getCurrentDate(String formater)
    {
        return formdate(format(new Date(), formater), formater);
    }
    
    public static String format(Date date, String formatStr)
    {
        if (date == null)
        {
            return null;
        }
        
        SimpleDateFormat sf = new SimpleDateFormat(formatStr);
        return sf.format(date);
    }
    
    public static Date formdate(String dateStr, String formater)
    {
        formater = (null == formater) ? "yyyy-MM-dd HH:mm:ss" : formater;
        DateFormat formatter = new SimpleDateFormat(formater);
        Date date = null;
        try
        {
            date = formatter.parse(dateStr);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return date;
    }
}
