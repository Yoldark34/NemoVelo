/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import controller.terminal.interfacesGUI.TerminalMainVue;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalController {

	private static TerminalMainVue mainVue;

	public static TerminalMainVue getMainVue() {
		return TerminalController.mainVue;
	}

	private static void setMainVue(TerminalMainVue mainVue) {
		TerminalController.mainVue = mainVue;
	}

	public TerminalController(TerminalMainVue mainVue) {
		setMainVue(mainVue);
	}
}
