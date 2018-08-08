package cn.wangzh.xml;

import cn.wangzh.xml.response.SecuritySignResponse;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.util.ArrayList;
import java.util.List;


public class SecuritySignTest
{
    public static void main(String[] args) {
        
        XStream xStream = new XStream(new DomDriver());
        xStream.alias("SecuritySignResponse", SecuritySignResponse.class);
        xStream.alias("person", Person.class);
        //xStream.aliasField("person", Person.class, "Person");
        
        // InputStream input = null;
        // try
        // {
        // input = new FileInputStream("SecuritySignTest.xml");
        // }
        // catch (FileNotFoundException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // InputStreamReader reader = null;
        // try
        // {
        // reader = new InputStreamReader(input, "utf-8");
        // }
        // catch (UnsupportedEncodingException e)
        // {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // SecuritySignResponse resp = (SecuritySignResponse)xStream.fromXML(reader);
        // //System.out.println(resp.toString());
        
        SecuritySignResponse resp = new SecuritySignResponse();
        List<Person> list = new ArrayList<Person>();
        Person person = new Person();
        person.setAge(12);
        person.setName("wang");
        list.add(person);
        resp.setPersons(list);
        
        String xml = xStream.toXML(resp);
        System.out.println("xml=" + xml);
    }
}
