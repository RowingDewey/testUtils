package cn.wangzh.threadPool;

import cn.wangzh.migudatarepair.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadTest
{
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool =
            new ThreadPoolExecutor(20, 50, 200, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        
        for (int i = 0; i < 100000; i++)
        {
            ThreadTask myTask = new ThreadTask();
            threadPool.execute(myTask);
        }
    }
}

class ThreadTask implements Runnable
{
    @Override
    public void run() {
        Map<String, String> cx = new HashMap<String, String>();
        cx.put("Accept-Encoding", "identity");
        cx.put("User-Agent", "Dalvik/2.1.0 (Linux; U; Android 7.0; HUAWEI NXT-AL10 Build/HUAWEINXT-AL10)");
        cx.put("Connection", "Keep-Alive");
        
        String url =
            "http://qznn.kddmc.com/App/NewPublicAPI.ashx?base=eyJ2ZXIiOiIxLjUuMSIsImFjdGlvbiI6IlJvb21JbmZvIiwicGFyYW0iOnsiUm9vbUtleSI6NjkwMDYxLCJ1aWQiOjk4MTc0LCJza2V5IjoiNTAyZmNhNzdmOWNhYzBhM2UzZWQxYWUyMWQ2YjgyMmMifX0%3D";
        
        try
        {
            long startTime = System.currentTimeMillis();
            String result = HttpClientUtil.post(url, "", "utf-8", cx);
            long endTime = System.currentTimeMillis();
            if ((endTime - startTime) > 5)
            {
                System.out.println((endTime - startTime) + ", result=" + result);
            }
        }
        catch (Exception e)
        {
            System.out.println("System error");
        }
    }
}
