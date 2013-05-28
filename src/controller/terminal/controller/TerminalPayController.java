/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalPayController {

	private static TerminalPayController terminalPayController;

	public static TerminalPayController getTerminalPayController() {
		if (terminalPayController == null) {
			terminalPayController = new TerminalPayController();
		}
		return terminalPayController;
	}
}
