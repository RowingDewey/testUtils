package cn.wangzh.properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class CheckTest
{
    
    private static HashMap<String, String> allinterFaceMap = new HashMap<String, String>();
    
    private static HashMap<String, String> aserverinterFaceMap = new HashMap<String, String>();
    
    public static void main(String[] args)
    {
        fileByReadLine("2.txt", aserverinterFaceMap);
        fileByReadLine("3.txt", allinterFaceMap);
        checkInterfaceMap();
        
        
    }
    
    
    /**
     * 
     * 以file形式加载
     *
     * @author wangzhuohui
     */
    public static void fileByReadLine(String path, HashMap<String, String> map)
    {
        try
        {
            HashMap<String, String> interfaceCountMap = new HashMap<String, String>();
            int Count = 0;
            BufferedReader in = new BufferedReader(new FileReader(path));
            String line = null;
            while ((line = in.readLine()) != null)
            {
                if (line.startsWith("#"))
                {
                    System.out.println("invalid interface=" + line.split("=")[0]);
                }
                else
                {
                    String key = line.split("=")[1].trim();
                    if (null == interfaceCountMap.get(key))
                    {
                        interfaceCountMap.put((String)key, "1");
                        map.put((String)key, "1");
                        Count ++;
                    }
                    else
                    {
                        int a = Integer.valueOf(interfaceCountMap.get(key));
                        interfaceCountMap.put((String)key, String.valueOf(a + 1));
                        map.put((String)key, String.valueOf(a + 1));
                    }
                }
            }
            
            if (null != in)
            {
                in.close();
            }
            
            printlnMap(interfaceCountMap);
            
            System.out.println("Count=" + Count);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * 打印map
     *
     * @author wangzhuohui
     * @param interfaceMap
     */
    private static void printlnMap(HashMap<String, String> interfaceMap)
    {
        for (String key : interfaceMap.keySet())
        {
            String count = interfaceMap.get(key);
            if (Integer.valueOf(count) > 1)
            {
                System.out.println("interface name=" + key);
            }
            else
            {
                System.out.println("interface name=" + key);
            }
        }
    }
    
    /**
     * 
     * 对比接口调用
     *
     * @author wangzhuohui
     */
    private static void checkInterfaceMap()
    {
        int allCount = 0;
        int iServerCount = 0;
        int aServerCount = 0;
        
        for(String key : allinterFaceMap.keySet())
        {
            if(null != aserverinterFaceMap.get(key))
            {
                //System.out.println("interface name=" + key + "; Count=" + allinterFaceMap.get(key));
                aServerCount ++;
                allCount ++;
            }
            else
            {
                System.out.println("interface name=" + key + "; Count=" + allinterFaceMap.get(key));
                iServerCount ++;
                allCount ++;
            }
        }
        
        System.out.println("aServerCount=" + aServerCount);
        System.out.println("iServerCount=" + iServerCount);
        System.out.println("Count=" + allCount);
    }
}
