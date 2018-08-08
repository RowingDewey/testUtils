package cn.wangzh.cmr114;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "111");
		map.put("2", "222");
		map.put("1", "122");
		System.out.println("map:" + map.toString());
	}

}
