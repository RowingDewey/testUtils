package cn.wangzh.cmr126;

import java.util.ArrayList;
import java.util.List;

public class TestSubList
{
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add( "1");
        list.add( "2");
        list.add( "3");
        list.add( "4");
        list.add( "5");
        list.add( "6");
        list.add( "7");
        list.add( "8");
        list.add( "9");
        list.add( "10");
        
        int index = list.indexOf("a");
        System.out.println(index);
        List<String> list2 = list.subList(0, index);
        
        System.out.println(list2);
        
         /**
         * subList(fromIndex,toIndex)
         * 对指定的集合从下标formIndex取到下标toIndex,[fromIndex,toIndex),
         * 对于指定size=10的集合，下标有0 -10，共11个下标，
         */
//        List<String> sublist1 = list.subList(0, 5); // [1, 2, 3, 4, 5]
//        List<String> sublist2 = list.subList(5, 9); //  [6, 7, 8, 9]
//        List<String> sublist3 = list.subList(5, 10); // [6, 7, 8, 9, 10]
//        List<String> sublist4 = list.subList(10, 10); // []
//        //List<String> sublist5 = list.subList(10, 11); // IndexOutOfBoundsException: toIndex = 11
//         //
//        System. out.println(sublist1);
//        System. out.println(sublist2);
//        System. out.println(sublist3);
//        System. out.println(sublist4);
        //System. out.println(sublist5);            
  }
}
