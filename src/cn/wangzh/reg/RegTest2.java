package cn.wangzh.reg;

import java.util.regex.Pattern;

/**
 * @author wangzhuohui
 * @description 匹配一个字符串是否包含另一个字符串
 * @create 2018-06-18 21:10
 */
public class RegTest2
{
    public static void main(String[] args)
    {
        String str = "Welcome to here acb";
        String keyword = "acb";
        searchStr(str, keyword);
    }
    
    public static void searchStr(String content, String keyword)
    {
//        String otherStr = "([^a-zA-Z])" + keyword + "([^a-zA-Z])";
        String otherStr = "(.*)([^a-zA-Z]" + keyword + ")(([^a-zA-Z])(.*))*";

        boolean flag = Pattern.matches(otherStr, content);
        if(flag)
        {
            System.out.println("包含字符串=" + keyword);
        }
        else
        {
            System.out.println("不包含字符串=" + keyword);
        }
    }
}
