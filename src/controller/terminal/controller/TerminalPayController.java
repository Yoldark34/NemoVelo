/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import java.sql.Timestamp;
import model.database.BikeUsageMapper;
import model.database.Helper;
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

	public PayAmount getAmountToPay() {
		PriceMapper pm = new PriceMapper();
		TerminalController.getAmountToPay().setGuaranteeAmount(pm.getFirstGuarantee().getAmount());
		TerminalController.getAmountToPay().setDurationPricePerUnit(pm.getPriceAmountForUnitAndDuration(TerminalController.getAmountToPay().getDuration(), TerminalController.getAmountToPay().getDurationUnit()));
		PayAmount result = TerminalController.getAmountToPay();

		return result;
	}

	public void doPay() {
		boolean rentSuccess = false;
		if (TerminalVueStateMachine.possibleAction(TerminalVueStateMachine.ACTION_DO_PAY)) {
			Timestamp today = Helper.getSqlDateNow();
			PayAmount amountToPay = TerminalController.getAmountToPay();
			PaymentMapper pm = new PaymentMapper();
			SubscriptionMapper sm = new SubscriptionMapper();
			PriceMapper prm = new PriceMapper();
			boolean paymentSuccess = pm.payAmountForNemoUser(TerminalController.getAnonymousUserId(), amountToPay.getTotalAmount(), today);
			if (paymentSuccess) {
				Subscription subscription = new Subscription();
				subscription.setIdNemoUser(TerminalController.getAnonymousUserId());
				int priceId = prm.getPriceId(amountToPay.getDurationUnit(), amountToPay.getDuration());
				subscription.setIdPrice(priceId);
				subscription.setAmount(amountToPay.getTotalAmount());
				subscription.setStartDate(today);
				int nbRow = sm.save(subscription);
				if (nbRow > 0) {
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
