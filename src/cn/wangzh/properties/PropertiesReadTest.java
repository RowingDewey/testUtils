package cn.wangzh.properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReadTest
{
    
    public static void main(String[] args)
    {
        String name = null;
        String age = null;
        String address = null;
        
        Properties prop = new Properties();
        InputStream in;
        try
        {
            in = new BufferedInputStream(new FileInputStream("TheadTest.properties"));
            
            prop.load(in);
            name = prop.getProperty("name");
            age = prop.getProperty("age");
            address = prop.getProperty("address");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        System.out.println("name= " + name);
        System.out.println("age= " + age);
        System.out.println("address= " + address);
    }
}
