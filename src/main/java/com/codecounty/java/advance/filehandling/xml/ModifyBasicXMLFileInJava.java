package com.codecounty.java.advance.filehandling.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class ModifyBasicXMLFileInJava {
	public static void main(String[] args) {
		String filePath = "src/main/resources/users.xml";
		File xmlFile = new File(filePath);
		System.out.println("PATH --> " + xmlFile.toString());
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();

			// parse xml file and load into document
			Document doc = dBuilder.parse(xmlFile);

			// Optional but recommended
			doc.getDocumentElement().normalize();
			System.out.println(doc);

			// update Element value
			updateElementValue(doc);

			// delete element
			deleteElement(doc);

			// add new element
			addElement(doc);

			// write the updated document to file or console
			writeXMLFile(doc);
			DocumentToXmlString(doc);
			System.out.println("******************************BREAK----------------------------");
			String forcedConvesion = xmlFileToStringForcefully("src/main/resources/users_updated.xml");
			System.out.println(forcedConvesion);
			Document outputRendered=stringToXMLDoc(forcedConvesion);
			System.out.println("-----**-*-*-*-*-*--*-*-*-*--*-*-*-*-*-*-*-*--**-*-*-*-*-*");
			System.out.println(DocumentToXmlString(outputRendered));

		} catch (SAXException | ParserConfigurationException | IOException | TransformerException e1) {
			e1.printStackTrace();
		}
	}

	private static Document stringToXMLDoc(String forcedConvesion) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setNamespaceAware(true);
		DocumentBuilder newDocumentBuilder = dbFactory.newDocumentBuilder();
		Document parse = newDocumentBuilder.parse(new InputSource(new StringReader(forcedConvesion)));
		
		return parse;
	}

	private static String xmlFileToStringForcefully(String path) throws IOException {

		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				stringBuilder.append(line);
			}
		}
		return stringBuilder.toString();

	}

	private static void writeXMLFile(Document doc)
			throws TransformerFactoryConfigurationError, TransformerConfigurationException, TransformerException {
		doc.getDocumentElement().normalize();
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);

		StreamResult result = new StreamResult(new File("src/main/resources/users_updated.xml"));
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);
		System.out.println("XML file updated successfully");
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

	/**
	 * Update firstName element value to Upper case.
	 * 
	 * @param doc
	 */
	private static void updateElementValue(Document doc) {
		NodeList users = doc.getElementsByTagName("User");
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
}