/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import model.database.PriceMapper;
import model.object.Price;

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

	public PayAmount getAmountToPay() {
		PriceMapper pm = new PriceMapper();
		TerminalController.getAmountToPay().setGuaranteeAmount(pm.getFirstGuarantee().getAmount());
		TerminalController.getAmountToPay().setDurationPricePerUnit(pm.getPriceAmountForUnitAndDuration(TerminalController.getAmountToPay().getDuration(), TerminalController.getAmountToPay().getDurationUnit()));
		PayAmount result = TerminalController.getAmountToPay();

		return result;
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
