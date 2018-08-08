package cn.wangzh.cmr115;

import org.json.JSONException;
import org.json.JSONObject;



public class JsonTest {
public static void main(String[] args) {
    StringBuilder strbu = new StringBuilder();
    strbu.append("{");
    strbu.append("\"code\":");
    strbu.append("\"0000\",");
    strbu.append("\"innercode\":");
    strbu.append("\"0000\",");
    strbu.append("\"message\":");
    strbu.append("\"TEST测试桩\"");
    strbu.append("}");
    
    String str = strbu.toString();
    System.out.println("str:" + str);
    System.out.println(str.toString());
    
    try {
	JSONObject respJson = new JSONObject(str);
	System.out.println("json:" + respJson.toString());
    } catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
    }
    
}
}
