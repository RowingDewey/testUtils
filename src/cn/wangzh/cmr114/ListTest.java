package cn.wangzh.cmr114;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		ListBean resp = new ListBean();
		List<MarkBean> list = resp.getList();
		for(MarkBean str : list)
		{
			String markid = str.getMarkId();
			//System.out.println("***********" + markid);
		}
		
		List<String> list2 = new ArrayList<String>();
		list2.add("1");
		list2.add("2");
		list2.add("3");
		list2.add("4");
		list2.add("5");
		list2.add("6");
		
		System.out.println("sublist:" + list2.subList(0, 5));
		System.out.println("index:" + list2.get(0));
	}
}
