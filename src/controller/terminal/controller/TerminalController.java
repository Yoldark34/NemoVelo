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
