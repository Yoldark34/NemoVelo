/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.interfacesGUI.TerminalMainVue;
import controller.terminal.interfacesGUI.TerminalPay;
import controller.terminal.interfacesGUI.TerminalRent;
import controller.terminal.interfacesGUI.TerminalReturn;
import controller.terminal.interfacesGUI.TerminalReturnSummary;
import controller.terminal.interfacesGUI.TerminalWelcome;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalMainFrame extends JFrame implements TerminalMainVue {

	private TerminalWelcome welcomeVue;
	private TerminalRent rentVue;
	private TerminalPay payVue;
	private TerminalReturn returnVue;
	private TerminalReturnSummary returnSummaryVue;

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
		this.welcomeVue = new WelcomePanel();
		//TODO : Affect
	}

	@Override
	public TerminalWelcome getTerminalWelcome() {
		return this.welcomeVue;
	}

	@Override
	public TerminalRent getTerminalRent() {
		return this.rentVue;
	}

	@Override
	public TerminalPay getTerminalPay() {
		return this.payVue;
	}

	@Override
	public TerminalReturn getTerminalReturn() {
		return this.returnVue;
	}

	@Override
	public TerminalReturnSummary getTerminalReturnSummary() {
		return returnSummaryVue;
	}

	@Override
	public void displayTerminalWelcome() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void displayTerminalRent() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void displayTerminalPay() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void displayTerminalReturn() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void displayTerminalReturnSummary() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
