package cn.wangzh.json;

import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class jsonTesttest
{
    public static void main(String[] args)
    {
        String jsonXml = "<?xml version='1.0' encoding='UTF-8'?> <ChargeNotificationRequest> <Header> <MsgType>12054</MsgType> <ActionCode>1</ActionCode> <SUBCOMPANYID>345</SUBCOMPANYID> <Version>3.1</Version> <ProcessTime>20161111172152</ProcessTime> </Header> <Body> <LAUNCH_TYPE></LAUNCH_TYPE> <ORDER_COUNT>1</ORDER_COUNT> <ORDER_ITEM> <MPOrderItem_Schema> <INDEX>1</INDEX> <ORDER_ID>0220101160829420092888</ORDER_ID> <PHONENUMBER>14732254003</PHONENUMBER> <OPER_CODE>01</OPER_CODE> <OPER_CHANNEL>111</OPER_CHANNEL> <SP_CODE>555</SP_CODE> <SP_SERV_CODE>666</SP_SERV_CODE> <AMOUNT>100</AMOUNT> <CHANNEL_CODE>000</CHANNEL_CODE> <EXTEND_ATTR>210</EXTEND_ATTR> </MPOrderItem_Schema> </ORDER_ITEM> </Body> </ChargeNotificationRequest>";
        JSONObject json = JSONObject.fromObject(xml2JSON(jsonXml));
        
        System.out.println("json=" + json);
        
    }
    
    /**
     * XML转化为JSON字符串
     * 
     * @param xml
     * @return jsonstr
     */
    public static String xml2JSON(String xml)
    {
        return new XMLSerializer().read(xml).toString();
    }
    
    /**
     * 
     * 截取字符串
     *
     * @author wangzhuohui
     */
    public static void subString()
    {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ORDER_ID>0210104210203300002999</ORDER_ID>";
        String startbilling = "<ORDER_ID>";
        String endbilling = "</ORDER_ID>";
        int beginIndex = xml.indexOf(startbilling) + 10;
        int endIndex = xml.indexOf(endbilling);
        xml = xml.substring(beginIndex, endIndex);
        String json = "{\"ORDER_ID\": "+ "\"" + xml +"\"}";
        System.out.println(json);
    }
}
