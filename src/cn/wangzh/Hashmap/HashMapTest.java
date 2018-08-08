package cn.wangzh.Hashmap;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
	public static void main(String[] args) throws Exception
	{
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("q","qwa");
		
		map.put("w","wwa");
		map.put("e","qqa");
		map.put("r","");
		String a = map.toString();
		System.out.println("1."+a);
		String s = URLEncoder.encode(a, "utf-8");
		System.out.println(s);
		String s1 = URLEncoder.encode(s, "utf-8");
		System.out.println(s1);
		String d = URLDecoder.decode(s, "utf-8");
		System.out.println(d);
//		a = a.replaceAll(" ", "");
//		a = a.replaceAll("\\{", "");
//		a = a.replaceAll("\\}", "");
		String reg = " |\\{|\\}";
		a = a.replaceAll(reg, "");
		System.out.println("2."+a);
		String[] arr = a.split(",");
		System.out.println(arr.length);
		HashMap<String, String> map1 = new HashMap<String, String>();
		for(String arrs : arr)
		{
			String[] arrarr = arrs.split("=");
			//System.out.println(arrarr.length);
			if(null != arrarr && arrarr.length>1)
			{
				map1.put(arrarr[0],arrarr[1]);
				System.out.println(arrarr[0]+"="+arrarr[1]);
			}
			else if(null != arrarr && arrarr.length<=1)
			{
				map1.put(arrarr[0], "");
				System.out.println(arrarr[0]+"="+"");
			}
		}
		
		System.out.println(map1.toString());
	}

}
