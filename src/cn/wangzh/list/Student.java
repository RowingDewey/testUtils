package cn.wangzh.list;

/**
 * @author wangzhuohui
 * @version V1.0
 * @description 实体test
 * @since 2018-09-04 12:28
 */
public class Student
{
    private String id;
    
    private String name;
    
    Student()
    {
        
    }
    
    Student(String id, String name)
    {
        this.id = id;
        this.name = name;
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
