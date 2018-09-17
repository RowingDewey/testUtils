package cn.wangzh.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wangzhuohui
 * @version V1.0
 * @description 测试类
 * @since 2018-09-04 10:07
 */
public class ListSetTest
{
    public static void main(String[] args)
    {
        List<String> setStr = new ArrayList<String>();
        setStr.add("q");
        setStr.add("e");
        setStr.add("w");
        setStr.add("r");
        setStr.add("tq");
        setStr.add("qy");
        setStr.add("qv");
    
        Set<Student> listStr = new HashSet<Student>();
        Student student = new Student("a", "a");
        listStr.add(student);
        Student student1 = new Student("a1", "a1");
        listStr.add(student1);
        Student student2 = new Student("a2", "a2");
        listStr.add(student2);
        Student student3 = new Student("a3", "a3");
        listStr.add(student3);
        Student student4 = new Student("a4", "a4");
        listStr.add(student4);
        
        for(String a : setStr)
        {
            for (Student b : listStr)
            {
                System.out.println("a=" + a + ", b=" + b.getId());
            }
        }
    }
}
