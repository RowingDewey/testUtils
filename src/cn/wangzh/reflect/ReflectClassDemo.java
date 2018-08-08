package cn.wangzh.reflect;

/**
 * @author wangzhuohui
 * @create 2018-05-31 13:21
 * @desc
 */
public class ReflectClassDemo
{
    public String name;

    private String id;

    private boolean isGroup;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public boolean isGroup()
    {
        return isGroup;
    }

    public void setGroup(boolean group)
    {
        isGroup = group;
    }
}
