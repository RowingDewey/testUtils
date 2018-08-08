package cn.wangzh.migudatarepair;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class MiguMainOld
{
    public static void main(String[] args)
        throws IOException
    {
        String savepath = "D://11/error.txt";
        File sf = new File(savepath);
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
        
        FileOutputStream out = new FileOutputStream(sf);
        
        String str = null;
        
        try
        {
            print(str);
        }
        catch(Exception e)
        {
          //String erroMSG = getErrorInfoFromException(e1);
            //System.out.println(tempList[i].getName() + "-->" + lineTxt + "; erroMSG=" + erroMSG);
            e.printStackTrace();
            out.write(e.toString().getBytes());
        }
        
        out.close();
    }
    
    public static void print(String str) throws Exception
    {
        str.equals("12");
    }
    
    public static String getErrorInfoFromException(Exception e)
    {
        try
        {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return "\r\n" + sw.toString() + "\r\n";
        }
        catch (Exception e2)
        {
            return "bad getErrorInfoFromException";
        }
    }
    
}
