/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.interfacesGUI;

/**
 *
 * @author Valentin SEITZ
 */
public interface TerminalMainVue {

	//Get a vue
	public TerminalWelcome getTerminalWelcome();

	public TerminalRent getTerminalRent();

	public TerminalRentSummary getTerminalRentSummary();

	public TerminalReturn getTerminalReturn();

	public TerminalReturnSummary getTerminalReturnSummary();

	public TerminalPay getTerminalPay();

	//Display a vue

	public void displayTerminalWelcome();

	public void displayTerminalRent();

	public void displayTerminalRentSummary();

	public void displayTerminalReturn();

	public void displayTerminalReturnSummary();

	public void displayTerminalPay();

	//Other possibilities
	public void setVisible(boolean visible);

	public void showInformation(String msg);

	public void showWarning(String msg);

	public void showError(String msg);
}
