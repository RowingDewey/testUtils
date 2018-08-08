package cn.wangzh.simple;

public class SingletonClass { 

	  private static final SingletonClass instance = new SingletonClass(); 
	    
	  public static SingletonClass getInstance() { 
	    return instance; 
	  } 
	   
	  private String name;
	  
	  public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private SingletonClass() { 
	  } 
	    
	}
