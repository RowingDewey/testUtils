package cn.wangzh.bean;

public class Son extends Father
{
    public String name;
    
    public String age;
    
    public String getAge()
    {
        return age;
    }
    
    public void setAge(String age)
    {
        this.age = age;
    }
    
    public String nAge;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getnAge()
    {
        return nAge;
    }
    
    public void setnAge(String nAge)
    {
        this.nAge = nAge;
    }
    
    @Override
    public String toString()
    {
        return "Son [name=" + name + ", age=" + age + ", nAge=" + nAge + "]";
    }
    
    Son(Father f)
    {
        this.age = f.getAge();
    }
    
    Son()
    {
    }
}
