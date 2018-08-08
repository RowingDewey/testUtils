package cn.wangzh.test;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLWriter {
	
	public static void getFamilyMemebers() {
		File f = new File("TheadTest.xml");
		// 首先我们需要通过DocumentBuilderFactory获取xml文件的工厂实例。
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);// 是否去掉空格 false true
		try {
			// 创建文档对象
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("e:\\config.xml")); // 使用dom解析xml

			// 遍历列表，数据读取

			NodeList sonlist = doc.getElementsByTagName("config");
			for (int i = 0; i < sonlist.getLength(); i++) {
				Element son = (Element) sonlist.item(i);

				for (Node node = son.getFirstChild(); node != null; node = node
						.getNextSibling()) {
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						String name = node.getNodeName();
						String value = node.getFirstChild().getNodeValue();
						System.out.println(name + ": " + value);
					}
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createNote() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(false);

		try {

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmldoc = db.parse("TheadTest.xml");

			Element root = xmldoc.getDocumentElement();

			Element note = xmldoc.createElement("Account");
			note.setAttribute("id", "004");

			Element code = xmldoc.createElement("code");
			code.setTextContent("00001");
			note.appendChild(code);

			Element pass = xmldoc.createElement("pass");
			pass.setTextContent("000");
			note.appendChild(pass);

			Element name = xmldoc.createElement("name");
			name.setTextContent("zhongbaohui");
			note.appendChild(name);

			Element money = xmldoc.createElement("money");
			money.setTextContent("0001000");
			note.appendChild(money);

			root.appendChild(note);
			// 保存
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer former = factory.newTransformer();
			former.transform(new DOMSource(xmldoc), new StreamResult(new File(
					"TheadTest.xml")));
			System.out.println("success");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 获取目标节点
	public static Node selectSingleNode(String express, Element source) {
		Node result = null;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		try {
			result = (Node) xpath.evaluate(express, source, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return result;
	}

	// 修改节点
	public static void modifySon() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);
		try {

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmldoc = db.parse("TheadTest.xml");

			Element root = xmldoc.getDocumentElement();

			Element per = (Element) selectSingleNode("/Accounts/Account[@id='004']",root);
			per.getElementsByTagName("code").item(0).setTextContent("10000");

			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer former = factory.newTransformer();
			former.transform(new DOMSource(xmldoc), new StreamResult(new File("TheadTest.xml")));
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 删除节点
	public static void delNode() {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringElementContentWhitespace(true);

		try {

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document xmldoc = db.parse("TheadTest.xml");

			Element root = xmldoc.getDocumentElement();

			Element node = (Element) selectSingleNode("/Accounts/Account[@type='003']",root);
			root.removeChild(node);

			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer former = factory.newTransformer();
			former.transform(new DOMSource(xmldoc), new StreamResult(new File("TheadTest.xml")));
			System.out.println("success");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		 XMLWriter.createNote();
		   XMLWriter.getFamilyMemebers();
//		XMLWriter.delNode();
//		XMLWriter.modifySon();

	}

}
