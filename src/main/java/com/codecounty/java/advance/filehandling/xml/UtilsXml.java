package com.codecounty.java.advance.filehandling.xml;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

public class UtilsXml {

	// method to convert Document to String
	static public String getStringFromDocument(Document doc) {
		try {
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			return writer.toString();
		} catch (TransformerException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static Document transformXML(Document xml, Document xslt)
			throws TransformerException, ParserConfigurationException, FactoryConfigurationError {

		Source xmlSource = new DOMSource(xml);
		Source xsltSource = new DOMSource(xslt);
		DOMResult result = new DOMResult();

		// the factory pattern supports different XSLT processors
		TransformerFactory transFact = TransformerFactory.newInstance();
		Transformer trans = transFact.newTransformer(xsltSource);

		trans.transform(xmlSource, result);

		Document resultDoc = (Document) result.getNode();

		return resultDoc;
	}
	
	public static final Document transformXmlDocument(Document sourceDocument, InputStream xsltFile) {
		DOMSource xmlSource = new DOMSource(sourceDocument);
		StreamSource xsltSource = new StreamSource(xsltFile);
		
		Document transformedData = null;
		
		try {		
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(xsltSource);
			
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			StreamResult result = new StreamResult(output);
			
			transformer.transform(xmlSource, result);
			
			DocumentBuilder resultBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			transformedData = resultBuilder.parse(
				new InputSource(
					new StringReader(
							new String(output.toByteArray())
					)
				)
			);
		} catch (Exception e) {
			System.out.println("XSLT Transformation " + e.getMessage());
			
		}
		
		return transformedData;
	}
}
