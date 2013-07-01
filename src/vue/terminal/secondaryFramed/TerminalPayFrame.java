/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal.secondaryFramed;

import controller.terminal.interfacesGUI.TerminalPay;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import vue.terminal.TerminalPayPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalPayFrame extends SecondaryFrame implements TerminalPay {

	private TerminalPayPanel payPanel;

	public TerminalPayFrame() throws HeadlessException {
		this.initialize();
	}

	public TerminalPayFrame(GraphicsConfiguration gc) {
		super(gc);
		this.initialize();
	}

	public TerminalPayFrame(String string) throws HeadlessException {
		super(string);
		this.initialize();
	}

	public TerminalPayFrame(String string, GraphicsConfiguration gc) {
		super(string, gc);
		this.initialize();
	}

	private void initialize() {
		this.payPanel = new TerminalPayPanel();
		this.add(this.payPanel);
	}

	@Override
	public void init() {
		this.payPanel.init();
	}
}
