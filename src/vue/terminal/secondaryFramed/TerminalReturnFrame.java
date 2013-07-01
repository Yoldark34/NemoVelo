/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal.secondaryFramed;

import controller.terminal.interfacesGUI.TerminalReturn;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import vue.terminal.TerminalReturnPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalReturnFrame extends SecondaryFrame implements TerminalReturn {

	private TerminalReturnPanel returnPanel;

	public TerminalReturnFrame() throws HeadlessException {
		this.initialize();
	}

	public TerminalReturnFrame(GraphicsConfiguration gc) {
		super(gc);
		this.initialize();
	}

	public TerminalReturnFrame(String string) throws HeadlessException {
		super(string);
		this.initialize();
	}

	public TerminalReturnFrame(String string, GraphicsConfiguration gc) {
		super(string, gc);
		this.initialize();
	}

	private void initialize() {
		this.returnPanel = new TerminalReturnPanel();
		this.add(this.returnPanel);
	}

	@Override
	public void init() {
		this.returnPanel.init();
	}
}
