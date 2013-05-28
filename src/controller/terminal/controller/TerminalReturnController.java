/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalReturnController {

	private static TerminalReturnController terminalReturnController;

	public static TerminalReturnController getTerminalReturnController() {
		if (terminalReturnController == null) {
			terminalReturnController = new TerminalReturnController();
		}
		return terminalReturnController;
	}
}
