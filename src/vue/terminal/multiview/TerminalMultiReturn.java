/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal.multiview;

import controller.terminal.interfacesGUI.TerminalReturn;
import java.util.HashSet;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalMultiReturn extends HashSet<TerminalReturn> implements TerminalReturn {

	@Override
	public void init() {
		for (TerminalReturn returnInstance : this) {
			returnInstance.init();
		}
	}
}
