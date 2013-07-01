/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import controller.terminal.interfacesGUI.TerminalMainVue;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import model.database.TerminalMapper;
import model.object.Terminal;
import resource.log.ProjectLogger;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalController {

	private static TerminalMainVue mainVue;
	private static boolean doAutoCancel;
	private static boolean doAlertBeforeAutoCancel;

	public TerminalController(TerminalMainVue mainVue) {
		setMainVue(mainVue);
		ProcessedData.setTerminal(getTerminalId());
		mainVue.displayTerminalWelcome();
	}

	private static void setMainVue(TerminalMainVue mainVue) {
		TerminalController.mainVue = mainVue;
	}

	public static TerminalMainVue getMainVue() {
		return TerminalController.mainVue;
	}

	public static void setDoAutoCancel(boolean doAutoCancel) {
		TerminalController.doAutoCancel = doAutoCancel;
	}

	public static boolean isDoAutoCancel() {
		return doAutoCancel;
	}

	public static void setDoAlertBeforeAutoCancel(boolean doAlertBeforeAutoCancel) {
		TerminalController.doAlertBeforeAutoCancel = doAlertBeforeAutoCancel;
	}

	public static boolean isDoAlertBeforeAutoCancel() {
		return doAlertBeforeAutoCancel;
	}

	public static void doExit() {
		VueStateMachine.doCancel();
		System.exit(0);
	}

	private static int getTerminalId() {
		int terminalId;
		TerminalMapper terminalMapper;
		List<Terminal> terminals;
		Integer[] possibilities = null;

		terminalMapper = new TerminalMapper();
		try {
			terminals = terminalMapper.getAllTerminals();
			possibilities = new Integer[terminals.size()];
			for (int i = 0; i < terminals.size(); i++) {
				possibilities[i] = new Integer(terminals.get(i).getId());
			}
		} catch (SQLException ex) {
			ProjectLogger.log(TerminalController.class, Level.SEVERE, ex.getMessage(), ex);
		} catch (ClassNotFoundException ex) {
			ProjectLogger.log(TerminalController.class, Level.SEVERE, ex.getMessage(), ex);
		}
		if (possibilities != null && possibilities.length > 0) {
			if (possibilities.length == 1) {
				terminalId = possibilities[0];
			} else {
				Integer i = (Integer) JOptionPane.showInputDialog(
						null,
					"Borne pour quel terminal?",
					"Choix de terminal",
					JOptionPane.PLAIN_MESSAGE,
					null,
					possibilities,
					possibilities[0]);
				if (i != null) {
					terminalId = i.intValue();
				} else {
					terminalId = 0;
					doExit();
				}
			}
		} else {
			terminalId = 0;
		}
		return terminalId;
	}
}
