package cn.wangzh.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Jsontestjiami {

	public static void main(String[] args) throws Exception {
		
		//读取jsonxml.xml配置文件
		String file = getfile();
		System.out.println("file :" +file);
		//des加密
		String encry = DESUtils.encrypt(file);
		System.out.println("加密  =" + encry);
		//des解密
		String decr = DESUtils.decrypt(encry);
		System.out.println("file :" +file);
		System.out.println("解密  =" + decr);
		
		String s1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><charge_request><transId>7fb2d7837eb9477896c443d8160963b844002329500</transId><phoneNumber>13980866161</phoneNumber><requestTime>1232</requestTime><securityCheck>0</securityCheck><cpparam>{\"body\":\"%3CRequest%3E%3CBatchSubscribeChapterReq%3E%3CbookId%3E397573391%3C%2FbookId%3E%3CChapterIdList%3E%3CchapterId%3E397581260-397581353%3C%2FchapterId%3E%3C%2FChapterIdList%3E%3Ccounter%3E0%3C%2Fcounter%3E%3CproductId%3E1053962%3C%2FproductId%3E%3C%2FBatchSubscribeChapterReq%3E%3C%2FRequest%3E\",\"parameters\":\"productId%3D1596171%26contentId%3D998630165%26chapterId%3D998630171%26pageOrder%3D0%26fetchRemaining%3D0%26fascicleId%3D%26count%3D%26catalogId%3D%26formatType%3D1%26supportPayType%3D2%2C205%26continuousToken%3D-1\",\"header\":\"%7BX-Channel-Code%3DAplication%2C+Encoding-Type%3Dutf-8%2C+Client-Agent%3Dappstore%2F320*240%2F123456%2C+Action%3DsubscribeContent2%2C+x-up-calling-line-id%3D13980866161%2C+APIVersion%3D1.0.0%2C+user-id%3D55127b8945f345998da83ac39a14d60b%2C+terminalUniqueId%3D39a936539f3ea3e0%2C+Content-Type%3DocBlmLLODVZ2B1L2AsEjPg%3D%3D%7D\"}</cpparam><ctype>12</ctype><contentId></contentId><channelId>12</channelId><item><itemId>12</itemId><itemPrice>12</itemPrice><itemSafeLevel>12</itemSafeLevel><itemMethod>12</itemMethod><itemExt>123</itemExt></item></charge_request>";
		String s2 = DESUtils.encrypt(s1);
		System.out.println("s2 =" + s2);
		System.out.println("加密  =" + encry);
	}
	
	public static String getfile() throws Exception
	{
		File file = new File("jsonxml.xml");  
        
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();
        temp=br.readLine();
        while(temp!=null)
        {
            sb.append(temp+" ");
            temp=br.readLine();
        }
        return sb.toString();
		
		
		
	}
}
