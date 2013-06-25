/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import model.database.PriceMapper;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalRentSummaryController {

	private static TerminalRentSummaryController terminalPayController;

	public static TerminalRentSummaryController getTerminalPayController() {
		if (terminalPayController == null) {
			terminalPayController = new TerminalRentSummaryController();
		}
		return terminalPayController;
	}

	public RentSummary getRentSummary() {
		PriceMapper pm = new PriceMapper();
		TerminalController.getRentSummary().setGuaranteePerBikeAmount(pm.getFirstGuarantee().getAmount());
		TerminalController.getRentSummary().setDurationPricePerUnit(pm.getPriceAmountForUnitAndDuration(TerminalController.getRentSummary().getDuration(), TerminalController.getRentSummary().getDurationUnit()));
		RentSummary result = TerminalController.getRentSummary();

		return result;
	}

	public void askPay() {
		TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_ASK_PAY);
	}
}
