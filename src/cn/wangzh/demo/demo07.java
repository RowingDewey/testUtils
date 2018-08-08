package cn.wangzh.demo;

import cn.wangzh.iread.util.PayMentUtil;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;


public class demo07
{
    
    public static void main(String[] args) {
//String url = "https://mapi.alipay.com/gateway.do?_input_charset=utf-8&product_code=GENERAL_WITHHOLDING_P&sign_type=RSA&external_sign_no=44000020014&notify_url=http%3A%2F%2Fapi.test.alipay.net%2Fatinterface%2Freceive_notify.htm&scene=INDUSTRY%7CMEDICAL&service=alipay.dut.customer.agreement.page.sign&alipay_logon_id=null&partner=2088101568353491";
//String url ="https://mapi.alipay.com/gateway.do?_input_charset=UTF-8&sign_type=RSA&amp;access_info=%7B%22channel%22%3A%22PC%22%7D&amp;return_url=http://211.140.7.166:9196/bookseller/portalengine/alipayAgreement/save&amp;product_code=GENERAL_WITHHOLDING_P&amp;external_sign_no=44000020014&amp;partner=2088101568353491&amp;notify_url=http%3A%2F%2Fapi.test.alipay.net%2Fatinterface%2Freceive_notify.htm&amp;scene=INDUSTRY%7CMEDICAL&amp;service=alipay.dut.customer.agreement.page.sign";
// String url = "https://mapi.alipay.com/gateway.do?_input_charset=UTF-8&amp;product_code=GENERAL_WITHHOLDING_P&amp;external_sign_no=44000016018&amp;notify_url=http%3A%2F%2Fapi.test.alipay.net%2Fatinterface%2Freceive_notify.htm&amp;service=alipay.dut.customer.agreement.page.sign&amp;scene=INDUSTRY%7CMEDICAL&amp;partner=2088811688060011&amp;access_info=%7B%22channel%22%3A%22PC%22%7D";	
        
        //正式
        //String url = "https://mapi.alipay.com/gateway.do?_input_charset=UTF-8&product_code=GENERAL_WITHHOLDING_P&external_sign_no=44000016018&notify_url=http://211.140.7.166:9196/bookseller/portalengine/alipayAgreement/save&service=alipay.dut.customer.agreement.page.sign&scene=INDUSTRY%7CMEDICAL&partner=2088811688060011&access_info=PC";
        
        //测试return_url=cmread://cmread.com?url=http://www.cmread.com
        
        String url = "https://mapi.alipay.com/gateway.do?"
            + "_input_charset=UTF-8&"
            + "product_code=GENERAL_WITHHOLDING_P&"
            + "external_sign_no=40000087007&"
            // + "notify_url=http://211.140.7.166:9196/bookseller/portalengine/alipayAgreement/save&"
            + "notify_url=http://211.140.7.177:8109/bookseller/portalengine/alipayAgreement/save&"
            
            + "service=alipay.dut.customer.agreement.page.sign&"
            + "partner=2088811688060011&"
            //+ "return_url=cmread://cmread.com?url=http://www.cmread.com&"
            + "return_url=cmread://cmread.com/getResultFromAlipay.do?url=http://www.cmread.com&"
            
            + "scene=INDUSTRY|DIGITAL_MEDIA&"
            + "access_info={\"channel\":\"PC\"}";
        //String url = "https://mapi.alipay.com/gateway.do?return_url=cmread://cmread.com/getResultFromAlipay.do?url=http://www.cmread.com&_input_charset=UTF-8&product_code=GENERAL_WITHHOLDING_P&external_sign_no=40000043081&service=alipay.dut.customer.agreement.page.sign&scene=INDUSTRY|DIGITAL_MEDIA&partner=2088811688060011&access_info={\\\"channel\\\":\\\"ALIPAYAPP\\\"}&notify_url=http://211.140.7.166:9196/bookseller/portalengine/alipayAgreement/save";
        //String url = "https://mapi.alipay.com/gateway.do?_input_charset=UTF-8&product_code=GENERAL_WITHHOLDING_P&external_sign_no=40000098554&notify_url=http://211.140.7.166:9196/bookseller/portalengine/alipayAgreement/save&service=alipay.dut.customer.agreement.page.sign&scene=INDUSTRY|DIGITAL_MEDIA&partner=2088811688060011&access_info={\"channel\":\"PC\"}&return_url=cmread://cmread.com/getResultFromAlipay.do?url=http://www.cmread.com";
        System.out.println(url + "\n");
        
        String[] spliUrl = url.split("\\?", 2);
        String[] spliSignUrl = spliUrl[1].toString().split("\\&");
        HashMap<String, String> map = new HashMap<String, String>();
        for (String s : spliSignUrl)
        {
            String[] signUrl = s.split("\\=", 2);
            if (signUrl != null && signUrl.length > 1)
            {
                if (signUrl[0].equals("access_info"))
                {
                    String ss = signUrl[1];//.replace('\\', (char)('\0'));
                    map.put(signUrl[0], ss);
                    System.out.println("===key: " + signUrl[0] + "  ===value: " + ss);
                }
                else
                {
                    map.put(signUrl[0], signUrl[1]);
                    System.out.println("===key: " + signUrl[0] + "  ===value: " + signUrl[1]);
                    
                }
            }
        }
	     
		 /*Map<String, String> map = new HashMap<String, String>();
	        map.put("_input_charset", "utf-8");
	        map.put("product_code", "GENERAL_WITHHOLDING_P");
	        map.put("external_sign_no", "40000043081");
	        map.put("service", "alipay.dut.customer.agreement.page.sign");
	        map.put("partner", "2088811688060011");
	        map.put("notify_url", "http://211.140.7.166:9196/bookseller/portalengine/alipayAgreement/save");
	        map.put("access_info", "{\"channel\":\"PC\"}");
	        //map.put("access_info", "{\"channel\":\"ALIPAYAPP\"}");
	        map.put("scene", "INDUSTRY|DIGITAL_MEDIA");
	        map.put("return_url", "cmread://cmread.com/getResultFromAlipay.do?url=http://www.cmread.com");
	        */
        String sign = PayMentUtil.sign(map, "UTF-8");
        String access_info = "";
        try
        {
            sign = java.net.URLEncoder.encode(sign, "UTF-8");
            access_info = java.net.URLEncoder.encode(map.get("access_info"), "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        
        map.put("sign", sign);
        map.put("sign_type", "RSA");
        map.put("access_info", access_info);
        //
        //String url1 = "https://mapi.alipay.com/gateway.do";
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(spliUrl[0]).append("?");
        Iterator<Entry<String, String>> iter = map.entrySet().iterator();
        Entry<String, String> entry;
        while (iter.hasNext())
        {
            entry = iter.next();
            strBuilder.append(entry.getKey()).append("=").append(entry.getValue());
            if (iter.hasNext())
            {
                strBuilder.append("&");
            }
        }
        System.out.println(strBuilder.toString());
        
    }
}
