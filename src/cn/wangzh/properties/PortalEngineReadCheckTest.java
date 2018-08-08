package cn.wangzh.properties;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class PortalEngineReadCheckTest
{
    private static HashMap<String, String> allinterFaceMap;
    
    private static HashMap<String, String> aserverinterFaceMap;
    
    
    public static void main(String[] args)
    {
        // properties();
        
        fileByReadLine();
        
        fileByReadLinePortalEngine();
        
        checkInterfaceMap();
        
    }
    
    
    
    /**
     * 
     * 以Properties形式加载
     *
     * @author wangzhuohui
     */
    public static void properties()
    {
        Properties prop = new Properties();
        InputStream in;
        try
        {
            in = new BufferedInputStream(new FileInputStream("portalengine-urls.properties"));
            
            prop.load(in);
            
            HashMap<String, String> interfaceCountMap = new HashMap<String, String>();
            
            Set<Object> keySet = prop.keySet();
            if (null != keySet)
            {
                System.out.println("keySet not null！！！");
                for (Object keys : keySet)
                {
                    String key = (String)keys;
                    if (key.startsWith("#"))
                    {
                        System.out.println("invalid interface=" + key);
                    }
                    else
                    {
                        if (null == interfaceCountMap.get(key))
                        {
                            interfaceCountMap.put((String)key, "1");
                        }
                        else
                        {
                            int a = Integer.valueOf(interfaceCountMap.get(key));
                            interfaceCountMap.put((String)key, String.valueOf(a + 1));
                        }
                    }
                }
            }
            
            //printlnMap(interfaceCountMap);
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 
     * 以file形式加载
     *
     * @author wangzhuohui
     */
    public static void fileByReadLine()
    {
        try
        {
            HashMap<String, String> interfaceCountMap = new HashMap<String, String>();
            int Count = 0;
            BufferedReader in = new BufferedReader(new FileReader("portalengine-urls.properties"));
            String line = null;
            while ((line = in.readLine()) != null)
            {
                if (line.startsWith("#"))
                {
                    System.out.println("invalid interface=" + line.split("=")[0]);
                }
                else
                {
                    String key = line.split("=")[0].trim();
                    if (null == interfaceCountMap.get(key))
                    {
                        interfaceCountMap.put((String)key, "1");
                        Count ++;
                    }
                    else
                    {
                        int a = Integer.valueOf(interfaceCountMap.get(key));
                        interfaceCountMap.put((String)key, String.valueOf(a + 1));
                    }
                }
            }
            
            if (null != in)
            {
                in.close();
            }
            
            printlnMap(interfaceCountMap);
            
            aserverinterFaceMap = interfaceCountMap;
            
            System.out.println("Count=" + Count);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 
     * 加载portalnegine方法
     *
     * @author wangzhuohui
     */
    public static void fileByReadLinePortalEngine()
    {
        try
        {
            HashMap<String, String> interfaceCountMap = new HashMap<String, String>();
            int Count = 0;
            BufferedReader in = new BufferedReader(new FileReader("portalEngine.properties"));
            String line = null;
            while ((line = in.readLine()) != null)
            {
                try
                {
                    if (line.startsWith("#"))
                    {
                        System.out.println("invalid interface=" + line.split("=")[0]);
                    }
                    else if (line.contains("sendPostRequest(\""))
                    {
                        int start = line.indexOf("sendPostRequest(\"");
                        int end = line.indexOf("\",");
                        
                        String key = line.substring(start + 17, end).trim();
                        
                        if (null == interfaceCountMap.get(key))
                        {
                            interfaceCountMap.put((String)key, "1");
                            Count++;
                        }
                        else
                        {
                            int a = Integer.valueOf(interfaceCountMap.get(key));
                            interfaceCountMap.put((String)key, String.valueOf(a + 1));
                        }
                    }
                }
                catch (Exception e)
                {
                    System.out.println("ERROR=" + line + "\n" + e);
                }
                
            }
            
            //printlnMap(interfaceCountMap);
            
            if (null != in)
            {
                in.close();
            }
            
            allinterFaceMap = interfaceCountMap;
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
                System.out.println("interface name=" + key + "; Count=" + interfaceMap.get(key) + "");
            }
            else
            {
                System.out.println("interface name=" + key + "; Count=" + interfaceMap.get(key));
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
                System.out.println("interface name=" + key + "; Count=" + allinterFaceMap.get(key));
                aServerCount ++;
                allCount ++;
            }
            else
            {
                //System.out.println("interface name=" + key + "; Count=" + allinterFaceMap.get(key));
                iServerCount ++;
                allCount ++;
            }
        }
        
        System.out.println("aServerCount=" + aServerCount);
        System.out.println("iServerCount=" + iServerCount);
        System.out.println("Count=" + allCount);
    }
}
