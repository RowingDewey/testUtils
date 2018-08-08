package cn.wangzh.cmr113;

import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) throws Exception {
		String str = "notify_url=http%3A%2F%2Fwww.hao123.com&ipn_type=ExpressCheckout&payment_type=instant&payment_date=Thu+Apr+28+2016+14%3A54%3A58+GMT%2B0800+(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)&payment_status=Completed&address_status=confirmed&payer_status=verified&first_name=John&last_name=Smith&payer_email=buyer%40paypalsandbox.com&payer_id=TESTBUYERID01&address_name=John+Smith&address_country=United+States&address_country_code=US&address_zip=95131&address_state=CA&address_city=San+Jose&address_street=123+any+street&business=seller%40paypalsandbox.com&receiver_email=seller%40paypalsandbox.com&receiver_id=seller%40paypalsandbox.com&residence_country=US&item_name1=something&item_number1=AK-1234&tax=2.02&mc_currency=USD&mc_fee=0.44&mc_gross=12.34&mc_gross_1=12.34&mc_handling=2.06&mc_handling1=1.67&mc_shipping=3.02&mc_shipping1=1.02&txn_type=cart&txn_id=403904399&notify_version=2.1&custom=xyz123&invoice=abc1234&_csrf=kNBvv694x1FxDAAfJP0VrRsmNszeTzSKR7pqU%3D";
	    String att = java.net.URLDecoder.decode(str,"utf-8");
	    System.out.println("str:" + str);
	    System.out.println("att:" + att);
	    
	    Map<String, String> mtt = getParamMap(att);
	    System.out.println("mtt:" + mtt.toString());
	}
	
	
	/**
     * 
     * paypal获取参数方法
     * 
     * @author wangzhuohui
     * @param request
     * @return map
     * @throws  
     */
    public static Map<String,String> getParamMap(String bodystr)
    {
        Map<String, String> paramsMap = new HashMap<String, String>();
        
        // 以“&”分割parametersStr字符串，得到数组
        String[] paramsarr = bodystr.split("&");
        
        for (String parametersstr : paramsarr)
        {
            String[] arr = parametersstr.split("=", 2);
            
            if (null != arr && arr.length > 1)
            {
                paramsMap.put(arr[0], arr[1]);
            }
            else if (null != arr && arr.length <= 1)
            {
                paramsMap.put(arr[0], "");
            }
        }
        
        return paramsMap;
    }
}
