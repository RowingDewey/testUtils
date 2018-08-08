package cn.wangzh.cmr117;

import java.util.HashMap;
import java.util.Map;

public class test01 {
public static void main(String[] args) {
   Map<String,Object> map = new HashMap<String, Object>();
   map.put("1", true);
   map.put("2", "1232");
   //map.put("1", false);
   System.out.println(""+ map);
   if((Boolean) map.get("1"))
   {
       System.out.println("12121" + map.get("3"));
   }
}
}
