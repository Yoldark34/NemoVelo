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

	public void doRent() {
		if (TerminalVueStateMachine.change(TerminalVueStateMachine.ACTION_ASK_RENT)) {
			TerminalController.getMainVue().displayTerminalRent();
		}
	}

	public void doReturn() {
		if (TerminalVueStateMachine.change(TerminalVueStateMachine.ACTION_ASK_RETURN)) {
			TerminalController.getMainVue().displayTerminalReturn();
		}
	}
}
