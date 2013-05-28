/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.interfacesGUI.TerminalMainVue;
import controller.terminal.interfacesGUI.TerminalRent;
import controller.terminal.interfacesGUI.TerminalWelcome;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author valentin.seitz
 */
public class TerminalMainFrame extends JFrame implements TerminalMainVue {

	private TerminalWelcome welcome;
	private TerminalRent rent;

	public TerminalMainFrame() throws HeadlessException {
		initialize();
	}

	public TerminalMainFrame(GraphicsConfiguration gc) {
		super(gc);
		initialize();
	}

	public TerminalMainFrame(String string) throws HeadlessException {
		super(string);
		initialize();
	}

	public TerminalMainFrame(String string, GraphicsConfiguration gc) {
		super(string, gc);
		initialize();
	}

	private void initialize() {
		this.welcome = new WelcomePanel();
	}

	@Override
	public TerminalWelcome getTerminalWelcome() {
		return this.welcome;
	}

	@Override
	public TerminalRent getTerminalRent() {
		return this.rent;
	}

	@Override
	public void openTerminalRent() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void opentTerminalWelcome() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
