/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.terminal.controller.TerminalController;
import resource.config.Configuration;
import resource.log.ProjectLogger;
import vue.terminal.TerminalMainFrame;

/**
 *
 * @author valentin.seitz
 */
public class Main {

	public static void main(String[] args) {
		TerminalMainFrame mainFrame;
		TerminalController controller;

		ProjectLogger.setUniqueLog(
				Configuration.getParam(
				Configuration.CONFIGSECTION_LOG,
				Configuration.CONFIGPARAM_LOG_UNIQUE)
				.equals(Configuration.BooleanTrue));

		mainFrame = new TerminalMainFrame();
		controller = new TerminalController(mainFrame);

		mainFrame.setVisible(true);

	}
}
