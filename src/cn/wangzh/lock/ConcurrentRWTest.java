package cn.wangzh.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangzhuohui
 * @version V1.0
 * @description 读写锁测试
 * @since 2018-08-08 15:21
 */
public class ConcurrentRWTest
{
    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    
    public static void main(String[] args) {
        final ConcurrentRWTest test = new ConcurrentRWTest();
        
        new Thread()
        {
            public void run() {
                test.get(Thread.currentThread());
            }
            
            ;
        }.start();
        
        new Thread()
        {
            public void run() {
                test.get(Thread.currentThread());
            }
            
            ;
        }.start();
        
    }
    
    public void get(Thread thread) {
        rwl.readLock().lock();
        try
        {
            long start = System.currentTimeMillis();
            
            while (System.currentTimeMillis() - start <= 1)
            {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        }
        finally
        {
            rwl.readLock().unlock();
        }
    }
    
}
