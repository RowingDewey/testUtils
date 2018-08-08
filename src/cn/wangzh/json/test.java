package cn.wangzh.json;

import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	private static String sta = "10";
	
	public static void main(String[] args) {
//		String str = "Hello";
//
//		byte[] srtbyte = str.getBytes();
//
//		// byte[] 转 string
//		System.out.println(srtbyte.toString());
//		String res = new String(srtbyte);
//
//		System.out.println(res);
//		System.out.println("staold=" +sta);
//		sta = "111";
//		System.out.println("stanew=" +sta);
//		String type = "203";
//		String flag = "1";
//		boolean  f = (!(type.contains("203")) || !(type.contains("202")) || flag.equals("0"));
//		System.out.println("1 =" + f);
//		boolean b = (type.contains("203") || type.contains("202")) && flag.equals("1");
//		System.out.println("2 =" + b);
//		String fee = "";
//		
//		System.out.println("flag=" + checkNum(fee));
		
		HashSet<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("2");
		set.add("1");
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}
	
    public static boolean checkNum(String str)
    {
        boolean flag = true;
        Pattern pattern = Pattern.compile("[1-9][0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches())
        {
            flag = false;
        }
        return flag;
    }
}
