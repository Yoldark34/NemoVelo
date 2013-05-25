/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import resource.config.Configuration;
import resource.log.ProjectLogger;

/**
 *
 * @author valentin.seitz
 */
public class Main {

	public static void main(String[] args) {

		ProjectLogger.setUniqueLog(
				Configuration.getParam(
				Configuration.CONFIGSECTION_LOG,
				Configuration.CONFIGPARAM_LOG_UNIQUE)
				.equals(Configuration.BooleanTrue));

	}
}
