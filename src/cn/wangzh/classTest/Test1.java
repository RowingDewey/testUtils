package cn.wangzh.classTest;

import java.util.HashMap;

public class Test1
{
    public static void main(String[] args)
    {
        ModelTest test = new ModelTest();
        System.out.println(test.getName());
        test.setAge("");
        test.setObject(null);
        System.out.println(test.getAge());
        HashMap<String, String> map = new HashMap<String, String>();
        String value = (String)test.getObject();
        System.out.println("value=" + value);
    }
}
