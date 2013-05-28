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
public class ReturnPanel extends JPanel implements TerminalReturn {

	public ReturnPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public ReturnPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public ReturnPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public ReturnPanel() {
		initialize();
	}

	private void initialize() {
	}
}
