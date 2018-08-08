package cn.wangzh.time;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class test {
	public static void main(String[] args) {
		System.out.println("1:" +getSignDate());
		System.out.println("2:" +String.valueOf(System.currentTimeMillis()));
	}

    /**
     * 
     * 获取当前系统时间
     * 
     * @author wzh
     * @return date
     */
    public static String getSignDate()
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
        return format.format(new Date());
    }
}
