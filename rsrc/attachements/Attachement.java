/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package attachements;

import java.io.File;

/**
 *
 * @author Valentin SEITZ
 */
public class Attachement {

	//CONFIG
	public static final String CONFIG_FILE = "config.xml";

	public static String getPath(String relativePath) {
		String urlCourante = Attachement.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		urlCourante = (new File(urlCourante)).getParent() + File.separator;
		return urlCourante + relativePath;
	}
}
