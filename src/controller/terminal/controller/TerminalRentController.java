/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

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
	 * Allows to know if a quantity of bikes are available
	 *
	 * @param quantity
	 * @return true if asked quantity of bikes available, else false
	 */
	public boolean getBikesAreAvailable(int quantity) {
		boolean result = false;
		//TODO : Implement
		return result;
	}

	public void doPay() {
		if (TerminalVueStateMachine.change(TerminalVueStateMachine.ACTION_ASK_PAYEMENT)) {
			TerminalController.getMainVue().openTerminalPay();
		}
	}
}
