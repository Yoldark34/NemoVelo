/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import model.database.BikeMapper;
import model.database.BikeUsageMapper;
import model.database.Helper;
import model.database.PriceMapper;
import model.database.ReturnAmountMapper;
import model.database.StorageMapper;
import model.database.SubscriptionMapper;
import model.object.Bike;
import model.object.BikeUsage;
import model.object.Price;
import model.object.ReturnAmount;
import model.object.Subscription;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalReturnController {

	private static TerminalReturnController terminalReturnController;

	public static TerminalReturnController getTerminalReturnController() {
		if (terminalReturnController == null) {
			terminalReturnController = new TerminalReturnController();
		}
		return terminalReturnController;
	}

	/**
	 * Know the maximal quantity of bikes which can be returned to the current
	 * terminal
	 *
	 * @return Qunetity of available storages
	 */
	public int getMaxAvailableStorages() {
		int result;
		StorageMapper sm = new StorageMapper();
		result = sm.getAvailableStoragesForTerminal(TerminalController.getTerminal().getId());

		return result;
	}

	/**
	 * Know the serial numbers of all currently rented bikes
	 *
	 * @return The serial numbers of currently rented bikes
	 */
	public Set<Integer> getRentedBikeSerialNumbers() {
		Set<Integer> result = new HashSet<>();
		BikeMapper bm = new BikeMapper();
		ArrayList<Bike> resultBikes = bm.getRentedBikesForThisTerminal(TerminalController.getTerminal().getId());
		if (resultBikes.size() > 0) {
			for (int i = 0; i < resultBikes.size(); ++i) {
				result.add(resultBikes.get(i).getId());
			}
		}

		return result;
	}

	/**
	 * Return some bike(s) to the terminal
	 *
	 * @param bikeSerialNumbers Set of Serial numbers of the returned bikes
	 */
	public void doReturn(Set<Integer> bikeSerialNumbers) {
		bikeSerialNumbers.add(1);
		boolean payMissing;
		boolean ok = true;
		if (TerminalVueStateMachine.possibleAction(TerminalVueStateMachine.ACTION_DO_RETURN)
				|| TerminalVueStateMachine.possibleAction(TerminalVueStateMachine.ACTION_ASK_PAY)) {
			Timestamp today = Helper.getSqlDateNow();
			BikeUsageMapper bum = new BikeUsageMapper();
			SubscriptionMapper sm = new SubscriptionMapper();
			PriceMapper pm = new PriceMapper();
			ReturnAmountMapper ram = new ReturnAmountMapper();
			int idNemoUser = bum.getNemoUserIdFromBikes(bikeSerialNumbers);
			ArrayList<Subscription> subscriptions = sm.getSubscriptionsForNemoUserFromBikes(idNemoUser);

			ReturnAmount ra;
			ArrayList<BikeUsage> bikes = new ArrayList<>();
			PayAmount pa = new PayAmount();
			Price p;
			for (int i = 0; i < subscriptions.size(); i++) {
				p = pm.GetPriceFromId(subscriptions.get(i).getIdPrice());
				bikes = bum.getBikesFromNemoUserAndDateForBikes(subscriptions.get(i).getIdNemoUser(), subscriptions.get(i).getStartDate(), bikeSerialNumbers);
				for (int j = 0; j < bikes.size(); j++) {
					pa.setBikeQuantity(bikes.size());
					pa.setDurationUnit(p.getPriceDurationUnit());
					pa.setDurationPricePerUnit(p.getAmount());
					Timestamp start = (Timestamp) bikes.get(j).getStartDate();
					int finalDuration = Helper.getDifference(start, today, p.getPriceDurationUnit());
					pa.setDuration(finalDuration);
					ra = new ReturnAmount();
					ra.setAmount(pa.getRentAmount());
					ra.setIdSubscription(subscriptions.get(i).getId());
					ra.setReturnDate(today);
					ram.save(ra);
				}
			}
			//TODO : Know if a rest is to pay
			payMissing = true;
			if (payMissing) {
				//TODO : Actions to do before person pays
				TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_ASK_PAY);
			} else {
				//TODO : Actions to return
				TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_DO_RETURN);
			}
		}
	}
}
