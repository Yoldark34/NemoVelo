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

	public void openTerminalRent();
	public void opentTerminalWelcome();
}
