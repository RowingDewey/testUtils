package cn.wangzh.proxy;

/**
 * @author wangzhuohui
 * @version V1.0
 * @description 真实对象
 * @since 2018-09-21 15:24
 */
public class RealSubject implements Subject
{
    @Override
    public void rent()
    {
        System.out.println("I want to rent my house");
    }
    
    @Override
    public void hello(String str)
    {
        System.out.println("Hello: " + str);
    }
}
