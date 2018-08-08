package cn.wangzh.demo;

class ThreadDemo1 extends Thread{
	private int ticket = 10;
	
	
	private String name;
	public ThreadDemo1(String name){
		this.name = name;
	}
	
	public void run(){
		 for(int i =0;i<500;i++){  
	            if(this.ticket>0){  
	                System.out.println(this.name+"卖票---->"+(this.ticket--));  
	            }  
	        }  
	}
}


public class ThreadDemo01 {

	public static void main(String[] args){
		ThreadDemo1 t1 = new ThreadDemo1("t1");
		ThreadDemo1 t2 = new ThreadDemo1("t2");
		ThreadDemo1 t3 = new ThreadDemo1("t3");
		t1.start();
		t2.start();
		t3.start();
	}
}
