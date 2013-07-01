/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal.secondaryFramed;

import controller.terminal.interfacesGUI.TerminalRentSummary;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import vue.terminal.TerminalRentSummaryPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalRentSummaryFrame extends SecondaryFrame implements TerminalRentSummary {

	private TerminalRentSummaryPanel rentSummaryPanel;

	public TerminalRentSummaryFrame() throws HeadlessException {
		this.initialize();
	}

	public TerminalRentSummaryFrame(GraphicsConfiguration gc) {
		super(gc);
		this.initialize();
	}

	public TerminalRentSummaryFrame(String string) throws HeadlessException {
		super(string);
		this.initialize();
	}

	public TerminalRentSummaryFrame(String string, GraphicsConfiguration gc) {
		super(string, gc);
		this.initialize();
	}

	private void initialize() {
		this.rentSummaryPanel = new TerminalRentSummaryPanel();
		this.add(this.rentSummaryPanel);
	}

	@Override
	public void init() {
		this.rentSummaryPanel.init();
	}
}
