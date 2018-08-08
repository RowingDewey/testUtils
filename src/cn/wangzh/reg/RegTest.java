package cn.wangzh.reg;

import java.util.regex.Pattern;

/**
 * @author wangzhuohui
 * @description 正则表达式示例
 * @create 2018-06-18 20:12
 */
public class RegTest
{
    public static void main(String[] args)
    {
        String str = "a&a";
        String str2 = "a|p";
        
        //String reg = "[a-zA-Z]{1,} + [&]? + [a-zA-Z]?";
        String reg = "(([a-zA-Z]+)(&[a-zA-Z])?)|(([a-zA-Z]+)(\\|[a-zA-Z])?)";
        
        boolean flag = Pattern.matches(reg, str);
        boolean flag2 = Pattern.matches(reg, str2);
        System.out.println("flag = " + flag + ", flag2 = " + flag2);
    }
}
