/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

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
				this.doPayRent();
				break;
			case TerminalVueStateMachine.VUE_RETURN_PAY:
				//Here user pays after a return
				this.doPayReturn();
				break;
			default:
				TerminalController.getMainVue().showError("Payment impossible in this situation!");
		}
	}

	private void doPayRent() {
		boolean rentSuccess = false;
		if (TerminalVueStateMachine.possibleAction(TerminalVueStateMachine.ACTION_DO_PAY)) {
			Timestamp today = Helper.getSqlDateNow();
			RentSummary amountToPay = TerminalController.getRentSummary();
			PaymentMapper pm = new PaymentMapper();
			SubscriptionMapper sm = new SubscriptionMapper();
			PriceMapper prm = new PriceMapper();
			Subscription subscription = new Subscription();
			subscription.setIdNemoUser(TerminalController.getAnonymousUserId());
			int priceId = prm.getPriceId(amountToPay.getDurationUnit(), amountToPay.getDuration());
			subscription.setIdPrice(priceId);
			subscription.setAmount(amountToPay.getRentAmount());
			subscription.setStartDate(today);
			int idSubscription = sm.save(subscription);
			if (idSubscription > 0) {
				boolean paymentSuccess = pm.payAmountForNemoUser(TerminalController.getAnonymousUserId(), amountToPay.getTotalAmount(), today, idSubscription);
				if (paymentSuccess) {
					BikeUsageMapper bum = new BikeUsageMapper();
					rentSuccess = bum.rentBookedBikesForNemoUser(TerminalController.getAnonymousUserId(), today);
				}
			}

			if (rentSuccess) {
				TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_DO_PAY);
			}
		}
	}

	private void doPayReturn() {
		boolean returnSuccess = false;
		if (TerminalVueStateMachine.possibleAction(TerminalVueStateMachine.ACTION_DO_PAY)) {
			//TODO : Do here what needs to be done to pay return
			if (returnSuccess) {
				TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_DO_PAY);
			}
		}
	}
}
