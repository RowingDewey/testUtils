package cn.wangzh.cmr114;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListCompareTest {
public static void main(String[] args) {
	List<Object> list = new ArrayList<Object>();
	
//	list.add("1");
//	list.add("0");
//	list.add(0.1);
//	list.add('a');
//	System.out.println("list=" + list);
//	for(Object obj : list)
//	{
//		System.out.println("******=" + obj);
//	}
	List<String> list1 = new ArrayList<String>();
	Map<String, String> map = new HashMap<String, String>();
	MarkBean mark = new MarkBean();
	mark.setMarkId("2");
	MarkBean mark1 = new MarkBean();
	map.put("1", "12");
	map.put("1","13");
	map.put("2", "21");
	map.put("3", "32");
	for(Map.Entry<String, String> entry : map.entrySet())
    {
		list1.add(entry.getValue());
		
		System.out.println("list1= " + list1);
    }
	System.out.println("asa=="  + map.get(mark.getMarkId()));
	System.out.println("asa=="  + map.get(mark1.getMarkId()));
	MarkBean mark2 = new MarkBean();
	mark2.setMarkId(map.get(mark1.getMarkId()));
	System.out.println("#####"+ mark2);
	
//	System.out.println("list11 = " + list1);
//	map.put("1", "12");
//	map.put("1","13");
//	System.out.println("map=" + map.toString());
//	System.out.println("map1=" + (map.get("1") == null));
//	System.out.println("map2=" + (map.get("13") == null));
	
}
}
