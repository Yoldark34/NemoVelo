/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.terminal.controller.TerminalController;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import resource.config.Configuration;
import resource.log.ProjectLogger;
import vue.terminal.TerminalMainFrame;

/**
 *
 * @author Valentin SEITZ
 */
public class Main {

	public static void main(String[] args) {
		TerminalMainFrame mainFrame;
		TerminalController controller;

		//Configure Logger following tha configuration
		ProjectLogger.setUniqueLog(
				Configuration.getParam(
				Configuration.CONFIGSECTION_LOG,
				Configuration.CONFIGPARAM_LOG_UNIQUE)
				.equals(Configuration.BooleanTrue));

		//Set system look and feel
		try {
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		//Realy instanciate program
		mainFrame = new TerminalMainFrame();
		controller = new TerminalController(mainFrame);

		//Centering the frame
		mainFrame.setLocationRelativeTo(null);

		//Display Vue
		mainFrame.setVisible(true);
	}
}
