package cn.wangzh.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest
{
    public static void main(String[] args)
    {
        ThreadPoolExecutor threadPool =
            new ThreadPoolExecutor(2, 4, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(8));
        
        for (int i = 0; i < 20; i++)
        {
            MyTask myTask = new MyTask("Task" + i);
            threadPool.execute(myTask);
            
            System.out.println("线程池中线程数目=" + threadPool.getPoolSize() + ", 队列中等待执行的任务数目=" + threadPool.getQueue().size()
                + ", 已执行玩别的任务数目=" + threadPool.getCompletedTaskCount());
        }
        threadPool.shutdown();
    }
}

class MyTask implements Runnable
{
    private String taskNum;
    
    public MyTask(String num)
    {
        this.taskNum = num;
    }
    
    @Override
    public void run()
    {
        System.out.println("正在执行task=" + taskNum);
        try
        {
            Thread.sleep(4000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("执行task=" + taskNum + "执行完毕");
    }
}