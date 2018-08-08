package cn.wangzh.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import net.sf.json.JSONObject;

public class jsonTestjiexi {

	public static void main(String[] args) throws Exception {
		
		
		String result = fileRead();
		System.out.println("result :" + result);
		String result2 = result.replaceAll("&quot;", "\"");
	
			JSONObject  json = JSONObject.fromObject(result2);
			//ReturnExtModel retu = (ReturnExtModel) JSONObject.toBean(json, ReturnExtModel.class);
			//System.out.println(retu.toString());
			System.out.println("result2 :" + result2);
			//System.out.println("json :"+ json.toString());
			//System.out.println("header :" + URLDecoder.decode(json.getString("header"),"utf-8"));
			//System.out.println("body : "+ URLDecoder.decode(json.getString("body"),"utf-8"));
			//System.out.println("header:" + json.getString("header"));
			
		
		
	}
	
	public static String fileRead()
	{
		File file = new File("TheadTest.txt");
		String result = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));// 构造一个BufferedReader类来读取文件
			String s = null;
			while ((s = br.readLine()) != null) {// 使用readLine方法，一次读一行
				result = result + "\n" + s;
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
}
