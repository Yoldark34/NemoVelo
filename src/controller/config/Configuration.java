/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.config;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import resource.Resource;

/**
 *
 * @author valentin.seitz
 */
public final class Configuration {

	private static final String CONFIGFILE_NAME = "config.xml";
	public static final String CONFIGSECTION_DB = "db";
	public static final String CONFIGPARAM_DB_URL = "url";
	public static final String CONFIGPARAM_DB_USER = "user";
	public static final String CONFIGPARAM_DB_PASSWORD = "password";
	private static Document document = null;

	/**
	 * Get a param of application
	 *
	 * @param section Name of section
	 * @param param Name of param
	 * @return The asked param, null if an error occurred
	 */
	public static final String getParam(String section, String param) {
		URL fileUrl;
		File file;
		DocumentBuilderFactory documentBuilderFactory;
		DocumentBuilder documentBuilder;
		NodeList paramNodeList;
		Node paramNode;
		String value;

		value = null;
		try {
			//Load document only one time
			if (document == null) {
				fileUrl = Resource.getResource(Resource.CONFIG_FILE);
				//Url ok?
				if (fileUrl != null) {
					file = new File(fileUrl.toURI());
					documentBuilderFactory = DocumentBuilderFactory.newInstance();
					documentBuilder = documentBuilderFactory.newDocumentBuilder();
					Configuration.document = (Document) documentBuilder.parse(file);
				}
			}

			//Document loaded?
			if (document != null) {
				//Creating and evaluating the expression
				XPathFactory fabrique = XPathFactory.newInstance();
				XPath xpath = fabrique.newXPath();
				XPathExpression exp = xpath.compile(
						String.format("/config/section[@name=\"%1$s\"]/param[@name=\"%2$s\"]/@value", section, param));
				paramNodeList = (NodeList) exp.evaluate(document, XPathConstants.NODESET);
				for (int i = 0; i < paramNodeList.getLength(); i++) {
					if (paramNodeList.getLength() == 1) {
						value = paramNodeList.item(0).getTextContent();
					}
				}
			}

		} catch (URISyntaxException ex) {
			Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SAXException ex) {
			Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
		} catch (XPathExpressionException ex) {
			Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
		}
		return value;
	}
}
