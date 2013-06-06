/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalReturnSummaryController {

	private static TerminalReturnSummaryController terminalReturnSummaryController;

	public static TerminalReturnSummaryController getTerminalReturnSummaryController() {
		if (terminalReturnSummaryController == null) {
			terminalReturnSummaryController = new TerminalReturnSummaryController();
		}
		return terminalReturnSummaryController;
	}

	public void doConfirm() {
		TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_DO_CONFIRM_RETURN);
	}
}
