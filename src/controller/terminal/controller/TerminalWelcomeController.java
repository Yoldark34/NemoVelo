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
		TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_ASK_RENT);
	}

	public void askReturn() {
		TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_ASK_RETURN);
	}
}
