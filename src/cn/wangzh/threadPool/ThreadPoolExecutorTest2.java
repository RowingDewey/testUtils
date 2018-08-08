package cn.wangzh.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest2
{
    public static void main(String[] args)
    {
        ThreadPoolExecutor threadPool =
            new ThreadPoolExecutor(2, 4, 200, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        System.out.println("Before allowCoreThreadTimeOut flag=" + threadPool.allowsCoreThreadTimeOut());
        threadPool.allowCoreThreadTimeOut(true);
        System.out.println("After allowCoreThreadTimeOut flag=" + threadPool.allowsCoreThreadTimeOut());
        for (int i = 0; i < 12; i++)
        {
            MyTask2 myTask = new MyTask2("Task" + i);
            threadPool.execute(myTask);
            
            System.out.println("线程池中线程数目=" + threadPool.getPoolSize() + ", 队列中等待执行的任务数目=" + threadPool.getQueue().size()
                + ", 已执行玩别的任务数目=" + threadPool.getCompletedTaskCount());
            try
            {
                Thread.sleep(400);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        try
        {
            Thread.sleep(4000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("1结束线程池中线程数目=" + threadPool.getPoolSize() + ", 1结束队列中等待执行的任务数目=" + threadPool.getQueue().size()
            + ", 1结束已执行玩别的任务数目=" + threadPool.getCompletedTaskCount());
        
        for (int i = 0; i < 12; i++)
        {
            MyTask2 myTask = new MyTask2("Task" + i);
            threadPool.execute(myTask);
            
            System.out.println("线程池中线程数目=" + threadPool.getPoolSize() + ", 队列中等待执行的任务数目=" + threadPool.getQueue().size()
                + ", 已执行玩别的任务数目=" + threadPool.getCompletedTaskCount());
            try
            {
                Thread.sleep(400);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("结束线程池中线程数目=" + threadPool.getPoolSize() + ", 结束队列中等待执行的任务数目=" + threadPool.getQueue().size()
            + ", 结束已执行玩别的任务数目=" + threadPool.getCompletedTaskCount());
        threadPool.shutdown();
    }
}

class MyTask2 implements Runnable
{
    private String taskNum;
    
    public MyTask2(String num)
    {
        this.taskNum = num;
    }
    
    @Override
    public void run()
    {
        System.out.println("正在执行task=" + taskNum);
        try
        {
            Thread.sleep(400);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("执行task=" + taskNum + "执行完毕");
    }
}