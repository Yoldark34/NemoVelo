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

	/**
	 * Returns the summary of the rental
	 *
	 * @return summary of the rental
	 */
	public RentSummary getRentSummary() {
		RentSummary summary = new RentSummary();

		//TODO : Initialize the summary

		return summary;
	}

	public void doConfirm() {
		//TODO : Know if a rest is to pay
		if (this.getRentSummary().supplementAmount() > 0) {
			//TODO : Actions to do before person pays
			TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_ASK_PAY);
		} else {
			//TODO : Actions to return
			TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_DO_RETURN);
		}
	}
}
