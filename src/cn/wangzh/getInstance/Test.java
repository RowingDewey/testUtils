package cn.wangzh.getInstance;

public class Test {
	public static void main(String[] args) {
       Singleton singleton1 = Singleton.getInstance();
       Singleton singleton2 = Singleton.getInstance();
       singleton1.setName("第一个");
       singleton2.setName("第二个");
       
       if(singleton1 == singleton2)
       {
    	   System.out.println("singleton1 == singleton2");
       }
       else
       {
    	   System.out.println("singleton1 ! = singleton2");
       }
       System.out.println("name1: " + singleton1.getName());
       System.out.println("name2: " + singleton2.getName());
	}
}
