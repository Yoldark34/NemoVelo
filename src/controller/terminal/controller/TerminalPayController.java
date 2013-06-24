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

	private TerminalPayController() {
	}

	public float getAmount() {
		float amount;
		switch (TerminalVueStateMachine.getState()) {
			case TerminalVueStateMachine.VUE_RENT_PAY:
				amount = TerminalController.getRentSummary().getTotalAmount();
				break;
			case TerminalVueStateMachine.VUE_RETURN_PAY:
				amount = TerminalController.getReturnSummary().supplementAmount();
				break;
			default:
				amount = 0;
		}
		return amount;
	}

	public boolean isMustConfirmUseTerms() {
		boolean confirm;
		switch (TerminalVueStateMachine.getState()) {
			case TerminalVueStateMachine.VUE_RENT_PAY:
				confirm = true;
				break;
			case TerminalVueStateMachine.VUE_RETURN_PAY:
				confirm = false;
				break;
			default:
				confirm = true;
		}
		return confirm;
	}

	public boolean isMustConfirmPurchaseTerms() {
		boolean confirm;
		switch (TerminalVueStateMachine.getState()) {
			case TerminalVueStateMachine.VUE_RENT_PAY:
				confirm = true;
				break;
			case TerminalVueStateMachine.VUE_RETURN_PAY:
				confirm = false;
				break;
			default:
				confirm = true;
		}
		return confirm;
	}

	public void doPay() {
		switch (TerminalVueStateMachine.getState()) {
			case TerminalVueStateMachine.VUE_RENT_PAY:
				//Here user pays after a rent
				TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_DO_PAY);
				break;
			case TerminalVueStateMachine.VUE_RETURN_PAY:
				//Here user pays after a return
				TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_DO_PAY);
				break;
			default:
				TerminalController.getMainVue().showError("Payment impossible in this situation!");
		}
	}
}
