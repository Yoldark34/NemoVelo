/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.terminal.controller.TerminalController;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import resource.Resource;
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
		URL iconUrl;
		ImageIcon icon;
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
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (UnsupportedLookAndFeelException e) {
		}

		//Realy instanciate program
		mainFrame = new TerminalMainFrame();
		controller = new TerminalController(mainFrame);
		TerminalController.setDoAutoCancel(true);
		TerminalController.setDoAlertBeforeAutoCancel(true);

		iconUrl = Resource.getResource(Resource.IMAGE_LOGO);
		if (iconUrl != null) {
			icon = new ImageIcon(iconUrl);
			//		/!\ icon can be null if the resource iconUrl doesn't exit! /!\
			if (icon != null) {
				mainFrame.setIconImage(icon.getImage());
			}
		}

		//Setting minimum size of frame
		mainFrame.setMinimumSize(mainFrame.getPreferredSize());
		mainFrame.pack();

		//Centering the frame
		mainFrame.setLocationRelativeTo(null);

		//Display Vue
		mainFrame.setVisible(true);
	}
}
