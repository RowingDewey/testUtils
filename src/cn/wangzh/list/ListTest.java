package cn.wangzh.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhuohui
 * @description List测试示例
 * @create 2018-06-18 20:43
 */
public class ListTest
{
    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        List<String> list2 = new ArrayList<String>();
        list2.add("C");
        list2.add("D");
        list2.add("E");
        list2.add("F");
        
        // 取交集
        //list.retainAll(list2);
        System.out.println(list.toString());
        
        // 取并集
        list.addAll(list2);
        list2.clear();
        System.out.println(list.toString());
        System.out.println(list2.toString());
        //无重复并集
        //list.removeAll(list2);
        //list.addAll(list2);
        System.out.println(list);
    }
}
