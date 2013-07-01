/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal.secondaryFramed;

import controller.terminal.interfacesGUI.TerminalReturnSummary;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import vue.terminal.TerminalReturnSummaryPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalReturnSummaryFrame extends SecondaryFrame implements TerminalReturnSummary {

	private TerminalReturnSummaryPanel returnSummaryPanel;

	public TerminalReturnSummaryFrame() throws HeadlessException {
		this.initialize();
	}

	public TerminalReturnSummaryFrame(GraphicsConfiguration gc) {
		super(gc);
		this.initialize();
	}

	public TerminalReturnSummaryFrame(TerminalReturnSummary returnSummary, String string) throws HeadlessException {
		super(string);
		this.initialize();
	}

	public TerminalReturnSummaryFrame(TerminalReturnSummary returnSummary, String string, GraphicsConfiguration gc) {
		super(string, gc);
		this.initialize();
	}

	private void initialize() {
		this.returnSummaryPanel = new TerminalReturnSummaryPanel();
		this.add(this.returnSummaryPanel);
	}

	@Override
	public void init() {
		this.returnSummaryPanel.init();
	}
}
