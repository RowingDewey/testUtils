package cn.wangzh.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangzhuohui
 * @version V1.0
 * @description jdk高并发测试
 * @since 2018-08-08 14:50
 */
public class ConcurrentTest2
{
    private Lock lock = new ReentrantLock();
    
    public static void main(String[] args) {
        ConcurrentTest2 test = new ConcurrentTest2();
        MyThread thread1 = new MyThread(test);
        MyThread thread2 = new MyThread(test);
        thread1.start();
        thread2.start();
        
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        thread2.interrupt();
    }
    
    public void insert(Thread thread)
        throws InterruptedException {
        lock.lockInterruptibly();   //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        try
        {
            System.out.println(thread.getName() + "得到了锁");
            long startTime = System.currentTimeMillis();
            for (; ; )
            {
                if (System.currentTimeMillis() - startTime >= 2000)
                    break;
                //插入数据
            }
        }
        finally
        {
            System.out.println(Thread.currentThread().getName() + "执行finally");
            lock.unlock();
            System.out.println(thread.getName() + "释放了锁");
        }
    }
}

class MyThread extends Thread
{
    private ConcurrentTest2 test = null;
    
    public MyThread(ConcurrentTest2 test) {
        this.test = test;
    }
    
    @Override
    public void run() {
        
        try
        {
            test.insert(Thread.currentThread());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
            System.out.println(Thread.currentThread().getName() + "被中断");
        }
    }
}
