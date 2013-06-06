/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import model.database.BikeMapper;
import model.object.Terminal;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalRentController {

	private static TerminalRentController terminalRentController;

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
		Terminal terminal = TerminalController.getTerminal();
		BikeMapper bikeMapper = new BikeMapper();
		result = bikeMapper.getAvailableBikesForThisTerminal(terminal.getId());
		//TODO
		//Auto cancel?
		if (result == 0) {
			doAutoCancel("No bikes are available on this Terminal");
		}
		return result;
	}

	public void doRent() {
		boolean ok = true;
		if (TerminalVueStateMachine.possibleAction(TerminalVueStateMachine.ACTION_DO_RENT)) {
			//TODO : Implement Payment
			if (ok) {
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
