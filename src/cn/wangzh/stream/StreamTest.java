package cn.wangzh.stream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StreamTest
{
    
    public void test(HttpServletRequest request) {
        try
        {
            InputStream io = request.getInputStream();
            
            //读取输入流
            SAXReader reader = new SAXReader();
            Document document = reader.read(io);
            
            //得到xml根元素
            Element root = document.getRootElement();
            //得到根元素的所有子节点
            List<Element> elements = root.elements();
            
            for (Element e : elements)
            {
                System.out.println("Element name=" + e.getName() + "; Element text=" + e.getText());
                
            }
            
            //释放资源
            io.close();
            io = null;
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (DocumentException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
