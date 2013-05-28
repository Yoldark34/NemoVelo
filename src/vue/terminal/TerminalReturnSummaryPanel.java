/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.interfacesGUI.TerminalReturnSummary;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalReturnSummaryPanel extends JPanel implements TerminalReturnSummary {

	public TerminalReturnSummaryPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public TerminalReturnSummaryPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public TerminalReturnSummaryPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public TerminalReturnSummaryPanel() {
		initialize();
	}

	private void initialize() {
	}
}
