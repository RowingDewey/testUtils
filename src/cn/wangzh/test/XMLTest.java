package cn.wangzh.test;

import java.io.File;
import java.io.IOException;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLTest {
	
	
	
	static void parseXML(){
		File file = new File("E:\\config.xml");
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.parse(file);
			Element root = document.getDocumentElement();
			
			NodeList nodelist = root.getChildNodes();
			
			System.out.println("root name: "+root.getNodeName());
			
			if(root!= null)
			{
				for(int i=0;i<nodelist.getLength();i++)
				{
					Node node = nodelist.item(i);
				
					NodeList childlist = node.getChildNodes();
					if(node!= null)
					{
						for(int j=0;j<childlist.getLength();j++)
						{
							Node childnode = childlist.item(j);
							if(childnode instanceof Element)
							{
								String name = childnode.getNodeName();
								String value = childnode.getTextContent();
								
								System.out.println(name+": "+value);
							}
							
						}
					}
					
				}
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public static void main(String[] args){
		
			XMLTest.parseXML();
	
	}
}
