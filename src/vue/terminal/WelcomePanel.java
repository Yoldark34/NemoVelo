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
public class WelcomePanel extends JPanel implements TerminalWelcome {

	public WelcomePanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public WelcomePanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public WelcomePanel(boolean bln) {
		super(bln);
		initialize();
	}

	public WelcomePanel() {
		initialize();
	}

	private void initialize() {
	}
}
