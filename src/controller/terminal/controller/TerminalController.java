/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import controller.terminal.interfacesGUI.TerminalMainVue;
import model.database.TerminalMapper;
import model.object.Terminal;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalController {

	private static TerminalMainVue mainVue;
	private static Terminal terminal;
	private static boolean doAutoCancel;
	private static boolean doAlertBeforeAutoCancel;

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

	public static TerminalMainVue getMainVue() {
		return TerminalController.mainVue;
	}

	public static Terminal getTerminal() {
		return TerminalController.terminal;
	}

	private static void setMainVue(TerminalMainVue mainVue) {
		TerminalController.mainVue = mainVue;
	}

	public TerminalController(TerminalMainVue mainVue) {
		TerminalMapper terminalMapper = new TerminalMapper();
		terminal = terminalMapper.getTerminal(1);
		setMainVue(mainVue);
		mainVue.displayTerminalWelcome();
	}
}
