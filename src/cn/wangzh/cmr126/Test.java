package cn.wangzh.cmr126;

import java.util.ArrayList;
import java.util.List;

public class Test
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");
        list.add("11");
        System.out.println(list.size());
        System.out.println(list.subList(0, 0 + 3));
        
        double a = 95;
        
        String b = null;
        if(a%10 == 0)
        {
            b = String.valueOf((int)a/10);
        }
        else
        {
            b = String.valueOf(a/10);
        }
        System.out.println(b);
        
        List<String> list1 = new ArrayList<String>();
        System.out.println(list1.isEmpty());
        
    }
    
    
    public static double toDouble(String str, double def)
    {
        double result = def;
        try
        {
            result = Double.parseDouble(str);
        }
        catch (Exception e)
        {
            return result;
        }
        return result;
    }
}
