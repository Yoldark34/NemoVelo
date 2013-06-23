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
import model.database.NemoUserMapper;
import tools.Helper;
import model.database.PriceMapper;
import model.database.ReturnAmountMapper;
import model.database.StorageMapper;
import model.database.SubscriptionMapper;
import model.object.Bike;
import model.object.BikeUsage;
import model.object.NemoUser;
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
		if (result == 0) {
			doAutoCancel("Aucun emplacement disponible sur ce terminal.");
		}
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
		if (TerminalVueStateMachine.possibleAction(TerminalVueStateMachine.ACTION_DO_RETURN)
				|| TerminalVueStateMachine.possibleAction(TerminalVueStateMachine.ACTION_ASK_PAY)) {
			Timestamp today = Helper.getSqlDateNow();
			BikeUsageMapper bum = new BikeUsageMapper();
			SubscriptionMapper sm = new SubscriptionMapper();
			PriceMapper pm = new PriceMapper();
			ReturnAmountMapper ram = new ReturnAmountMapper();
			NemoUserMapper num = new NemoUserMapper();
			ArrayList<NemoUser> nemoUsers = num.getNemoUsersFromBikes(bikeSerialNumbers);

			if (nemoUsers.size() == 1) {
				int idNemoUser = nemoUsers.get(0).getId();
				ArrayList<Subscription> subscriptions = sm.getSubscriptionsFromNemoUser(idNemoUser);

				ReturnAmount ra;
				ArrayList<BikeUsage> bikes;
				RentSummary rs = new RentSummary();
				Price p;
				ReturnSummary summary = new ReturnSummary();
				for (int i = 0; i < subscriptions.size(); i++) {
					p = pm.GetPriceFromId(subscriptions.get(i).getIdPrice());
					bikes = bum.getBikesFromNemoUserAndDateForBikes(subscriptions.get(i).getIdNemoUser(), subscriptions.get(i).getStartDate(), bikeSerialNumbers);
					for (int j = 0; j < bikes.size(); j++) {
						BikeReturnSummary brs = new BikeReturnSummary();
						rs.setBikeQuantity(bikes.size());
						rs.setDurationUnit(p.getPriceDurationUnit());
						rs.setDurationPricePerUnit(p.getAmount());
						Timestamp start = (Timestamp) bikes.get(j).getStartDate();
						int finalDuration = Helper.getDifference(start, today, p.getPriceDurationUnit());
						if (finalDuration < p.getPriceDuration()) {
							finalDuration = p.getPriceDuration();
						}
						rs.setMultiplier(Helper.divide(finalDuration, p.getPriceDuration()));
						rs.setDuration(p.getPriceDuration());
						ra = new ReturnAmount();
						ra.setAmount(rs.getRentAmount());
						ra.setIdSubscription(subscriptions.get(i).getId());
						ra.setReturnDate(today);
						ram.save(ra);
						brs.setDurationUnit(p.getPriceDurationUnit());
						brs.setInitialDuration(p.getPriceDuration());
						brs.setInitialAmount(p.getAmount());
						brs.setFinalAmount(rs.getRentAmount());
						brs.setFinalDuration(finalDuration);
						brs.setSerialNumber(bikes.get(j).getIdBike());
						summary.add(brs);
					}
				}
				summary.setGuaranteePerBike(pm.getFirstGuarantee().getAmount());
				TerminalController.setReturnSummary(summary);
				TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_DO_RETURN);
			} else {
				doAutoCancel("Ces vélos ne sont pas attribué au meme NemoUser.");
			}
		}
	}

	private void doCancel() {
		boolean ok = true;
		if (TerminalVueStateMachine.possibleAction(TerminalVueStateMachine.ACTION_DO_CANCEL)) {
			//TODO : Implement Cancel
			if (ok) {
				TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_DO_CANCEL);
			}
		}
	}

	private void doAutoCancel(String msg) {
		if (TerminalController.isDoAutoCancel()) {
			if (TerminalController.isDoAlertBeforeAutoCancel()) {
				TerminalController.getMainVue().showWarning(msg);
			}
			doCancel();
		}
	}
}
