package cn.wangzh.test;

public class test6 {
	public static void main(String[] args) {
          AA aa = getAa();
          if(aa != null)
          {
        	  System.out.println("aa not null");
          }
          else
          {
        	  System.out.println("aa is null");
          }
          
	}
	
	public static AA getAa()
	{
		return new AA();
	}
}

class AA{
	
	private String name;
	private String age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "AA [age=" + age + ", name=" + name + "]";
	}
	
}