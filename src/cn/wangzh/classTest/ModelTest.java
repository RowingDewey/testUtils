package cn.wangzh.classTest;

public class ModelTest
{
    
    private String name;
    
    private String age;
    
    private Object object;
    
    private int sex;
    
    public int getSex()
    {
        return sex;
    }
    
    public void setSex(int sex)
    {
        this.sex = sex;
    }
    
    public Object getObject()
    {
        return object;
    }
    
    public void setObject(Object object)
    {
        this.object = object;
    }
    
    ModelTest()
    {
    }
    
    ModelTest(String name, String age)
    {
        this.name = name;
        this.age = age;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getAge()
    {
        return age;
    }
    
    public void setAge(String age)
    {
        this.age = age;
    }
    
    @Override
    public String toString()
    {
        return "ModelTest [name=" + name + ", age=" + age + ", object=" + object + ", sex=" + sex + "]";
    }
}
