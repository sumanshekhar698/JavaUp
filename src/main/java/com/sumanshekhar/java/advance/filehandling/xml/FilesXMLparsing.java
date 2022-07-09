package com.sumanshekhar.java.advance.filehandling.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class FilesXMLparsing {

	public void display(String path) {
		DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder newDocumentBuilder = newInstance.newDocumentBuilder();
			Document document = newDocumentBuilder.parse(path);
			XPath newXPath = XPathFactory.newInstance().newXPath();
			String evaluate = newXPath.compile("/erpiRoot/fileName").evaluate(document);
			System.out.println(evaluate+" | len --> "+evaluate.length());
		} catch (ParserConfigurationException | SAXException | IOException | XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
