package cn.wangzh.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhuohui
 * @description ceshi
 * @create 2018-06-29 12:55
 */
public class ListTest2
{
    public static void main(String[] args)
    {
        List<String> arraylist = new ArrayList<String>();
        arraylist.add(null);
        arraylist.add("2");
        System.out.println(arraylist.isEmpty());
        System.out.println(null != arraylist.get(0));
        System.out.println(arraylist.size());
    }
}
