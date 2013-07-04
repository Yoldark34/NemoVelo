/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.terminal.controller.TerminalController;
import controller.terminal.interfacesGUI.TerminalMainVue;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import resource.Resource;
import attachements.config.Configuration;
import resource.log.ProjectLogger;
import vue.terminal.TerminalMainFrame;
import vue.terminal.multiview.TerminalMultiMainVue;
import vue.terminal.secondaryFramed.FramedTerminalManager;

/**
 *
 * @author Valentin SEITZ
 */
public class Main {

	private static final Random random = new Random();

	public static void main(String[] args) {
		int nbFrames;
		TerminalMainVue mainVue;
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
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
		}

		nbFrames = selectNbClonedVues();

		mainVue = getVue(nbFrames);
		controller = new TerminalController(mainVue);

		//Realy instanciate program
		
		TerminalController.setDoAutoCancel(true);
		TerminalController.setDoAlertBeforeAutoCancel(true);

		mainVue.setVisible(true);
	}

	private static int selectNbClonedVues() {
		boolean clonedVue;
		int nbClones;
		Object[] possibilities = {"1", "2", "3", "4"};
		String s = null;

		clonedVue = Configuration.getParam(
				Configuration.CONFIGSECTION_GUI,
				Configuration.CONFIGPARAM_GUI_CLONED)
				.equals(Configuration.BooleanTrue);
		if (clonedVue) {
			s = (String) JOptionPane.showInputDialog(
					null,
					"Nombre de fenêtres ?",
					"Paramètrage d'interface",
					JOptionPane.PLAIN_MESSAGE,
					null,
					possibilities,
					"1");
			if ((s != null) && (s.length() > 0)) {
				nbClones = Integer.parseInt(s);
			} else {
				nbClones = 0;
			}
		} else {
			nbClones = 1;
		}
		return nbClones;
	}

	private static TerminalMainVue getVue(int nbClones) {
		TerminalMainVue mainVue;

		if (nbClones > 1) {
			TerminalMultiMainVue multiMainVue;
			multiMainVue = new TerminalMultiMainVue();
			for (int i = 0; i < nbClones; i++) {
				multiMainVue.add(getVue(1));
			}
			mainVue = multiMainVue;
		} else {
			mainVue = getRandomMainVue();
		}
		return mainVue;
	}

	private static TerminalMainVue getRandomMainVue() {
		TerminalMainVue mainVue;
		URL iconUrl;
		ImageIcon icon;

		if (random.nextBoolean()) {
			TerminalMainFrame mainFrame;
			mainFrame = new TerminalMainFrame();
			{
				mainFrame.setTitle("NemoVelo");
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
			}
			mainVue = mainFrame;
		} else {
			FramedTerminalManager mainFrame;
			mainFrame = new FramedTerminalManager();
			{
				mainFrame.setTitle("NemoVelo");
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
			}
			mainVue = mainFrame;
		}
		return mainVue;
	}
}
