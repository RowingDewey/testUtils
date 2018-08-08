package cn.wangzh.reflect;

/**
 * @author wangzhuohui
 * @since 2018-06-09 11:57
 * @Description 反射调用获取实际异常
 */
public class ReflectException
{
    public static void main(String[] args)
    {
        System.out.println("2018/06/09".replaceAll("/", "-"));
        try
        {
            Class<?> cl = Class.forName("cn.wangzh.reflect.ReflectTest");
            ReflectTest reflectTest = (ReflectTest)cl.newInstance();
            reflectTest.getNullException();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
    }
}

/**
 * 反射测试内部类
 * @author wangzhuohui
 * @since 2018/6/9 15:43
 *
 */
class ReflectTest
{
    private String userName;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void getNullException()
    {
        System.out.println("hello 1");
        userName.toString();
    }

    @Override
    public String toString()
    {
        final StringBuffer sb = new StringBuffer("ReflectTest{");
        sb.append("userName='").append(userName);
        sb.append('}');
        return sb.toString();
    }
}
