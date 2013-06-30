/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal.multiview;

import controller.terminal.interfacesGUI.TerminalRent;
import java.util.HashSet;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalMultiRent extends HashSet<TerminalRent> implements TerminalRent {

	@Override
	public void init() {
		for (TerminalRent rentInstance : this) {
			rentInstance.init();
		}
	}
}
