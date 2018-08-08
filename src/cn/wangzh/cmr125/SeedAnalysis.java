package cn.wangzh.cmr125;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SeedAnalysis
{
    public static void main(String[] args)
    {
        File file = new File("D://seed");
        
        File[] tempList = file.listFiles();
        System.out.println("该目录下文件个数=" + tempList.length);
        
        // 分析后文件
        File sf = new File("D://seed1/seedanalysis.txt");
        if (!sf.exists())
        {
            try
            {
                sf.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        FileOutputStream out = null;
        try
        {
            out = new FileOutputStream(sf);
        }
        catch (FileNotFoundException e1)
        {
            e1.printStackTrace();
        }
        
        if (out == null)
        {
            return;
        }
        int allnum = 0;
        Map<String, Object> mobileMap = new HashMap<String, Object>();
        for (int i = 0; i < tempList.length; i++)
        {
            
            if (tempList[i].isFile())
            {
                InputStreamReader read = null;
                try
                {
                    read = new InputStreamReader(new FileInputStream(tempList[i]), "GB2312");
                }
                catch (UnsupportedEncodingException e1)
                {
                    e1.printStackTrace();
                }
                catch (FileNotFoundException e1)
                {
                    e1.printStackTrace();
                } // 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                try
                {
                    while ((lineTxt = bufferedReader.readLine()) != null)
                    {
                        if (lineTxt != null && !"".equals(lineTxt.trim()))
                        {
                            String[] line = lineTxt.split("\\|");
                            String[] line2 = line[4].split(",");
                            if (line2[4].split("=").length == 2)
                            {
                                String mobile = line2[4].split("=")[1];
                                if (mobileMap.get(mobile) != null)
                                {
                                    allnum ++;
                                    int num = (Integer)mobileMap.get(mobile);
                                    mobileMap.put(mobile, num + 1);
                                }
                                else
                                {
                                    allnum ++;
                                    mobileMap.put(mobile, 1);
                                }
                            }
                        }
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        
        Iterator<String> it = mobileMap.keySet().iterator();
        while (it.hasNext())
        {
            String key;
            key = (String)it.next();
            int num = (Integer)mobileMap.get(key);
            String print = "identityId=" + key + ", num=" + num;
            try
            {
                out.write(print.getBytes());
                out.write("\r\n".getBytes());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        try
        {
            out.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("over!!! allnum=" + allnum);
    }
}
