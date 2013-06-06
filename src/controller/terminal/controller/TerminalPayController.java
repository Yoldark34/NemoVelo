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

	public void doPay() {
		boolean ok = true;
		if (TerminalVueStateMachine.possibleAction(TerminalVueStateMachine.ACTION_DO_PAY)) {
			//TODO : Implement Payment
			if (ok) {
				TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_DO_PAY);
			}
		}
	}
}
