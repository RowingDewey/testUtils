package cn.wangzh.reflect;
import java.lang.*;
import java.lang.reflect.Field;

/**
 * @author wangzhuohui
 * @create 2018-05-31 12:49
 * @desc java反射获取set get方法
 */
public class ReflectClassTest
{
    public static void main(String[] args)
    {

        try
        {
            Class clazz = Class.forName("cn.wangzh.reflect.ReflectClassDemo");
            ReflectClassDemo demo = (ReflectClassDemo)clazz.newInstance();
            //f.setAccessible(true);
            Field f = clazz.getDeclaredField("name");
            f.set(demo,"zhangsan");
            System.out.println(demo.getName());   //
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
