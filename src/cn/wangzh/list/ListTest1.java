package cn.wangzh.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangzhuohui
 * @description ceshi
 * @create 2018-06-19 21:41
 */
public class ListTest1
{
    public static void main(String[] args)
    {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        map.put("1", list);
        System.out.println(map.get("1").toString());
        for (String str : list)
        {
            if("C".equals(str))
            {
                List<String> list2 = new ArrayList<String>();
                list2.addAll(list);
                list2.add("E");
                map.put("1", list2);
            }
        }
        
        System.out.println(map.get("1").toString());
    }
}
