package cn.wangzh.demo;

class C{
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
	
}
public class demo05 {
	public static void main(String[] args){
		C c = new C();
		c.setName("123");
		String n = c.getName();
		String s = c.getAge();
		System.out.println("n="+n+"   "+"s="+s);
	}

}
