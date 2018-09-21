package cn.wangzh.string;

/**
 * @author wangzhuohui
 * @version V1.0
 * @description
 * @since 2018-09-21 11:37
 */
public class StringTest
{
    public static void main(String[] args)
    {
        String str = "CMREAD_iPhone_Appstore_WH_V7.9.3_180926";
        int i = str.indexOf("_") + 1;
        System.out.println(i);
        int i2= str.indexOf("_", i);
        System.out.println(i2);
        String str2 = str.substring(i, i2).toLowerCase();
        System.out.println(str2);
    }
}
