package cn.wangzh.json;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class jsonTest {

	public static void main(String[] args) throws IOException, Exception
	{
		Request request = new Request();
		
		Map<String, String> headermap = new HashMap<String, String>();
		headermap.put("Client-Agent", "appstore/320*240/123456");
		headermap.put("x-up-calling-line-id", "13980866161");
		headermap.put("user-id", "55127b8945f345998da83ac39a14d60b");
		headermap.put("APIVersion", "1.0.0");
		headermap.put("Action", "subscribeContent2");
		headermap.put("Encoding-Type", "utf-8");
		headermap.put("Content-Type", "ocBlmLLODVZ2B1L2AsEjPg==");
		headermap.put("X-Channel-Code", "Aplication");
		headermap.put("terminalUniqueId", "39a936539f3ea3e0");
		
		request.setHeader(URLEncoder.encode(headermap.toString(),"UTF-8"));
		//System.out.println(headermap.toString());
		String parameters = "productId=1596171&contentId=998630165&chapterId=998630171&pageOrder=0&fetchRemaining=0&fascicleId=&count=&catalogId=&formatType=1&supportPayType=2,205&continuousToken=-1";
		//String parameters = "";
		request.setParameters(URLEncoder.encode(parameters, "utf-8"));
		String body = "<Request>" +
				"<BatchSubscribeChapterReq>" +
				"<bookId>397573391</bookId>" +
				"<ChapterIdList>" +
				"<chapterId>397581260-397581353</chapterId>" +
				"</ChapterIdList>" +
				"<counter>0</counter>" +
				"<productId>1053962</productId>" +
				"</BatchSubscribeChapterReq>" +
				"</Request>";
		request.setBody(URLEncoder.encode(body, "utf-8"));
		JSONObject jo = new JSONObject(request);
		//jo = JSONObject.fromObject(free);
//		JSONObject cpparamJson = new JSONObject();
//
//            try {
//				cpparamJson = new JSONObject("{}");
//			} catch (org.json.JSONException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        System.out.println(cpparamJson.toString());
 
		System.out.println("json:  " + jo.toString() +"\n");
		System.out.println("header:  " +jo.getString("header"));
		System.out.println("parameters:  " +jo.getString("parameters"));
		System.out.println("body:  " + jo.getString("body"));
	}
}
