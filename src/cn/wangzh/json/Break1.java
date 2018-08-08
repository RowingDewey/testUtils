package cn.wangzh.json;

import java.util.HashMap;
import java.util.Iterator;

public class Break1 {
	
	public static void main(String[] args) {

		System.out.println("结果=" + getvalue());
	}
	
	static String getvalue()
	{
		String[] vs = {"19","20","19","19","21","22","19","111","222","2222"};
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("1", "10");
		map.put("2", "11");
		map.put("3", "12");
		map.put("4", "13");
		map.put("5", "14");
		map.put("6", "15");
		map.put("7", "16");
		map.put("8", "17");
		String br = null;
		for(int i=0;i<vs.length;i++)
		{
			System.out.println("i=" + i);
			String ll = vs[i];
			Iterator<String> it = map.keySet().iterator();
			while(it.hasNext())
			{
				String value = map.get(it.next());
				if(ll.equals(value))
				{
					br = value;
					System.out.println("value=" + value);
					return value;
				}
			}
//			if(br != null)
//			{
//				break;
//			}
			
		}
		return "over";
		
	}
}
