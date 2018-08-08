package cn.wangzh.cmr126;

import java.util.ArrayList;
import java.util.List;

public class Test1
{
    public static void main(String[] args)
    {
        BatchChaptersCalculateRsp resp = new BatchChaptersCalculateRsp();
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
        resp.setOrdered(true);
        resp.setPayInfoList(list);
        
        System.out.println(resp);
    }
}
