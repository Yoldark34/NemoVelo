/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import java.sql.Timestamp;
import model.database.BikeUsageMapper;
import tools.Helper;

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
	public ReturnSummary getReturnSummary() {
		ReturnSummary summary = TerminalController.getReturnSummary();

		return summary;
	}

	public void doConfirm() {
		boolean success = true;
		//TODO : Know if a rest is to pay
		if (this.getReturnSummary().supplementAmount() > 0) {
			//TODO : Actions to do before person pays
			TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_ASK_PAY);
		} else {
			BikeUsageMapper bum = new BikeUsageMapper();
			Timestamp today = Helper.getSqlDateNow();
			for (int i = 0; i < this.getReturnSummary().size(); i++) {
				if (!bum.returnBike(this.getReturnSummary().get(i).getSerialNumber(), today)) {
					success = false;
				}
			}
			TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_DO_RETURN);
		}
	}
}
