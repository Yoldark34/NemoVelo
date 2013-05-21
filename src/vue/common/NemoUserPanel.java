/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.common;

import javax.swing.JPanel;
import controller.interfacesGUI.NemoUserVue;
import java.awt.LayoutManager;

/**
 *
 * @author valentin.seitz
 */
public class NemoUserPanel extends JPanel implements NemoUserVue {

	public NemoUserPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		this.initialize();
	}

	public NemoUserPanel(LayoutManager layout) {
		super(layout);
		this.initialize();
	}

	public NemoUserPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		this.initialize();
	}

	public NemoUserPanel() {
		this.initialize();
	}

	private void initialize() {
	}
}
