/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.interfacesGUI;

/**
 *
 * @author valentin.seitz
 */
public interface TerminalMainVue {

	public TerminalWelcome getTerminalWelcome();
	public TerminalRent getTerminalRent();
	public TerminalPay getTerminalPay();

	public void displayTerminalWelcome();
	public void displayTerminalRent();
	public void displayTerminalPay();
}
