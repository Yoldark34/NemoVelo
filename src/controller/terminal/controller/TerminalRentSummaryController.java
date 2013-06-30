/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import controller.terminal.controller.data.RentSummary;
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
		ProcessedData.getRentSummary().setGuaranteePerBikeAmount(pm.getFirstGuarantee().getAmount());
		ProcessedData.getRentSummary().setDurationPricePerUnit(pm.getPriceAmountForUnitAndDuration(ProcessedData.getRentSummary().getDuration(), ProcessedData.getRentSummary().getDurationUnit()));
		RentSummary result = ProcessedData.getRentSummary();

		return result;
	}

	public void askPay() {
		VueStateMachine.doAction(VueStateMachine.ACTION_ASK_PAY);
	}
}
