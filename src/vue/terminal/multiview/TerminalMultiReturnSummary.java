/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal.multiview;

import controller.terminal.interfacesGUI.TerminalReturnSummary;
import java.util.HashSet;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalMultiReturnSummary extends HashSet<TerminalReturnSummary> implements TerminalReturnSummary {

	@Override
	public void init() {
		for (TerminalReturnSummary returnSummaryInstance : this) {
			returnSummaryInstance.init();
		}
	}
}
