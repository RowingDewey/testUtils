package cn.wangzh.xml;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CdataTest
{
    
    /**
     * 章节内容显示头
     */
    public static final String CONTENT_FORMAT_HEAD = "<![CDATA[";

    /**
     * 章节内容显示尾
     */
    public static final String CONTENT_FORMAT_END = "]]>";
    
    public static void main(String[] args)
    {
        String str = "<![CDATA[{\"channel\":\"ALIPAYAPP\"}]]>";
        String reg = "<!\\[CDATA\\[(.*)\\]\\]>";
        Pattern pattern = Pattern.compile(reg);
        Matcher m = pattern.matcher(str);
        if (m.find())
        {
            str = m.group(1);
        }
        
        System.out.println("str=" + str);
    }
}
