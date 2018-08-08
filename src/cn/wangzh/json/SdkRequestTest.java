package cn.wangzh.json;

import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

public class SdkRequestTest {

	public static void main(String[] args) throws Exception {

		String json = getJson();
		String desreq = getDesRequest(json);
		String request = getDes(desreq);
		System.out.println("billing: " + request);
	}

	//得到json对象
	public static String getJson() throws Exception {
		Rechage request = new Rechage();
		
		//设置请求头 header
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

		request.setHeader(URLEncoder.encode(headermap.toString(), "UTF-8"));
		// 设置请求参数 parameters
		String parameters = "productId=1596171&contentId=998630165&chapterId=998630171&pageOrder=0&fetchRemaining=0&fascicleId=&count=&catalogId=&formatType=1&supportPayType=2,205&continuousToken=-1";
		// String parameters = "";
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
		String json = jo.toString();
		//System.out.println("json:  " + json + "\n");
		String header = jo.getString("header");
		//System.out.println("header:  " + header);
		String parameters2 =jo.getString("parameters");
		//System.out.println("parameters:  " + parameters2);
		String body2 = jo.getString("body");
		//System.out.println("body:  " + body2 + "\n");
		
		return json;
	}
	//得到des加密请求参数
	public static String getDesRequest(String json)
	{
		StringBuilder strbuil = new StringBuilder();
		
		strbuil.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		strbuil.append("<charge_request>");
		strbuil.append("<transId>7fb2d7837eb9477896c443d8160963b844002329500</transId>");
		strbuil.append("<phoneNumber>13980866161</phoneNumber>");
		strbuil.append("<requestTime>1232</requestTime>");
		strbuil.append("<securityCheck>0</securityCheck>");
		strbuil.append("<cpparam>");
		strbuil.append(json);
		strbuil.append("</cpparam>");
		strbuil.append("<ctype>12</ctype>");
		strbuil.append("<contentId></contentId>");
		strbuil.append("<channelId>12</channelId>");
		strbuil.append("<item>");
		strbuil.append("<itemId>12</itemId>");
		strbuil.append("<itemPrice>12</itemPrice>");
		strbuil.append("<itemSafeLevel>12</itemSafeLevel>");
		strbuil.append("<itemMethod>12</itemMethod>");
		strbuil.append("<itemExt>123</itemExt>");
		strbuil.append("</item>");
		strbuil.append("</charge_request>");
		
		String str = strbuil.toString();
		
		System.out.println("desResquest =" + str);
		
		return str;
		
	}	
	
	//des加密算法
	public static String getDes(String str)
	{
		//des加密
		String encry = DESUtils2.encrypt(str);
		//System.out.println("加密  =" + encry);
		//des解密
		String decr = DESUtils2.decrypt(encry);
		//System.out.println("str :" +str);
		//System.out.println("decr:" + decr);
		return encry;
		
	}
	
	static class Rechage {
    	private String header;
    	private String parameters;
    	private String body;
    	public String getHeader() {
    		return header;
    	}
    	public void setHeader(String header) {
    		this.header = header;
    	}
    	public String getParameters() {
    		return parameters;
    	}
    	public void setParameters(String paramters) {
    		this.parameters = paramters;
    	}
    	public String getBody() {
    		return body;
    	}
    	public void setBody(String body) {
    		this.body = body;
    	}
    	@Override
    	public String toString() {
    		return "rechage [header=" + header + ", paramters=" + parameters
    				+ ", body=" + body + "]";
    	}
    	
    }
}

class DESUtils2
{
    
    /**
     * DES解密秘钥
     */
    private static String key = "n43XY3Gg";
    
    /**
     * DES解密算法
     * 
     * @param String decryStr
     * @param password key
     * @return String decryResult
     */
    public static String decrypt(String decryStr)
    {
        byte[] decryResult = null;
        byte[] decryByte = null;
        
        try
        {
            decryByte = decryStr.getBytes("UTF-8");
            decryResult = DESUtils.decrypt(Base64.decodeBase64(decryByte), key);
        }
        catch (Exception e)
        {
            System.out.println("decrypt error");
            return null;
        }
        
        return new String(decryResult);
    }
    
    /**
     * DES加密算法
     * 
     * @param String decryStr
     * @param password key
     * @return String decryResult
     */
    public static String encrypt(String decryStr)
    {
        byte[] decryResult = null;
        byte[] decryByte = null;
        
        try
        {
            decryByte = decryStr.getBytes("UTF-8");
            decryResult = DESUtils.encrypt(decryByte, key);
        }
        catch (Exception e)
        {
            System.out.println("encrypt error");
            return null;
        }
        
        return new String(Base64.encodeBase64(decryResult));
    }
    
    /**
     * DES加密算法
     * 
     * @param datasource byte[]
     * @param password String
     * @return byte[]
     */
    public static byte[] encrypt(byte[] datasource, String password)
    {
        try
        {
            SecureRandom random = new SecureRandom();
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
            // 现在，获取数据并加密
            // 正式执行加密操作
            return cipher.doFinal(datasource);
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 解密
     * 
     * @param src byte[]
     * @param password String
     * @return byte[]
     * @throws Exception
     */
    public static byte[] decrypt(byte[] src, String password)
        throws Exception
    {
        // DES算法要求有一个可信任的随机数源
        SecureRandom random = new SecureRandom();
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(password.getBytes());
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, random);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }
    
}




