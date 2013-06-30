/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal.multiview;

import controller.terminal.interfacesGUI.TerminalWelcome;
import java.util.HashSet;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalMultiWelcome extends HashSet<TerminalWelcome> implements TerminalWelcome {

	@Override
	public void init() {
		for (TerminalWelcome welcomeInstance : this) {
			welcomeInstance.init();
		}
	}
}
