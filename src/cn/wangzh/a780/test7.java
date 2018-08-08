package cn.wangzh.a780;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test7 {
	public static void main(String[] args) {
        String key ="10_CSP00781_-1_reward_product_id215_012_1";
        Map<String, String> map = new HashMap<String, String>();
        String[] keys = subKey(key);
        for(int i = 0; i<keys.length;i++)
        {
        	map.put(keys[i],keys[i]);
        	
        }
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext())
        {
        	String key1 = (String)it.next();
        	String value = map.get(key1);
        	System.out.println("key:" + key1 + "   value:" + value);
        }

	}
	
	public static String[] subKey(String key)
    {
        String keys[] = key.split("_");
        
        if(keys.length == 7)
        {
            String values[] = new String[6];
            values[0] = keys[0];
            values[1] = keys[1];
            values[2] = keys[2];
            values[3] = keys[3] + "_" + keys[4];
            values[4] = keys[keys.length -2];
            values[5] = keys[keys.length -1];
            return values;
        }
        else if(keys.length == 8)
        {
            String values[] = new String[6];
            values[0] = keys[0];
            values[1] = keys[1];
            values[2] = keys[2];
            values[3] = keys[3] + "_" + keys[4] + "_" + keys[5];
            values[4] = keys[keys.length -2];
            values[5] = keys[keys.length -1];
            return values;
        }
        else
        {
            return keys;
        }
        
    }
}
