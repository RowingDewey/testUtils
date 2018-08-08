package cn.wangzh.getInstance;

//懒汉式单例类.在第一次调用的时候实例化自己   
public class Singleton { 
	private String name;
	
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Singleton() {}  
    private static Singleton single=null;  
    //静态工厂方法   
    public static Singleton getInstance() {  
         if (single == null) {    
             single = new Singleton();  
         }    
        return single;  
    }
	@Override
	public String toString() {
		return "Singleton [name=" + name + "]";
	}  
    
    
}  