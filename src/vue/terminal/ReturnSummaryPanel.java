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
public class ReturnSummaryPanel extends JPanel implements TerminalReturnSummary {

	public ReturnSummaryPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public ReturnSummaryPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public ReturnSummaryPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public ReturnSummaryPanel() {
		initialize();
	}

	private void initialize() {
	}
}
