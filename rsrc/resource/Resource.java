/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource;

import resource.config.Configuration;
import java.net.URL;
import java.util.logging.Level;
import resource.log.ProjectLogger;

/**
 *
 * @author Valentin SEITZ
 */
public class Resource {

	private static final String FOLDER_SEPARTOR = "/";
	private static final String RESOURCE_FOLDER = FOLDER_SEPARTOR + "resource";
	//CONFIG
	private static final String CONFIG_FOLDER = RESOURCE_FOLDER + FOLDER_SEPARTOR + "config";
	public static final String CONFIG_FILE = CONFIG_FOLDER + FOLDER_SEPARTOR + "config.xml";
	//IMAGES
	private static final String IMAGE_FOLDER = RESOURCE_FOLDER + FOLDER_SEPARTOR + "image";
	//BANNER
	private static final String BANNER_FOLDER = IMAGE_FOLDER + FOLDER_SEPARTOR + "banner";
	public static final String IMAGE_BANNER = BANNER_FOLDER + FOLDER_SEPARTOR + "banner.png";
	//STATE
	private static final String STATE_FOLDER = IMAGE_FOLDER + FOLDER_SEPARTOR + "state";
	public static final String IMAGE_VALID = STATE_FOLDER + FOLDER_SEPARTOR + "valid.png";
	public static final String IMAGE_INVALID = STATE_FOLDER + FOLDER_SEPARTOR + "invalid.png";

	public static URL getResource(String path) {
		Resource r = new Resource();
		URL resourceUrl = r.getClass().getResource(path);
		if (resourceUrl == null) {
			ProjectLogger.log(new Resource(), Level.WARNING, null,
					new NullPointerException(String.format("file '%1$s' not found", path)));
		}
		return resourceUrl;
	}
}
