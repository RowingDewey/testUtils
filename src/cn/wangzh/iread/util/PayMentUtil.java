package cn.wangzh.iread.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayMentUtil {

	/**
	 * 私钥 测试
	 */
	//2088101568353491
//	private static String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALkCftxYKovteEu9N99K60x05AvhMVlCwp5zPw0xZUIrqZRT0pkBQbeyapvArKPlApAu2pL9C/PzejEjuIpTvdQASxKGGGLc2mbmrol5XZ55ELHjvtgH+PZJn7whVGW5vWapJJUgLE+FmICG7/W1JIbCW60lOx8AHHQmLVOmmcoDAgMBAAECgYAJoz2kkNs2itpXZ7X/ZdG4G+a9T6/YbIfi5TIFp+sUdV3SIkO4QL6BqUOwdWsI5qcph6dPPOtge/CDms7ENfSPfeNeJErnVpFl/gSngvEALKvdRH16nu25N+asdD25qdupb/bQ9KMEl0AKML/MArPlbixkIvsT265g7Vdnl4UKMQJBAPBHL3wjLGa7kSS14UmJhQCXc3todk5ySq7TOUidZ+7siEOsBvEmg1Llx4Q/w6e1nRlo82MLmxKFX0rR7/Ve158CQQDFHYeVDWK+DRiwOe30Gg1Y+hK9UJl7tlmZTqi4dSlQo+4r3PeBDwD3tl0rVM5vOJ0FCyXI196afRdHAtYzW4MdAkEAz0RIxOe+hHwmTymJxhqXnZQHrRvGehMDM13Hm0kU/7gQL3f0oQ8c12SZQA6VI1V5yBKNaRH42fgs5GjGer4udwJAc3WcmV5B3HjnYTJNg5JPBzNUDrhLbv+c9APzKDjYfnfHZsID6ADV3ENhx6PhV5ydvPqOo1pu9acYH2w189dCsQJBAM82cV9eZSA4EyqZ7OEQkQ42Tn0leLV3i7Q1s0jq1irsmtYaY4XAtxdd6TBQnVQmW4Upl035fkvFTx2ChgC5M/A=";

	
	//正式
	//2088811688060011
	private static String PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ2ZO5hrdFhMdnERHrf5WqZkyzockQX0Uvfahu3B1hEWe3E9iA1tGDZZMFAXGL3nIsHhF/iPiiRa0B7VAFBhKqtcWzXkZMvgnpNlV+2NAdSj2fZVnxws20ZKdc7BCP5R8LLo8qh9wtkr/cf5zdQWJYpR5tZHi3vdAX5wkXG6XBsrAgMBAAECgYBP9uEjPFqDNwDd6+bfSFlzli775GS9VbQHaM0PtEuOzg6CbcsrrNAdO3HlIWL/cFjVcQX9q69XNPDmxALtxe+kyUf70DhK9TmjA0xm6mjTi2I1ZETmvPKinW7/koFn1yZlzeMfKkL1cLYF+HP/U7dw5ufDjqbiE8xKZkmQbrtUmQJBAM4YCNZEwe75OZphQyeEvdhFHh/e3orOFDZ3tEu6zniMxJx9QKQIMOIwDRDnVm+cdU+rCt3GwtWiOjCQViiyuYUCQQDDwuzRHvmed1WssoQwoeF7LAPdYnriRR8L90pDKjdzeZ43U5+/Kw0EykyMHh1UE/t4TxF1h0he4PZtt/dEncjvAkA2Aph2RsioLwpIigrGVYRHJD3zzj12FPG5IH/QhOFNOF7iP/Trx/W/oSYbcvT1BQS9Xy7W1hsDT6N+TKU3vzbdAkB7mDjuOxE8lHlaBIdjMQFsQ7jY8FFHRH66jlGroB7MYE+c/MYR6ztX9+VmXakEqW0OY1VRj60Igh3z3b9W6guvAkEAnwcsX5HiaO6Gn3Ns8IHV39v3OcASgLhzvfTmL/dQJTNX7aJ0hZE49sgYuxl4tt2Kf/39IDtd1VPipe6JHQdO1Q==";
	
	// MD5密钥
//     private static String PRIVATE_KEY = "k8rhug4qoajql4v8g2jkvh3kn662hhl3";
	
	
	/**
     * 
     * 构造请求参数列表
     * 
     * @author zhaoxinwei
     * @param external_sign_no
     * @param alipay_user_id
     * @param alipay_logon_id
     * @return
     */
    public static String sign(Map<String, String> paraMap,String charset)
    {
    	//Map<String, String> map = new HashMap<String, String>();
    	
    	
        // 过滤空值、sign与sign_type参数
        Map<String, String> sParaNew = PayMentUtil.paraFilter(paraMap, true);
        // 获取待签名字符串
        String preSignStr = PayMentUtil.createLinkString(sParaNew);
        System.out.println("presign:" + preSignStr);
        //RSA加密
        String sign = RSA.sign(preSignStr, PRIVATE_KEY, charset);
        return sign;
    }
	
	/**
     * 除去数组中的空值和签名参数
     * 
     * @param sArray 签名参数组
     * @param isFilter 是否过滤
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray, boolean isFilter)
    {
        
        Map<String, String> result = new HashMap<String, String>();
        
        if (sArray == null || sArray.size() <= 0)
        {
            return result;
        }
        
        for (String key : sArray.keySet())
        {
            String value = sArray.get(key);
            if (value == null || value.equals("") || key.equalsIgnoreCase("sign") || key.equalsIgnoreCase("sign_type"))
            {
                continue;
            }
            
            result.put(key, value);
            
        }
        
        return result;
    }
	
	/**
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * 
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params)
    {
        
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        
        StringBuffer prestr = new StringBuffer();
        
        for (int i = 0; i < keys.size(); i++)
        {
            String key = keys.get(i);
            String value = params.get(key);
            
            if (i == keys.size() - 1)
            {
                // 拼接时，不包括最后一个&字符
                prestr.append(key).append("=").append(value);
            }
            else
            {
                prestr.append(key).append("=").append(value).append("&");
            }
        }
        
        return prestr.toString();
    }

}
