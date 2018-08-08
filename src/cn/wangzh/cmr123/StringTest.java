package cn.wangzh.cmr123;

public class StringTest
{
    public static void main(String[] args)
    {
        String str = null;
        boolean flag = "null".equals(str.trim());
        boolean flag1 = ((str == null) || (str.trim().length() == 0));
        System.out.println("flag=" + flag);
        System.out.println("flag1=" + flag1);
    }
}
