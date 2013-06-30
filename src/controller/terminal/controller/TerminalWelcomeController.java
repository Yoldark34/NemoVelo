/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalWelcomeController {

	private static TerminalWelcomeController terminalWelcomeController;

	public static TerminalWelcomeController getTerminalWelcomeController() {
		if (terminalWelcomeController == null) {
			terminalWelcomeController = new TerminalWelcomeController();
		}
		return terminalWelcomeController;
	}

	public void askRent() {
		VueStateMachine.doAction(VueStateMachine.ACTION_ASK_RENT);
	}

	public void askReturn() {
		VueStateMachine.doAction(VueStateMachine.ACTION_ASK_RETURN);
	}
}
