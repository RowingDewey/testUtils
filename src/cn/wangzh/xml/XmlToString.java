package cn.wangzh.xml;

import cn.wangzh.xml.response.Account;
import cn.wangzh.xml.response.Accounts;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class XmlToString
{
    
    public static void main(String[] args) {
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("Accounts", Accounts.class);
        xStream.alias("Account", Account.class);
        
        InputStream input = null;
        try
        {
            input = new FileInputStream("TheadTest.xml");
        }
        catch (FileNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        InputStreamReader reader = null;
        try
        {
            reader = new InputStreamReader(input, "utf-8");
        }
        catch (UnsupportedEncodingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        Accounts o = (Accounts)xStream.fromXML(reader);
        
        System.out.println(o.toString());
    }
    
}
