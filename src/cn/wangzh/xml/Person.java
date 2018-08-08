package cn.wangzh.xml;

import java.util.Map;

public class Person
{
    
    private int idCard;
    
    private String name;
    
    private int age;
    
    private Map<String, String> attMap;
    
    public Person()
    {
    }
    
    public Person(int idCard, String name, int age)
    {
        super();
        this.idCard = idCard;
        this.name = name;
        this.age = age;
    }
    
    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    
    public Person(int idCard, int age)
    {
        this.idCard = idCard;
        this.age = age;
    }
    
    public int getIdCard()
    {
        return idCard;
    }
    
    public void setIdCard(int idCard)
    {
        this.idCard = idCard;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getAge()
    {
        return age;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }

    public Map<String, String> getAttMap()
    {
        return attMap;
    }

    public void setAttMap(Map<String, String> attMap)
    {
        this.attMap = attMap;
    }
    
    /*
     * @Override public String toString() { return "person{" + "idCard='" + idCard + '\'' + ", name='" + name + '\'' +
     * ", age='" + age + '\'' + "}\n" ; }
     */
}
