package cn.wangzh.test;

import java.util.ArrayList;
import java.util.List;

public class test5 {
	public static void main(String[] args){
		List<String> list = new ArrayList<String>();
			list.add(";257038;458574;");
			list.add(";775904;975901;");
			for(String list1 : list)
			{
				System.out.println(list1);
				String str = ";775904;";
				System.out.println(list1.indexOf(str,0));
			}
			
			long a = 1234;
			System.out.println(String.valueOf(a));
			System.out.println(Long.toString(a));
			
	}

}
