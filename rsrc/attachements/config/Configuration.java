/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package attachements.config;

import attachements.Attachement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import resource.Resource;
import resource.log.ProjectLogger;

/**
 *
 * @author Valentin SEITZ
 */
public final class Configuration {

	public static final String BooleanTrue = Boolean.toString(true);
	public static final String BooleanFalse = Boolean.toString(false);
	public static final String CONFIGSECTION_DB = "db";
	public static final String CONFIGPARAM_DB_URL = "url";
	public static final String CONFIGPARAM_DB_USER = "user";
	public static final String CONFIGPARAM_DB_PASSWORD = "password";
	public static final String CONFIGSECTION_LOG = "log";
	public static final String CONFIGPARAM_LOG_UNIQUE = "unique";
	public static final String CONFIGSECTION_GUI = "gui";
	public static final String CONFIGPARAM_GUI_CLONED = "cloned";
	private static Document document = null;

	/**
	 * Get a param of application
	 *
	 * @param sectionName Name of section
	 * @param paramName Name of param
	 * @return The asked param, null if an error occurred, "" if not found or
	 * not set
	 */
	public static String getParam(String sectionName, String paramName) {
		File file;
		DocumentBuilderFactory documentBuilderFactory;
		DocumentBuilder documentBuilder;
		XPathFactory xpathFactory;
		XPath xpath;
		String xpathText;
		XPathExpression xpathExpression;
		String value;

		value = null;
		xpathText = "";
		try {
			//Load document only one time
			if (document == null) {
				file = new File(Attachement.getPath(Attachement.CONFIG_FILE));
					documentBuilderFactory = DocumentBuilderFactory.newInstance();
					documentBuilder = documentBuilderFactory.newDocumentBuilder();
					Configuration.document = (Document) documentBuilder.parse(file);
			}

			//Document loaded?
			if (document != null) {
				//Creating and evaluating the expression
				xpathFactory = XPathFactory.newInstance();
				xpath = xpathFactory.newXPath();
				xpathText = String.format("/config/section[@name=\"%1$s\"]/param[@name=\"%2$s\"]/@value", sectionName, paramName);
				xpathExpression = xpath.compile(xpathText);
				value = (String) xpathExpression.evaluate(document, XPathConstants.STRING);
			}

		} catch (ParserConfigurationException e) {
			ProjectLogger.log(new Configuration(), Level.SEVERE,
					"Error in the configuration of the parser", e);
		} catch (SAXException e) {
			ProjectLogger.log(new Configuration(), Level.SEVERE,
					"", e);
		} catch (IOException e) {
			ProjectLogger.log(new Configuration(), Level.SEVERE,
					"", e);
		} catch (XPathExpressionException e) {
			ProjectLogger.log(new Configuration(), Level.SEVERE,
					String.format("Error in the XPath '%1$s'", xpathText), e);
		}
		return value;
	}
}
