package cn.wangzh.cmr120;


class Parent
{
    public Parent()
    {
        System.out.println("this is parent name= parent");
    }
    
    public Parent(String name)
    {
        System.out.println("this is parent name=" + name);
    }
}

class Child extends Parent
{

    public Child()
    {
        System.out.println("this is child name=child");
    }
    
}

public class test001
{
    public static void main(String[] args)
    {
        Child child = new Child();
        
    }
    
}
