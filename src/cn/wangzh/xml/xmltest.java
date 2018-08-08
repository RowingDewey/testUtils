package cn.wangzh.xml;

import cn.wangzh.json.ResponseModel;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import net.sf.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class xmltest
{
    public static void main(String[] args) {
        
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("charge_result", ResponseModel.class);
        
        InputStream input = null;
        try
        {
            input = new FileInputStream("xmltest.xml");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        InputStreamReader reader = null;
        try
        {
            reader = new InputStreamReader(input, "utf-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        ResponseModel resp = (ResponseModel)xStream.fromXML(reader);
        System.out.println("ResponseModel =" + resp.toString());
        
        // 转为json对象
        JSONObject json = JSONObject.fromObject(resp.getReturnExt());
        System.out.println("json =" + json.toString());
    }
}
