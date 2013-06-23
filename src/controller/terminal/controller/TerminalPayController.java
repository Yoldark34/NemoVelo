/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import java.sql.Timestamp;
import model.database.BikeUsageMapper;
import tools.Helper;
import model.database.PaymentMapper;
import model.database.PriceMapper;
import model.database.SubscriptionMapper;
import model.object.Subscription;

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

	public RentSummary getRentSummary() {
		PriceMapper pm = new PriceMapper();
		TerminalController.getRentSummary().setGuaranteePerBikeAmount(pm.getFirstGuarantee().getAmount());
		TerminalController.getRentSummary().setDurationPricePerUnit(pm.getPriceAmountForUnitAndDuration(TerminalController.getRentSummary().getDuration(), TerminalController.getRentSummary().getDurationUnit()));
		RentSummary result = TerminalController.getRentSummary();

		return result;
	}

	public void doPay() {
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
}
