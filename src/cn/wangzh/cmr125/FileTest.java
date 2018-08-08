package cn.wangzh.cmr125;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileTest
{
    public static void main(String[] args) throws Exception
    {
        for(int i=1; i <= 200; i++)
        {
            long starttime = System.currentTimeMillis();
            
            String path = "D:\\migu\\READ_ORDER_ALL_20170322_0.txt";
            
            if(i<10)
            {
                path = "D:\\migu\\READ_ORDER_ALL_20170322_000"+ i +".txt";
            }
            else if((i <100))
            {
                path = "D:\\migu\\READ_ORDER_ALL_20170322_00"+ i +".txt";
            }
            else
            {
                path = "D:\\migu\\READ_ORDER_ALL_20170322_0"+ i +".txt";
            }
            
            File sf = new File(path);
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
            @SuppressWarnings("resource")
            FileOutputStream out = new FileOutputStream(sf);
            
            for(int f=1; f<=500000; f++)
            {
                out.write("0001702281430037971171,13954121415,80030000000000000004,1619187,2017032111230,20170330112300,20170321112300,1".getBytes());
                out.write("\r\n".getBytes());
            }
            out.write("50,ALL,2017032111,500000".getBytes());
            if(out != null)
            {
                out.close();
            }
            long endtime = System.currentTimeMillis();
            System.out.println("success time[ "+ i + " ]=" + (endtime - starttime));
        }
        
    }
}
