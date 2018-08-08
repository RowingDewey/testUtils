package cn.wangzh.cmr116;

import org.json.JSONObject;

public class JsonTest
{
    public static void main(String[] args)
        throws Exception {
        String jsonstr = "{\"payType\":8, \"rate\":\"\"}";
        JSONObject json = new JSONObject(jsonstr);
        System.out.println("json:" + json);
        
    }
}
