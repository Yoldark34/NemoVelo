/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.config;

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

	public static final String getParam(String section, String param) throws ParserConfigurationException, SAXException, IOException {
		String value;
		NodeList sectionList;
		NodeList paramList;

		//Load file only one time
		if (document == null) {
			File file = new File(CONFIGFILE_NAME);
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Configuration.document = (Document) documentBuilder.parse(file);
		}

		//TODO : Get the value of param
		value = "";

		return value;
	}
}
