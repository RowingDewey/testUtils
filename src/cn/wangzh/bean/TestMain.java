package cn.wangzh.bean;

public class TestMain
{
    public static void main(String[] args)
    {
        Father f = new Father();
        f.setAge("10");
        f.setName("wzh");
        
        Son s = new Son(f);
        
        System.out.println(s.getName());
        
        System.out.println(s.getAge());
        
        System.out.println(s.getnAge());
        
        Father f1 = new Father();
        f1.setAge("11");
        
    }
}
