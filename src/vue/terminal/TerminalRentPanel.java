/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.interfacesGUI.TerminalRent;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalRentPanel extends JPanel implements TerminalRent {

	public TerminalRentPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public TerminalRentPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public TerminalRentPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public TerminalRentPanel() {
		initialize();
	}

	private void initialize() {
	}
}
