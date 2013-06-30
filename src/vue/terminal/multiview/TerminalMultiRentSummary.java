/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal.multiview;

import controller.terminal.interfacesGUI.TerminalRentSummary;
import java.util.HashSet;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalMultiRentSummary extends HashSet<TerminalRentSummary> implements TerminalRentSummary {

	@Override
	public void init() {
		for (TerminalRentSummary rentSummaryInstance : this) {
			rentSummaryInstance.init();
		}
	}
}
