/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.common;

import controller.common.interfacesGUI.NemoUserVue;
import java.awt.LayoutManager;
import javax.swing.JPanel;

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
