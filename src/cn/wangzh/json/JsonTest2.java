package cn.wangzh.json;

import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class JsonTest2 {
	public static void main(String[] args) {
		String xml = "<charge_request>"
				+ "<transId>交易流水</transId>"
				+ "<phoneNumber>手机号码</phoneNumber>"
				+ "<requestTime>请求时间</requestTime>"
				+ "<securityCheck>安全签权结果，0-正常</securityCheck>"
				+ "<cpparam>{header:{x-up-bear-type: WLAN,clientHash: JEOLOBCJ12IQpUTmRApu4w==};"
				+ "parameters: productId=1053962& contented=397573391& chaptered=397581260;"
				+ "body:<Request><BatchSubscribeChapterReq><bookId>397573391</bookId><ChapterIdList> <chapterId>397581260-397581353</chapterId></ChapterIdList><counter>0</counter><productId>1053962</productId></BatchSubscribeChapterReq></Request>}</cpparam>"
				+ "<content>"
				+ "<ctype>数字内容类型(1.音乐 2.阅读 3.游戏 4.动漫 5.视频)</ctype>"
				+ "<contentId>内容ID</contentId>"
				+ "<channelId>推广渠道ID</channelId>" + "<item>"
				+ "<itemId>计费点</itemId>"
				+ "<itemPrice>计费点价格（计费界面展示）</itemPrice>"
				+ "<itemSafeLevel>包体安全级别。</itemSafeLevel>"
				+ "<itemMethod>计费策略。</itemMethod>"
                + "<itemExt>计费信息扩展字段</itemExt>" + "</item>" + "</content>"
                + "</charge_request>";

        FileInputStream inputstream;
        try {
            inputstream = new FileInputStream("TheadTest.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = null;
            builder = dbf.newDocumentBuilder();
            Document document = builder.parse(inputstream);
            Element element = document.getDocumentElement();
            System.out.println("element:" +element.getNodeName());
            if (null != element) 
            {
                NodeList nodelist = element.getChildNodes();
                if (nodelist != null) 
                {
                    for (int i = 0; i < nodelist.getLength(); i++) 
                    {
                        Node child = nodelist.item(i);
                        //System.out.println("child:" +child.getNodeName());
                      //  System.out.println();
                        
                        
                        if("wang".equals(child.getNodeName()) && child.getNodeType() == Node.ELEMENT_NODE)
                        {
                        	System.out.println(child.getNodeName()+ ":" + child.getTextContent());
                        }
                     }
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
