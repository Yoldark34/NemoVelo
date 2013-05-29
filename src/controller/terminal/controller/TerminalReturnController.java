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

	void doReturn() {
		boolean payMissing;
		boolean ok = true;
		if (TerminalVueStateMachine.possibleAction(TerminalVueStateMachine.ACTION_DO_RETURN)
				|| TerminalVueStateMachine.possibleAction(TerminalVueStateMachine.ACTION_ASK_PAY)) {
			//TODO : Know if a rest is to pay
			payMissing = true;
			if (payMissing) {
				//TODO : Actions to do before person pays
				TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_ASK_PAY);
			} else {
				//TODO : Actions to return
				TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_DO_RETURN);
			}
		}
	}
}
