/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.interfacesGUI.TerminalPay;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class PayPanel extends JPanel implements TerminalPay {

	public PayPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public PayPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public PayPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public PayPanel() {
		initialize();
	}

	private void initialize() {
	}
}
