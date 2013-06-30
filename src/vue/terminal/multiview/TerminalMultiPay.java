/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal.multiview;

import controller.terminal.interfacesGUI.TerminalPay;
import java.util.HashSet;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalMultiPay extends HashSet<TerminalPay> implements TerminalPay {

	@Override
	public void init() {
		for (TerminalPay payInstance : this) {
			payInstance.init();
		}
	}
}
