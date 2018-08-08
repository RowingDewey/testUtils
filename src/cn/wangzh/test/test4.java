package cn.wangzh.test;

import cn.wangzh.iread.util.PayMentUtil;

import java.util.HashMap;
import java.util.Map;

public class test4
{
    
    private static String RETURN_URL = "http://211.140.7.166:9196/bookseller/portalengine/alipayAgreement/save";
    
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        
        map.put("service", "alipay.dut.customer.agreement.page.sign");
        map.put("partner", "2088101568353491");
        map.put("product_code", "GENERAL_WITHHOLDING_P");
        map.put("access_info", "%7B%22channel%22%3A%22PC%22%7D");
        map.put("_input_charset", "utf-8");
        
        String sign = PayMentUtil.sign(map, "utf-8");
        System.out.println(sign);
        
    }
}
