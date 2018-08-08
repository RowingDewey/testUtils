package cn.wangzh.test;

public class test extends A
{
    //int i = -6;
    
    public static void main(String[] args)
    {
        A xx = new test();
        System.out.println(xx.getI());
    }
    
    public int getI()
    {
        System.out.println("333333");
        return i;
    }
    
    public void setI(int i)
    {
        System.out.println("444444");
        this.i = i;
    }
    
}

class A
{
    int i = 12;
    
    public int getI()
    {
        System.out.println("1111111");
        return i;
    }
    
    public void setI(int i)
    {
        System.out.println("2222222");
        this.i = i;
    }
}
