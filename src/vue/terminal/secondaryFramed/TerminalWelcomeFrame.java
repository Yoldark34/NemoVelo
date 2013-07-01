/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal.secondaryFramed;

import controller.terminal.controller.TerminalController;
import controller.terminal.interfacesGUI.TerminalWelcome;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import vue.common.BannerPanel;
import vue.terminal.TerminalWelcomePanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalWelcomeFrame extends JFrame implements TerminalWelcome {

	private static final int BANNER_HEIGHT = 50;
	private BannerPanel banner;
	private TerminalWelcomePanel welcomePanel;

	public TerminalWelcomeFrame() throws HeadlessException {
		this.initialize();
	}

	public TerminalWelcomeFrame(GraphicsConfiguration gc) {
		super(gc);
		this.initialize();
	}

	public TerminalWelcomeFrame(String string) throws HeadlessException {
		super(string);
		this.initialize();
	}

	public TerminalWelcomeFrame(String string, GraphicsConfiguration gc) {
		super(string, gc);
		this.initialize();
	}

	private void initialize() {
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent we) {
			}

			@Override
			public void windowClosing(WindowEvent we) {
				TerminalController.doExit();
			}

			@Override
			public void windowClosed(WindowEvent we) {
			}

			@Override
			public void windowIconified(WindowEvent we) {
			}

			@Override
			public void windowDeiconified(WindowEvent we) {
			}

			@Override
			public void windowActivated(WindowEvent we) {
			}

			@Override
			public void windowDeactivated(WindowEvent we) {
			}
		});

		this.setLayout(new BorderLayout());

		this.banner = new BannerPanel();
		{
			this.banner.setPreferredSize(new Dimension((int) (this.banner.getPreferredSize().getWidth()), BANNER_HEIGHT));
		}
		this.add(this.banner, BorderLayout.NORTH);

		this.welcomePanel = new TerminalWelcomePanel();
		this.add(this.welcomePanel, BorderLayout.CENTER);

	}

	@Override
	public void init() {
		this.welcomePanel.init();
	}
}
