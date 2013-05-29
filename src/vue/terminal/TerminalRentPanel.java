/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.controller.TerminalPayController;
import controller.terminal.controller.TerminalRentController;
import controller.terminal.interfacesGUI.TerminalRent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalRentPanel extends JPanel implements TerminalRent {

	private JPanel panelActions;
	private JButton btnRent;

	public TerminalRentPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public TerminalRentPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public TerminalRentPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public TerminalRentPanel() {
		initialize();
	}

	private void initialize() {
		this.setLayout(new BorderLayout());

		this.panelActions = new JPanel();
		{
			this.panelActions.setLayout(new GridLayout(1, 1));

			this.btnRent = new JButton("Louer");
			{
				this.btnRent.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						TerminalRentController.getTerminalRentController().doRent();
					}
				});
			}
			this.panelActions.add(this.btnRent);
			//TODO : Add Sign in button
		}
		this.add(this.panelActions, BorderLayout.CENTER);
	}
}
