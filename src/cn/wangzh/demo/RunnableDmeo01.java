package cn.wangzh.demo;

class RunnableDemo1 implements Runnable{
	private int ticket = 10;
	
	private String name;
//	public RunnableDemo1(String name){
//		this.name = name;
//	}

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		for(int i =0;i<500;i++){  
            if(this.ticket>0){  
                System.out.println(Thread.currentThread().getName()+"卖票---->"+(this.ticket--));  
            }  
        }  
	}
	
}
public class RunnableDmeo01 {

	public static void main(String[] args){
		RunnableDemo1 r = new RunnableDemo1();
		Thread r1 = new Thread(r,"r1");
		Thread r2 = new Thread(r,"r2");
		Thread r3 = new Thread(r,"r3");
		r1.start();
		r2.start();
		r3.start();
		
	}
	
	
}
