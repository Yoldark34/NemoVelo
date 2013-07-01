/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal.secondaryFramed;

import controller.terminal.interfacesGUI.TerminalRent;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import vue.terminal.TerminalRentPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalRentFrame extends SecondaryFrame implements TerminalRent {

	private TerminalRentPanel rentPanel;

	public TerminalRentFrame() throws HeadlessException {
		this.initialize();
	}

	public TerminalRentFrame(GraphicsConfiguration gc) {
		super(gc);
		this.initialize();
	}

	public TerminalRentFrame(String string) throws HeadlessException {
		super(string);
		this.initialize();
	}

	public TerminalRentFrame(String string, GraphicsConfiguration gc) {
		super(string, gc);
		this.initialize();
	}

	private void initialize() {
		this.rentPanel = new TerminalRentPanel();
		this.add(this.rentPanel);
	}

	@Override
	public void init() {
		this.rentPanel.init();
	}
}
