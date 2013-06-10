/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import model.database.BikeMapper;
import model.database.BikeUsageMapper;
import model.database.BikeUsageTypeMapper;
import model.database.PriceMapper;
import model.object.Bike;
import model.object.Price;
import model.object.Terminal;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalRentController {

	private static TerminalRentController terminalRentController;
	private BikeMapper bikeMapper = new BikeMapper();
	private BikeUsageMapper bikeUsageMapper = new BikeUsageMapper();
	private Terminal terminal = TerminalController.getTerminal();

	public static TerminalRentController getTerminalRentController() {
		if (terminalRentController == null) {
			terminalRentController = new TerminalRentController();
		}
		return terminalRentController;
	}

	/**
	 * Allows to know the maximal amount of bikes available to rent
	 *
	 * @return quantity of available bikes
	 */
	public int getMaxAvailableBikes() {
		int result = 0;
		result = this.bikeMapper.getAvailableBikesForThisTerminal(this.terminal.getId());
		//Auto cancel?
		if (result == 0) {
			doAutoCancel("No bikes are available on this Terminal");
		}
		return result;
	}

	public Set<String> getPossibleDurationUnits() {
		Set<String> result;
		result = new HashSet<String>();
		PriceMapper pm = new PriceMapper();
		ArrayList<Price> priceResult = new ArrayList<>();
		priceResult = pm.getUniquePriceDurationUnitForRent();

		if (priceResult.size() > 0) {
			for (int i = 0; i < priceResult.size(); ++i) {
				result.add(priceResult.get(i).getPriceDurationUnit());
			}
		} else {
			doAutoCancel("Aucune unité de durée n'a pu être retrouvé.");
		}

		return result;
	}

	public Set<Integer> getPossibleDurations(String durationUnit) {
		Set<Integer> result;
		result = new HashSet<Integer>();
		PriceMapper pm = new PriceMapper();
		ArrayList<Price> priceResult = new ArrayList<>();
		priceResult = pm.getPriceDurationForRent(durationUnit);

		if (priceResult.size() > 0) {
			for (int i = 0; i < priceResult.size(); ++i) {
				result.add(priceResult.get(i).getPriceDuration());
			}
		} else {
			doAutoCancel("Aucune durée n'a pu être retrouvé pour l'unité de durée donné.");
		}
		//Add result values

		return result;
	}

	/**
	 * The user does want rent bikes
	 *
	 * @param nbBikes bikes to reserve during payment
	 * @param duration duration of rental that next has to be payed
	 * @param durationUnit duration unit of retnal that next has to be payed
	 */
	public void doRent(int nbBikes, int duration, String durationUnit) {
		if (TerminalVueStateMachine.possibleAction(TerminalVueStateMachine.ACTION_DO_RENT)) {
			//TODO : Implement Rental
			if (this.bikeUsageMapper.bookAvailableBikesForTerminal(this.terminal.getId(), nbBikes)) {
				TerminalVueStateMachine.doAction(TerminalVueStateMachine.ACTION_DO_RENT);
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
				TerminalController.getMainVue().showAlert(msg);
			}
			doCancel();
		}
	}
}
