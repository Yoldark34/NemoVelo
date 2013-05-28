/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.interfacesGUI.TerminalReturn;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalReturnPanel extends JPanel implements TerminalReturn {

	public TerminalReturnPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public TerminalReturnPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public TerminalReturnPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public TerminalReturnPanel() {
		initialize();
	}

	private void initialize() {
	}
}
