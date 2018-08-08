package cn.wangzh.json;


import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class JsonTest3 {

	public static void main(String[] args) throws IOException, Exception
	{
		ReturnExtModel model = new ReturnExtModel();
		
		Map<String, String> headermap = new HashMap<String, String>();
		headermap.put("result-code", "200");
		headermap.put("APIVersion", "1.0.0");
		headermap.put("Action", "batchSubscribeChapter");
		headermap.put("TimeStamp", "20151222102236800");
		headermap.put("Content-Type", "Aplication");
		headermap.put("encoding-type", "");
		
		
		model.setHeader(URLEncoder.encode((new JSONObject(headermap)).toString(),"UTF-8"));

		String body = "<response></response>";
		model.setBody(URLEncoder.encode(body,"utf-8"));
		System.out.println(model.toString());
		JSONObject jo = new JSONObject(model);

 
		System.out.println("json:  " + jo.toString() +"\n");
		System.out.println("header:  " +jo.getString("header"));
		//System.out.println("parameters:  " +jo.getString("parameters"));
		System.out.println("body:  " + jo.get("body"));
	}
}
