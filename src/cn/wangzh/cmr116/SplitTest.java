package cn.wangzh.cmr116;

import java.util.ArrayList;
import java.util.List;

public class SplitTest {
    public static void main(String[] args) {
	String str = "551,100,591,931,200,771,851,898,311,371,451,270,731,431,250,791,240,471,951,971,531,351,290,210,280,220,891,991,871,571,230";
	String[] ss = str.split("\\" + ",");
	
	int i =0;
	List<String> list = new ArrayList<String>();
        for (i = 0; i < ss.length; i++)
        {
            list.add(ss[i]);
        }
        System.out.println(list.contains("270"));
    }

}
