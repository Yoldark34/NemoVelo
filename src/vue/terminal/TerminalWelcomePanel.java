/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.interfacesGUI.TerminalWelcome;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalWelcomePanel extends JPanel implements TerminalWelcome {

	public TerminalWelcomePanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public TerminalWelcomePanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public TerminalWelcomePanel(boolean bln) {
		super(bln);
		initialize();
	}

	public TerminalWelcomePanel() {
		initialize();
	}

	private void initialize() {
	}
}
