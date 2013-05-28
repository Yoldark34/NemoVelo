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
public class RentPanel extends JPanel implements TerminalRent {

	public RentPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public RentPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public RentPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public RentPanel() {
		initialize();
	}

	private void initialize() {
	}
}
