/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package resource.log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valentin SEITZ
 */
public class ProjectLogger {

	private static boolean uniqueLog;

	public static boolean isUniqueLog() {
		return uniqueLog;
	}

	public static void setUniqueLog(boolean uniqueLog) {
		ProjectLogger.uniqueLog = uniqueLog;
	}

	public static void log(Object parent, Level level, String msg) {
		if (!uniqueLog && parent != null) {
			Logger.getLogger(parent.getClass().getName()).log(level, msg);
		} else {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(level, msg);
		}
		
	}

	public static void log(Object parent, Level level, String msg, Throwable thrown) {
		if (!uniqueLog && parent != null) {
			Logger.getLogger(parent.getClass().getName()).log(level, msg, thrown);
		} else {
			Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(level, msg, thrown);
		}

	}
}
