package cn.wangzh.string;

import java.lang.reflect.Field;

/**
 * @author wangzhuohui
 * @version V1.0
 * @description 字符串改变长度
 * @since 2018-09-17 11:03
 */
public class StringChangeLength
{
    public static void main(String[] args)
    {
        String str = "Hello Python";
        System.out.println(str);
        System.out.println(str.hashCode());
    
        try
        {
            Field field = String.class.getDeclaredField("value");
            field.setAccessible(true);
            char[] value = (char[])field.get(str);
            
            value[6] = 'J';
            value[7] = 'a';
            value[8] = 'v';
            value[9] = 'a';
            System.out.println(str);
            System.out.println(str.hashCode());
        }
        catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    
    }
}
