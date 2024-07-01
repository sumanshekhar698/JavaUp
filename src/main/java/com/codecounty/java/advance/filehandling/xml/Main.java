package com.codecounty.java.advance.filehandling.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws Exception {
		// Want to read all book names from XML
		ArrayList<String> bookNames = new ArrayList<String>();

		// Parse XML file
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new FileInputStream(new File("src/main/resources/people_namespace2.xml")));
		
		doc.getDocumentElement().normalize();
		
//		NodeList elementsByTagName = doc.getElementsByTagName("Cnote");
//		NodeList elementsByTagName2 = doc.getElementsByTagName("MsgCount");
//		NodeList elementsByTagNameNS = doc.getElementsByTagNameNS("http://www.example.net/ns/doc/entry","doc:msg");

//		elementsByTagName.item(0);
//		System.out.println("->"+elementsByTagNameNS.item(0));

//		updateElementValue(doc);
		// Get XPath expression
		XPathFactory xpathfactory = XPathFactory.newInstance();
		XPath xpath = xpathfactory.newXPath();

		NamespaceResolver namespaceResolver = new NamespaceResolver(doc);
		String namespaceURI = namespaceResolver.getNamespaceURI("doc");
		System.out.println(namespaceURI);

		xpath.setNamespaceContext(namespaceResolver);

		XPathExpression expr = xpath
				.compile("//cps:Cnote/cps:Payload/cps:pings/doc:record/doc:address/doc:head/doc:msg/text()");

//		myNodeList.item(0).setNodeValue("Hi mom!");

		// Search XPath expression
		Object result = expr.evaluate(doc, XPathConstants.NODESET);

		// Iterate over results and fetch book names
		NodeList nodes = (NodeList) result;
		for (int i = 0; i < nodes.getLength(); i++) {
			bookNames.add(nodes.item(i).getNodeValue());
		}

//		 Verify book names
		System.out.println(bookNames);
		
		String documentToXmlString = DocumentToXmlString(doc);
		System.out.println("-->" + expr.toString());
//		String updateXML = updateXML(documentToXmlString, expr.toString(), "new value");
//		System.out.println(updateXML);

	}

	/**
	 * Update firstName element value to Upper case.
	 * 
	 * @param doc
	 */
	private static void updateElementValue(Document doc) {
		NodeList users = doc.getElementsByTagName("msg");
		Element user = null;
		// loop for each user
		for (int i = 0; i < users.getLength(); i++) {
			user = (Element) users.item(i);
			Node name = user.getElementsByTagName("firstName").item(0).getFirstChild();
			name.setNodeValue(name.getNodeValue().toUpperCase());
		}
	}

	private static String DocumentToXmlString(Document xmlDocument) {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer;
		String xmlString = "";
		try {
			transformer = tf.newTransformer();

			// Uncomment if you do not require XML declaration
			// transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");

			// A character stream that collects its output in a string buffer,
			// which can then be used to construct a string.
			StringWriter writer = new StringWriter();

			// transform document to string
			transformer.transform(new DOMSource(xmlDocument), new StreamResult(writer));

			xmlString = writer.getBuffer().toString();
			System.out.println(xmlString); // Print to console or logs

		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlString;
	}

	public static String updateXML(String xml, String xpathExpression, String newValue) {
		try {
			// Creating document builder
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();
			Document document = builder.parse(new org.xml.sax.InputSource(new StringReader(xml)));

			// Evaluating xpath expression using Element
			XPath xpath = XPathFactory.newInstance().newXPath();
			Element element = (Element) xpath.evaluate(xpathExpression, document, XPathConstants.NODE);

			// Setting value in the text
			element.setTextContent(newValue);

			// Transformation of document to xml
			StringWriter stringWriter = new StringWriter();
			Transformer xformer = TransformerFactory.newInstance().newTransformer();
			xformer.transform(new DOMSource(document), new StreamResult(stringWriter));

			xml = stringWriter.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xml;
	}

}

class NamespaceResolver implements NamespaceContext {

	private Document sourceDocument;

	// Store the source document to search the namespaces
	public NamespaceResolver(Document document) {
		sourceDocument = document;
	}

	// The lookup for the namespace uris is delegated to the stored document.
	public String getNamespaceURI(String prefix) {
		switch (prefix) {
		case "cps": {
			return "http://www.example.net/ns/cps/entry";
		}
		case "doc": {
			return "http://www.example.net/ns/doc/entry";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + prefix);
		}
	}
//	the lookup for the namespace uris is delegated to the stored document.
//    public String getNamespaceURI(String prefix) {
//        if (prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
//            return sourceDocument.lookupNamespaceURI(null);
//        } else {
//            return sourceDocument.lookupNamespaceURI(prefix);
//        }
//    }

	public String getPrefix(String namespaceURI) {
		return sourceDocument.lookupPrefix(namespaceURI);
	}

	@SuppressWarnings("rawtypes")
	public Iterator getPrefixes(String namespaceURI) {
		return null;
	}

	/**
	 * Add a new element salary to user element.
	 * 
	 * @param doc
	 */
	private static void addElement(Document doc) {
		NodeList users = doc.getElementsByTagName("User");
		Element emp = null;

		// loop for each user
		for (int i = 0; i < users.getLength(); i++) {
			emp = (Element) users.item(i);
			Element salaryElement = doc.createElement("salary");
			salaryElement.appendChild(doc.createTextNode("10000"));
			emp.appendChild(salaryElement);
		}
	}

	/**
	 * Delete gender element from User element
	 * 
	 * @param doc
	 */
	private static void deleteElement(Document doc) {
		NodeList users = doc.getElementsByTagName("User");
		Element user = null;
		// loop for each user
		for (int i = 0; i < users.getLength(); i++) {
			user = (Element) users.item(i);
			Node genderNode = user.getElementsByTagName("gender").item(0);
			user.removeChild(genderNode);
		}

	}

}