/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import controller.terminal.controller.data.ReturnSummary;
import controller.terminal.controller.data.RentSummary;
import java.sql.Timestamp;
import model.database.BikeUsageMapper;
import model.database.PaymentMapper;
import model.database.PriceMapper;
import model.database.SubscriptionMapper;
import model.object.Subscription;
import tools.Helper;

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
		switch (VueStateMachine.getState()) {
			case VueStateMachine.VUE_RENT_PAY:
				amount = ProcessedData.getRentSummary().getTotalAmount();
				break;
			case VueStateMachine.VUE_RETURN_PAY:
				amount = ProcessedData.getReturnSummary().supplementAmount();
				break;
			default:
				amount = 0;
		}
		return amount;
	}

	public boolean isMustConfirmUseTerms() {
		boolean confirm;
		switch (VueStateMachine.getState()) {
			case VueStateMachine.VUE_RENT_PAY:
				confirm = true;
				break;
			case VueStateMachine.VUE_RETURN_PAY:
				confirm = false;
				break;
			default:
				confirm = true;
		}
		return confirm;
	}

	public boolean isMustConfirmPurchaseTerms() {
		boolean confirm;
		switch (VueStateMachine.getState()) {
			case VueStateMachine.VUE_RENT_PAY:
				confirm = true;
				break;
			case VueStateMachine.VUE_RETURN_PAY:
				confirm = false;
				break;
			default:
				confirm = true;
		}
		return confirm;
	}

	public void doPay() {
		switch (VueStateMachine.getState()) {
			case VueStateMachine.VUE_RENT_PAY:
				//Here user pays after a rent
				this.doPayRent();
				break;
			case VueStateMachine.VUE_RETURN_PAY:
				//Here user pays after a return
				this.doPayReturn();
				break;
			default:
				TerminalController.getMainVue().showError("Payment impossible in this situation!");
		}
	}

	private void doPayRent() {
		boolean rentSuccess = false;
		if (VueStateMachine.possibleAction(VueStateMachine.ACTION_DO_PAY)) {
			Timestamp today = Helper.getSqlDateNow();
			RentSummary amountToPay = ProcessedData.getRentSummary();
			PaymentMapper pm = new PaymentMapper();
			SubscriptionMapper sm = new SubscriptionMapper();
			PriceMapper prm = new PriceMapper();
			Subscription subscription = new Subscription();
			subscription.setIdNemoUser(ProcessedData.getAnonymousUserId());
			int priceId = prm.getPriceId(amountToPay.getDurationUnit(), amountToPay.getDuration());
			subscription.setIdPrice(priceId);
			subscription.setAmount(amountToPay.getRentAmount());
			subscription.setStartDate(today);
			int idSubscription = sm.save(subscription);
			if (idSubscription > 0) {
				boolean paymentSuccess = pm.payAmountForNemoUser(ProcessedData.getAnonymousUserId(), amountToPay.getTotalAmount(), today, idSubscription);
				if (paymentSuccess) {
					BikeUsageMapper bum = new BikeUsageMapper();
					rentSuccess = bum.rentBookedBikesForNemoUser(ProcessedData.getAnonymousUserId(), today, ProcessedData.getIdBikeUsagesToDelete());
				}
			}

			if (rentSuccess) {
				VueStateMachine.doAction(VueStateMachine.ACTION_DO_PAY);
			}
		}
	}

	/**
	 * Returns the summary of the rental
	 *
	 * @return summary of the rental
	 */
	public ReturnSummary getReturnSummary() {
		ReturnSummary summary = ProcessedData.getReturnSummary();

		return summary;
	}

	private void doPayReturn() {
		boolean returnSuccess = true;
		if (VueStateMachine.possibleAction(VueStateMachine.ACTION_DO_PAY)) {
			BikeUsageMapper bum = new BikeUsageMapper();
			Timestamp today = Helper.getSqlDateNow();
			ReturnSummary returnSummary = this.getReturnSummary();
			if (returnSummary.size() <= 0) {
				returnSuccess = false;
			} else {
			for (int i = 0; i < returnSummary.size(); i++) {
				if (!bum.returnBikeForTerminal(returnSummary.get(i).getSerialNumber(), today, ProcessedData.getTerminal().getId())) {
					returnSuccess = false;
				}
				}
			}
			if (returnSuccess) {
				VueStateMachine.doAction(VueStateMachine.ACTION_DO_PAY);
			}
		}
	}
}
