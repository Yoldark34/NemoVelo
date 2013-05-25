/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.managment;

import controller.common.interfacesGUI.BikeVue;
import controller.common.interfacesGUI.NemoUserVue;
import controller.managment.interfacesGUI.ManagmentMainVue;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import vue.common.BikePanel;
import vue.common.NemoUserPanel;

/**
 *
 * @author valentin.seitz
 */
public class ManagmentMainFrame extends JFrame implements ManagmentMainVue {

	private BikePanel bikePanel;
	private NemoUserPanel nemoUserPanel;

	public ManagmentMainFrame() throws HeadlessException {
		super();
		this.initialize();
	}

	public ManagmentMainFrame(GraphicsConfiguration gc) {
		super(gc);
		this.initialize();
	}

	public ManagmentMainFrame(String title) throws HeadlessException {
		super(title);
		this.initialize();
	}

	public ManagmentMainFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		this.initialize();
	}

	private void initialize() {
		this.bikePanel = new BikePanel();
		this.nemoUserPanel = new NemoUserPanel();
	}

	@Override
	public BikeVue getBikeVue() {
		return this.bikePanel;
	}

	@Override
	public NemoUserVue getNemoUserVue() {
		return this.nemoUserPanel;
	}
}
