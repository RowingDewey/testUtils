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

public class XMLTest1 {
	
	
	
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
			System.out.println();
			
			if(root!= null)
			{
				for(int i=0;i<nodelist.getLength();i++)
				{
					Node node = nodelist.item(i);
					if(node.getNodeName().equals("#text") || node.getNodeName().equals("#comment"))
					{
						
					}else
					{
						 System.out.println("node name: "+node.getNodeName());
					}
				   
					
				}
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public static void main(String[] args){
		
			XMLTest1.parseXML();
	
	}
}
