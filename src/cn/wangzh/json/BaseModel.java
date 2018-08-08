package cn.wangzh.json;

public class BaseModel
{
    private String name;
    
    private String age;
    
    private String password;
    
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
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    @Override
    public String toString()
    {
        return "BaseModel [name=" + name + ", age=" + age + ", password=" + password + "]";
    }
}
