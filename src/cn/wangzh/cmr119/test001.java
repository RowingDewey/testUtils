package cn.wangzh.cmr119;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class test001
{
    public static void main(String[] args)
    {
        List<String> list1 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        List<String> list2 = new ArrayList<String>();
        list2.add("3");
        list2.add("4");
        list2.add("5");
        list2.add("1");
        System.out.println(list1.retainAll(list2));
        System.out.println(list1);
        System.out.println(list2);
        
        Bean b1 = new Bean("a1");
        Bean b2 = new Bean("a2");
        Bean b3 = new Bean("a3");
        Bean b4 = new Bean("a4");
        Bean b5 = new Bean("a5");
        
        List<Bean> listBean = new ArrayList<Bean>();
        listBean.add(b1);
        listBean.add(b2);
        listBean.add(b3);
        listBean.add(b4);
        listBean.add(b5);
        
        Iterator<Bean> listIt = listBean.iterator();
        
        while(listIt.hasNext())
        {
            Bean b = listIt.next();
            b.setA("b1");
        }
        for(Bean nb : listBean)
        {
            System.out.println(nb.getA());
        }
        
        
    }
    
}

class Bean
{
    private String a;
    
    
    Bean(String a)
    {
        this.a = a;
    }
    public String getA()
    {
        return a;
    }
    
    public void setA(String a)
    {
        this.a = a;
    }
    
}