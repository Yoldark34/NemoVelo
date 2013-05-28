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
public class TerminalPayPanel extends JPanel implements TerminalPay {

	public TerminalPayPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public TerminalPayPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public TerminalPayPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public TerminalPayPanel() {
		initialize();
	}

	private void initialize() {
	}
}
